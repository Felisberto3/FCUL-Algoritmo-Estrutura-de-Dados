package ForExame.Ex2023_1Epoca;

public interface Queue<E> extends Iterable<E> {
    void enqueue(E e);

    void dequeue();

    E front();

    boolean contains(E e);

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

}
