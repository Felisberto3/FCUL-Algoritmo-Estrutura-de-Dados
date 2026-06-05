package ForExame.Ex2024_1Epoca;

import java.util.Iterator;

public class Ex5_BinarySearchST<Key extends Comparable<Key>, Value> implements Iterable<Key> {
    private Key[] keys;
    private Value[] vals;
    private int size;
    private int m;

    public Ex5_BinarySearchST(int m) {
        this.keys = (Key[]) new Comparable[m];
        this.vals = (Value[]) new Object[m];
        this.m = m;
    }

    public Value get(Key key) {
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            return vals[i];
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        Key[] newKeys = (Key[]) new Comparable[capacity];
        Value[] newValues = (Value[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            newKeys[i] = keys[i];
            newValues[i] = vals[i];
        }

        keys = newKeys;
        vals = newValues;

    }

    public void put(Key key, Value value) {
        if (size >= (3 * keys.length) / 4)
            resize(keys.length * 2);

        if (size > 0 && keys[size - 1].compareTo(key) < 0) {
            keys[size] = key;
            vals[size] = value;
            size++;
            return;
        }
        int i = rank(key);

        if (i < size && keys[i].compareTo(key) == 0) {
            vals[i] = value;
            return;
        }

        for (int j = size; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }

        keys[i] = key;
        vals[i] = value;
        size++;

    }

    private int rank(Key key) {
        int lo = 0, hi = size - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int cmp = keys[mid].compareTo(key);

            if (cmp < 0)
                lo = mid + 1;
            else if (cmp > 0)
                hi = mid - 1;
            else
                return mid;
        }

        return lo;
    }

    @Override
    public Iterator<Key> iterator() {
        ArrayQueue<Key> q = new ArrayQueue<>();
        for (int i = 0; i < size; i++)
            if (keys[i] != null) {
                q.enqueue(keys[i]);
            }

        return q.iterator();

    }

    public static void main(String[] args) {
        Ex5_BinarySearchST<Integer, String> b = new Ex5_BinarySearchST<>(54);
        b.put(1, "Felisberto");
        b.put(5, "Alberto");

        System.out.println();
        for (Integer integer : b) {
            System.out.print(integer);
        }
    }

}