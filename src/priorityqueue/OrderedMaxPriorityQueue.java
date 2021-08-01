package priorityqueue;

import java.util.Arrays;

public class OrderedMaxPriorityQueue<Key extends Comparable<Key>> implements MaxPriorityQueue<Key> {
    private Key[] queue;
    private int n;

    public OrderedMaxPriorityQueue(int capacity) {
        n = 0;
        queue = (Key[]) new Comparable[capacity];
    }

    public void insert(Key v) {
        if (n == queue.length)
            queue = Arrays.copyOf(queue, n * 2);
        queue[n++] = v;
    }

    public Key deleteMax() {
        int maxId = 0;
        for (int j = 1; j < n; j++)
            if (queue[j].compareTo(queue[maxId]) > 0) {
                maxId = j;
            }
        swap(maxId, n - 1);
        return queue[--n];
    }

    void swap(int i, int j) {
        Key temp = queue[i];
        queue[i] = queue[j];
        queue[j] = temp;
    }

    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return n == 0;
    }

    @Override
    public Key max() {
        // TODO Auto-generated method stub
        int maxId = 0;
        for (int j = 1; j < n; j++)
            if (queue[j].compareTo(queue[maxId]) > 0) {
                maxId = j;
            }
        return queue[maxId];
    }
}