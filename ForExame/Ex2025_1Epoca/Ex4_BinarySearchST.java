package ForExame.Ex2025_1Epoca;

import ForExame.Ex2024_2Epoca.ST;

public class Ex4_BinarySearchST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {
    private Key[] keys;
    private Value[] vals;
    private int size;
    private static int CAPACITY = 100;

    public Ex4_BinarySearchST() {
        this(CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public Ex4_BinarySearchST(int capacity) {
        this.keys = (Key[]) new Comparable[capacity];
        this.vals = (Value[]) new Object[capacity];
    }

    private int rank(Key key) {
        int lo = 0, hi = size - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int cmp = keys[mid].compareTo(key);

            if (cmp < 0) {
                lo = mid + 1;
            } else if (cmp > 0) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    @Override
    public Value get(Key key) {
        int i = rank(key);

        if (i < size && keys[i].compareTo(key) == 0) {
            return vals[i];
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        Key[] tempKeys = (Key[]) new Comparable[capacity];
        Value[] tempValues = (Value[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            tempKeys[i] = keys[i];
            tempValues[i] = vals[i];
        }

        this.keys = tempKeys;
        this.vals = tempValues;

    }

    @Override
    public void put(Key key, Value value) {
        if (key == null)
            return;

        if (value == null) {
            delete(key);
            return;
        }

        if (size == keys.length)
            resize(keys.length * 2);

        if (size > 0 && keys[size - 1].compareTo(key) < 0) {
            keys[size] = key;
            vals[size] = value;
            size++;
            return;
        }

        int i = rank(key);
        for (int j = size; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }

        keys[i] = key;
        vals[i] = value;
        size++;
    }

    public void delete(Key key) {
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {

            for (int j = i; j < size - 1; j++) {
                keys[j] = keys[j + 1];
                vals[j] = vals[j + 1];
            }

            size--;
            vals[size] = null;
            keys[size] = null;
        }
    }

    public void deleteMax() {
        if (size == 0)
            return;
        keys[size - 1] = null;
        vals[size - 1] = null;
        size--;
    }

    public void deleteMin() {
        if (size == 0)
            return;

        for (int i = 0; i < size - 1; i++) {
            keys[i] = keys[i + 1];
            vals[i] = vals[i + 1];
        }

        keys[size - 1] = null;
        vals[size - 1] = null;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

}