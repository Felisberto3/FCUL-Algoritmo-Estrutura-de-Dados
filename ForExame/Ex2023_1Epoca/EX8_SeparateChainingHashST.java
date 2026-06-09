package ForExame.Ex2023_1Epoca;

import org.w3c.dom.Node;

public class EX8_SeparateChainingHashST<Key, Value> {
    private int m;
    private SequentialSearchST<Key, Value>[] st;

    public EX8_SeparateChainingHashST(int m) {
        this.m = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++)
            st[i] = new SequentialSearchST<>();
    }

    /**
     * 
     * @param key a chve que sera convertida em numero
     * @return retorna um valor hash entre 0 a m-1
     */
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public void put(Key key, Value value) {
        if (value == null)
            return;
        st[hash(key)].put(key, value);
    }
    // LinearProbing (Sondagem linear)

    /**
     * Elimina a chave na tabela de simbolos
     * 
     * @param key a chave q será eliminada.
     */
    public void delete(Key key) {
        if (key == null)
            return;
        st[hash(key)].delete(key);
    }

}