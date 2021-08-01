package stack_queue;

import java.util.Iterator;

public class LinkedListStack<T> implements Stack<T> {

    class Node {
        Node next;
        T data;
    }

    private Node list;
    private int n;

    @Override
    public void push(T data) {
        // TODO Auto-generated method stub
        Node node = new Node();
        node.data = data;
        node.next = list;
        list = node;
        n++;
    }

    @Override
    public T pop() {
        // TODO Auto-generated method stub
        if (!isEmpty()) {
            T data = list.data;
            list = list.next;
            n--;
            return data;
        }
        return null;
    }

    @Override
    public T peek() {
        // TODO Auto-generated method stub
        if (!isEmpty())
            return list.data;
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return n;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new LinkedListStackIterator();
    }

    class LinkedListStackIterator implements Iterator<T> {

        private Node current = list;

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
        Stack<Integer> stack = new LinkedListStack<>();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        System.out.println(stack.size());
        for (int i : stack)
            System.out.print(i + " ");
        System.out.println();
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.size());
        for (int i : stack)
            System.out.print(i + " ");
    }
}