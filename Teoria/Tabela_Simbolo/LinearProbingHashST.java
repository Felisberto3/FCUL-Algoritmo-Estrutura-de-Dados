package Teoria.Tabela_Simbolo;

import java.util.Iterator;

public class LinearProbingHashST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {
    private int n;
    private int m;
    private Key[] keys;
    private Value[] values;

    public LinearProbingHashST(int capacity) {
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];

        m = capacity;

    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    @Override
    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key))
                return values[i];
        }
        return null;
    }

    private void resize(int capacity) {
        LinearProbingHashST<Key, Value> t = new LinearProbingHashST<>(capacity);
        for (int i = 0; i < m; i++)
            if (keys[i] != null)
                t.put(keys[i], values[i]);

        keys = t.keys;
        values = t.values;
        m = t.m;
    }

    @Override
    public void put(Key key, Value val) {
        if (n >= m / 2) {
            resize(2 * m);
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                values[i] = val;
                return;
            }
        }
        keys[i] = key;
        values[i] = val;
        n++;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Iterator<Key> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

}
