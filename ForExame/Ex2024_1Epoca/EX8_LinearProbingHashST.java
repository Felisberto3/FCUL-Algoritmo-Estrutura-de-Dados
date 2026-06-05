package ForExame.Ex2024_1Epoca;

public class EX8_LinearProbingHashST<Key, Value> {
    private int n;
    private int m;
    private Key[] keys;
    private Value[] vals;

    public EX8_LinearProbingHashST(int capacity) {
        keys = (Key[]) new Object[capacity];
        vals = (Value[]) new Object[capacity];
        m = capacity;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public Value get(Key key) {
        int i = hash(key);

        for (; keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }

        return null;
    }

    private void resize(int capacity) {
        EX8_LinearProbingHashST<Key, Value> t = new EX8_LinearProbingHashST<>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null && vals[i] != null) {
                t.put(keys[i], vals[i]);
            }
        }

        keys = t.keys;
        vals = t.vals;
        m = t.m;
        n = t.n;
    }

    public int size() {
        return n;
    }

    public void delete(Key key) {
        if (n == 0)
            return;

        int i = hash(key);

        for (; keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                keys[i] = null;
                vals[i] = null;
                n--;

                i = (i + 1) % m;

                while (keys[i] != null) {
                    Key keyToRefresh = keys[i];
                    Value valueToRefresh = vals[i];
                    keys[i] = null;
                    vals[i] = null;
                    n--;
                    put(keyToRefresh, valueToRefresh);
                    i = (i + 1) % m;

                }

                return;
            }
        }
    }

    public void put(Key key, Value value) {
        if (n >= (3 * m) / 4) {
            resize(m * 2);
        }
        int i = hash(key);
        for (; keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = value;
                return;
            }
        }

        keys[i] = key;
        vals[i] = value;
        n++;
    }
}
