package Teoria.TDA.TDA_com_interface;

public interface Stack<E> {
    /**
     * estruturas elementos do mesmo tipo em forma de pilha
     */

    /**
     * acrescenta um elemento no topo da pilha
     * 
     * @param E elemento a ser acrescentado no topo da pilha
     */
    public void push(E e);

    /**
     * verifica se a pilha esta vazia
     * 
     * @return true se a pilha estiver vazia e false caso contrario
     */
    public boolean isEmpty();

    /**
     * verifica o elemento no topo da pilha
     * 
     * @requires a pilha nao pode estar vazia
     * @return retorna o elemento no topo da pilha
     */
    public E peek();

    /**
     * retira o elemento no topo da pilha
     * 
     * @requires a pilha nao pode estar vazia
     */
    public void pop();

}
