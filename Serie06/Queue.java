package Serie06;

public interface Queue<E> {
    /**
     * Tira o primeiro elemento do array.
     */
    public void dequeue();

    /**
     * Acrescenta um elemento na fila
     * 
     * @param e é o elemento a ser incluido na fila
     */
    public void enqueue(E e);

    /**
     * Mostra o elemento que está na frente da pilha
     * 
     * @return O Elemento na frente da fila
     */
    public E front();

    /**
     * Verifica se a pilha está vazia.
     * 
     * @return True se a fila estiver vazia e False caso contrário.
     */
    public boolean isEmpty();

    public int size();
}
