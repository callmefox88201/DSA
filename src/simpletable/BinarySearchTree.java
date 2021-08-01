package simpletable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinarySearchTree<Key extends Comparable<Key>, Value> extends AbstractSimpleTable<Key, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null)
            return new Node(key, value);
        int c = key.compareTo(node.key);
        if (c < 0) {
            node.left = put(node.left, key, value);
        } else if (c > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    public Value get(Key key) {
        Node node = root;
        while (node != null) {
            int c = key.compareTo(node.key);
            if (c < 0) {
                node = node.left;
            } else if (c > 0) {
                node = node.right;
            } else
                return node.value;
        }
        return null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        List<Node> list = new ArrayList<>();
        list.add(root);
        int count = 0;

        while (!list.isEmpty()) {
            Node p = list.remove(0);
            if (p.value != null)
                count++;
            if (p.left != null)
                list.add(p.left);
            if (p.right != null)
                list.add(p.right);
        }
        return count;
    }

    public void delete(Key key) {
        if (get(key) == null)
            return;
        put(key, null);
    }

    public Iterable<Key> keys() {
        return new Iterable<Key>() {
            public Iterator<Key> iterator() {
                return new BinarySearchTreeIterator();
            }
        };
    }

    private class BinarySearchTreeIterator implements Iterator<Key> {
        private Queue<Key> queue;

        public BinarySearchTreeIterator() {
            queue = new LinkedListQueue<Key>();
            inorder(root);
        }

        private void inorder(Node node) {
            if (node != null) {
                inorder(node.left);
                queue.enqueue(node.key);
                inorder(node.right);
            }
        }

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return !queue.isEmpty();
        }

        @Override
        public Key next() {
            // TODO Auto-generated method stub
            return queue.dequeue();
        }
    }
}