package stack_queue;

public interface Stack<T> extends Iterable<T> {
    void push(T data);

    T pop();

    T peek();

    int size();

    boolean isEmpty();
}
