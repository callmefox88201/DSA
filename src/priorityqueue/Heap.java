package priorityqueue;

import java.util.Arrays;

public class Heap<Key extends Comparable<Key>> implements MaxPriorityQueue<Key> {
    private Key[] heap;
    private int n;

    public Heap(Comparable[] heap) {
        this.n = heap.length - 1;
        this.heap = (Key[]) heap;
    }

    private void swap(int i, int j) {
        Key k = heap[i];
        heap[i] = heap[j];
        heap[j] = k;
    }

    private void upheap(int k) {
        while (k > 1 && heap[k / 2].compareTo(heap[k]) < 0) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    @Override
    public void insert(Key v) {
        // TODO Auto-generated method stub
        if (n == heap.length - 1)
            heap = Arrays.copyOf(heap, n * 2);
        heap[++n] = v;
        upheap(n);
    }

    private void downheap(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && heap[j].compareTo(heap[j + 1]) < 0)
                j++;
            if (heap[k].compareTo(heap[j]) > 0)
                break;
            swap(k, j);
            k = j;
        }
    }

    @Override
    public Key deleteMax() {
        // TODO Auto-generated method stub
        Key max = heap[1];
        swap(1, n--);
        downheap(1);
        heap[n + 1] = null;
        return max;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return n == 0;
    }

    @Override
    public Key max() {
        // TODO Auto-generated method stub
        return heap[1];
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return n;
    }

    public void buildHeap() {
        for (int k = n / 2; k >= 1; k--) {
            downheap(k);
        }
    }

    public void heapSort() {
        int m = n;
        while (n > 1) {
            swap(1, n);
            n--;
            downheap(1);
        }
        n = m;
    }

    public void print(int m) {
        for (int i = 1; i <= m; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Character[] c = { ' ', 'h', 'e', 'a', 'p', 's', 'o', 'r', 't' };
        Heap heap = new Heap(c);
        heap.buildHeap();
        heap.heapSort();
        heap.print(c.length - 1);
    }
}
