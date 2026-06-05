package ForExame.Ex2024_1Epoca;

public interface Queue<E> extends Iterable<E> {
    void enqueue(E e);

    void dequeue();

    E front();

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

}
