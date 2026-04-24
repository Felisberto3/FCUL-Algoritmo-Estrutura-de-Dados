package Serie07.ex1e2;

public interface Stack<E> extends Iterable<E> {
    void push(E item);

    E pop();

    E peek();

    boolean isEmpty();

}