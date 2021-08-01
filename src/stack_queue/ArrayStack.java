package stack_queue;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayStack<T> implements Stack<T> {

    private int n;
    private T[] arr;

    public ArrayStack() {
        arr = (T[]) new Object[100];
    }

    @Override
    public void push(T data) {
        // TODO Auto-generated method stub
        if (n == arr.length)
            arr = Arrays.copyOf(arr, n * 2);
        arr[n++] = data;
    }

    @Override
    public T pop() {
        // TODO Auto-generated method stub
        if (!isEmpty()) {
            n--;
            return arr[n];
        }
        return null;
    }

    @Override
    public T peek() {
        // TODO Auto-generated method stub
        if (!isEmpty())
            return arr[n - 1];
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
        return n == 0;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new ArrayStackIterator();
    }

    class ArrayStackIterator implements Iterator<T> {

        private int current = n;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return current > 0;
        }

        @Override
        public T next() {
            // TODO Auto-generated method stub
            return arr[--current];
        }

    }

    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        for (int i : stack)
            System.out.print(i + " ");
        System.out.println();
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        for (int i : stack)
            System.out.print(i + " ");
    }

}
