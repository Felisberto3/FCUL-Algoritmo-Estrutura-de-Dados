package ForExame.Ex2024_2Epoca;

/**
 * Empilha dados do tipo E.
 * 
 * @param <E> elementos da pilha
 */
public interface Stack<E> {
    void push(E e);

    void pop();

    int size();

    E top();

    default boolean isEmpty() {
        return size() == 0;
    }
}
