package ForExame.Ex2023_2Epoca;

public interface Queue<E> {
    void enqueue(E e);

    void dequeue();

    E peek();

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }
}
