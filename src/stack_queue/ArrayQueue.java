package stack_queue;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayQueue<T> implements Queue<T> {

    private T[] arr;
    private int queue;
    private int n;

    public ArrayQueue() {
        arr = (T[]) new Object[100];
    }

    @Override
    public void enqueue(T data) {
        // TODO Auto-generated method stub
        if (n < arr.length)
            arr[(queue + n++) % arr.length] = data;
    }

    @Override
    public T dequeue() {
        // TODO Auto-generated method stub
        if (n > 0) {
            T data = arr[queue++];
            if (queue == arr.length)
                queue = 0;
            n--;
            return data;
        }
        return null;
    }

    @Override
    public T queue() {
        // TODO Auto-generated method stub
        return arr[queue];
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return n;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return n == 0;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new ArrayQueueIterator();
    }

    class ArrayQueueIterator implements Iterator<T> {

        private int count;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return count < n;
        }

        @Override
        public T next() {
            // TODO Auto-generated method stub
            return arr[(queue + count++) % arr.length];
        }

    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println(queue.queue());
        for (int i : queue)
            System.out.print(i + " ");
        System.out.println();
        queue.dequeue();
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println(queue.queue());
        for (int i : queue)
            System.out.print(i + " ");
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.isEmpty());
    }

}
