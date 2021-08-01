package simpletable;

import java.util.ArrayList;
import java.util.List;

public class LinkedListSimpleTable<Key extends Comparable<Key>, Value> extends AbstractSimpleTable<Key, Value> {

    class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key k, Value v) {
            key = k;
            value = v;
            next = null;
        }
    }

    private Node list;

    public LinkedListSimpleTable() {
        list = null;
    }

    @Override
    public void put(Key key, Value value) {
        // sequential search: O(n)
        Node p = list;
        while (p != null) {
            if (p.key.equals(key)) {
                p.value = value;
                return;
            }
            p = p.next;
        }
        // add a new node (key, value)
        Node q = new Node(key, value);
        q.next = list;
        list = q;
    }

    @Override
    public Value get(Key key) {
        // sequential search: O(n)
        Node p = list;
        while (p != null) {
            if (p.key.equals(key))
                return p.value;
            p = p.next;
        }
        return null;
    }

    @Override
    public int size() {
        Node p = list;
        int n = 0;
        while (p != null) {
            if (p.value != null)
                n++;
            p = p.next;
        }
        return n;
    }

    @Override
    public Iterable<Key> keys() {
        List<Key> allKeys = new ArrayList<>();
        Node p = list;
        while (p != null) {
            if (p.value != null)
                allKeys.add(p.key);
            p = p.next;
        }
        return allKeys;
    }
}