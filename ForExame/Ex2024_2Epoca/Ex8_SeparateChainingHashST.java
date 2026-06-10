package ForExame.Ex2024_2Epoca;

public class Ex8_SeparateChainingHashST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {
    /*
     * Vetor de tabelas de s´ı mbolos
     */
    private SequentialSearchST<Key, Value>[] st;
    /*
     * N´u mero de tabelas de s´ı mbolos
     */
    private int m;
    /*
     * N´u mero de elementos na tabela de dispers ~ao
     */
    private int size;

    @SuppressWarnings("unchecked")
    public Ex8_SeparateChainingHashST(int capacity) {
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[capacity];

        for (int i = 0; i < st.length; i++)
            st[i] = new SequentialSearchST<>();

        this.m = capacity;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    @Override
    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    @Override
    public void put(Key key, Value value) {
        st[hash(key)].put(key, value);

        size++;
    }

    @Override
    public int size() {
        return size;
    }

}