package stack_queue;

import java.util.Iterator;

public class LinkedListQueue<T> implements Queue<T> {

    class Node {
        Node next;
        T data;
    }

    private Node queue = null;
    private Node rear = null;
    private int n;

    @Override
    public void enqueue(T data) {
        // TODO Auto-generated method stub
        Node node = new Node();
        node.data = data;
        if (isEmpty())
            queue = node;
        else
            rear.next = node;
        rear = node;
        n++;
    }

    @Override
    public T dequeue() {
        // TODO Auto-generated method stub
        if (!isEmpty()) {
            T data = queue.data;
            queue = queue.next;
            if (queue == null)
                rear = null;
            n--;
            return data;
        }
        return null;
    }

    @Override
    public T queue() {
        // TODO Auto-generated method stub
        return queue.data;
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
        return new LinkedListQueueIterator();
    }

    class LinkedListQueueIterator implements Iterator<T> {

        private Node current = queue;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return current != null;
        }

        @Override
        public T next() {
            // TODO Auto-generated method stub
            T data = current.data;
            current = current.next;
            return data;
        }

    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedListQueue<>();
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
    }

}
