package ForExame.ST;

/***
 * @param Key   representa cada chave da tabela
 * @param Value representa cada valor da tabela
 */
public class SepareteChainingST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {

    /**
     * m length da tabela
     */
    private int m;
    private SequentialSearchST<Key, Value>[] st;
    private int size;

    @SuppressWarnings("unchecked")
    public SepareteChainingST(int capacity) {
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[capacity];

        for (int i = 0; i < st.length; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
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

        if (value == null)
            size--;
        else
            size++;
    }

    @Override
    public int size() {
        return size;
    }

}
