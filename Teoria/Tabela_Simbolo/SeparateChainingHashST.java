package Teoria.Tabela_Simbolo;

import java.util.Iterator;

public class SeparateChainingHashST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {
    private final int m;
    private final SequentialSearchST<Key, Value>[] st;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public SeparateChainingHashST(int m) {
        this.m = m;

        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];

        for (int i = 0; i < st.length; i++)
            st[i] = new SequentialSearchST<>();

    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    @Override
    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    @Override
    public void put(Key key, Value val) {
        st[hash(key)].put(key, val);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Key> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

}
