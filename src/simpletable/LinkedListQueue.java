package simpletable;

import java.util.Iterator;

public class LinkedListQueue<E> implements Queue<E> {

    class Node {
        E element;
        Node next;
    }

    private Node queue = null;
    private Node rear = null;

    public LinkedListQueue() {
        // TODO Auto-generated constructor stub
        queue = null;
        rear = null;
    }

    @Override
    public void enqueue(E element) {
        // TODO Auto-generated method stub
        Node node = new Node();
        node.element = element;
        node.next = null;
        if (rear != null) {
            rear.next = node;
        } else {
            queue = node;
        }
        rear = node;
    }

    @Override
    public E dequeue() {
        // TODO Auto-generated method stub
        if (queue != null) {
            Node node = queue;
            E element = node.element;
            queue = node.next;
            if (node == rear) {
                rear = null;
            }
            return element;
        }
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        int s = 0;
        Node p = queue;
        while (p != null) {
            s++;
            p = p.next;
        }
        return s;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return queue == null;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return new LinkedListIterator();
    }

    class LinkedListIterator implements Iterator<E> {
        private Node current = queue;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return current != null;
        }

        @Override
        public E next() {
            // TODO Auto-generated method stub
            E e = current.element;
            current = current.next;
            return e;
        }

    }

}
