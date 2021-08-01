// package simpletable;

// public class LinkedListOrderedSimpleTable<Key extends Comparable<Key>, Value>
//         implements OrderedSimpleTable<Key, Value> {

//     private Node root;

//     private class Node {
//         private Key key;
//         private Value value;
//         private Node left, right;
//         private int count;

//         Node(Key key, Value value) {
//             this.key = key;
//             this.value = value;
//             this.count = 1;
//         }
//     }

//     @Override
//     public void put(Key key, Value value) {
//         // TODO Auto-generated method stub
//         root = put(root, key, value);
//     }

//     private Node put(Node node, Key key, Value value) {
//         if (node == null)
//             return new Node(key, value);
//         int c = key.compareTo(node.key);
//         if (c < 0) {
//             node.left = put(node.left, key, value);
//         } else if (c > 0) {
//             node.right = put(node.right, key, value);
//         } else {
//             node.value = value;
//         }
//         node.count = 1 + size(node.left) + size(node.right);
//         return node;
//     }

//     @Override
//     public Value get(Key key) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     private Node delete(Node node, Key key) {
//         if (node == null)
//             return null;
//         int c = key.compareTo(node.key);
//         if (c < 0)
//             node.left = delete(node.left, key);
//         else if (c > 0)
//             node.right = delete(node.right, key);
//         else {
//             if (node.right == null)
//                 return node.left;
//             if (node.left == null)
//                 return node.right;
//             Node t = node;
//             node = min(t.right);
//             node.right = deleteMin(t.right);
//             node.left = t.left;
//         }
//         node.count = 1 + size(node.left) + size(node.right);
//         return node;
//     }

//     @Override
//     public boolean contains(Key key) {
//         // TODO Auto-generated method stub
//         return false;
//     }

//     @Override
//     public boolean isEmpty() {
//         // TODO Auto-generated method stub
//         return false;
//     }

//     @Override
//     public int size() {
//         return size(root);
//     }

//     private int size(Node node) {
//         if (node == null) {
//             return 0;
//         }
//         return node.count;
//     }

//     @Override
//     public Iterable<Key> keys() {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public Key min() {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public Key max() {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public Key floor(Key key) {
//         // TODO Auto-generated method stub
//         Node node = floor(root, key);
//         if (node == null)
//             return null;
//         return node.key;
//     }

//     private Node floor(Node node, Key key) {
//         if (node == null)
//             return null;
//         int c = key.compareTo(node.key);
//         if (c == 0)
//             return node;
//         if (c < 0)
//             return floor(node.left, key);
//         Node p = floor(node.right, key);
//         if (p != null)
//             return p;
//         else
//             return node;
//     }

//     @Override
//     public Key ceiling(Key key) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public int rank(Key key) {
//         return rank(key, root);
//     }

//     private int rank(Key key, Node node) {
//         if (node == null)
//             return 0;
//         int c = key.compareTo(node.key);
//         if (c < 0)
//             return rank(key, node.left);
//         else if (c > 0)
//             return 1 + size(node.left) + rank(key, node.right);
//         else
//             return size(node.left);
//     }

//     @Override
//     public Key select(int k) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public void deleteMin() {
//         root = deleteMin(root);
//     }

//     private Node deleteMin(Node node) {
//         if (node.left == null)
//             return node.right;
//         node.left = deleteMin(node.left);
//         node.count = 1 + size(node.left) + size(node.right);
//         return node;
//     }

//     @Override
//     public void deleteMax() {
//         // TODO Auto-generated method stub

//     }

//     @Override
//     public int size(Key u, Key v) {
//         // TODO Auto-generated method stub
//         return 0;
//     }

//     @Override
//     public Iterable<Key> keys(Key u, Key v) {
//         // TODO Auto-generated method stub
//         return null;
//     }

// }
