package Serie05;

public interface Stack <E> {
    /**
     *  Acresenta um elemento no topo da pilha
     * @param item é o elemento a ser acrescentado na pilha
     */
    public void push(E item);

    /**
     * Elimina o elemento do topo da pilha.
     * @requires size > 0
     * @return O elemento eliminado da pilha.
     */
    public E pop();

    /**
     * Pega o elemento no topo da pilha
     * @return  O elemento do topo
     */
    public E peek();
    /**
     *  Verifica se a pilha esta vazia
     * @return True se a pilha estiver vazia e false caso contrario
     */
    default boolean isEmpty(){
        return size() == 0;
    }

    /**
     * 
     * @return retorna o tamanho da pilha
     */
    public int size();
}
