package Serie07.ex3;

public interface Queue<E> extends Iterable<E> {

    /**
     * Coloca um elemento no final do fila
     * 
     * @param item a ser incluido na fila
     */
    void enqueue(E item);

    /**
     * Remove o primeiro elemento colocado na fila
     * 
     * @requires a lista deve ser diferente de 0
     * @return item removido
     */
    E dequeue();

    /**
     * Verifica se a lista esta vazia
     * 
     * @return True se a lista estiver vazia e falso caso contrario.
     */
    boolean isEmpty();
}
