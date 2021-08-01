package stack_queue;

public interface Queue<T> extends Iterable<T> {

    void enqueue(T data);

    T dequeue();

    T queue();

    int size();

    boolean isEmpty();
}
