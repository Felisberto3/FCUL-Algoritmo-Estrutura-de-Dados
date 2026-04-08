package Serie05;

public interface Conjunto<E> {
    /**
     * Verifica se a lista esta vazia
     * 
     * @return True se a lista estiver vazia e False caso contrario.
     */
    public boolean isEmpty();

    /**
     * Verifica se um dado elemento esta na lista.
     * 
     * @param item é o elemento a ser pesquisado na lista.
     * @return True se o elemento estiver na lista, e False caso contrario.
     */
    public boolean contains(E item);

    /**
     * Adiciona um elemento no conjunto.
     * 
     * @param item é elemento que será acrescentado no conjunto.
     */
    public void add(E item);
}
