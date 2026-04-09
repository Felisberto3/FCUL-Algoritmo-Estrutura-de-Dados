package Serie06;

public interface Queue<E> {
    public void dequeue();

    public void enqueue(E item);

    public E front();

    public boolean isEmpty();
}
