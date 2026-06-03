package ForExame.ST;

/**
 * @param Key   chaves das tabelas de simbolos
 * @param Value valores das tabelas de simbolos
 */
public interface ST<Key, Value> {
    /**
     * 
     * @param key a chave
     * @return o valor associado a chave
     */
    Value get(Key key);

    /**
     * @param Key   a chave
     * @param value o valor associado a chave
     */
    void put(Key key, Value value);

    /**
     * 
     * @return quantidade de pares chave - valor
     */
    int size();

    default void delete(Key key) {
        put(key, null);
    }

    /**
     * 
     * @param key a chave a pesquisar
     * @return true se encontrar e false caso contrario
     */
    default boolean contains(Key key) {
        return get(key) != null;
    }

    /**
     * 
     * @return 0 se estiver vazia e outro numero caso contrario
     */
    default boolean isEmpty() {
        return size() == 0;
    }
}
