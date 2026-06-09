package ForExame.Ex2023_1Epoca;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EX5_BinarySearch<Key extends Comparable<Key>, Value> implements Iterable<Key> {
    private Key[] keys;
    private Value[] vals;
    private int size;
    private int m;

    @SuppressWarnings("unchecked")
    public EX5_BinarySearch(int m) {
        keys = (Key[]) new Comparable[m];
        vals = (Value[]) new Object[m];
        this.m = m;
    }

    public Value get(Key key) {
        int i = rank(key);

        if (i < size && keys[i].compareTo(key) == 0)
            return vals[i];
        else
            return null;

    }

    public void put(Key key, Value val) {
        if (size > 0 && keys[size - 1].compareTo(key) < 0) {
            keys[size] = key;
            vals[size] = val;
            size++;
            return;
        }

        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        for (int j = size; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        size++;
    }

    private int rank(Key key) {
        int l = 0, r = size - 1;

        while (l <= r) {
            int md = l + (r - l) / 2;

            int result = keys[md].compareTo(key);
            if (result < 0) {
                r = md - 1;
            } else if (result > 0) {
                l = md + 1;
            } else {
                return md;
            }
        }

        return l;
    }

    // b) Qual o tempo requerido, expresso na nota¸c˜ao O, para inserir uma
    // sequˆencia
    // ordenada de n elementos na nova vers˜ao da classe BinarySearchST? Justifique.
    // Note que pode responder a este exerc´ıcio sem ter respondido ao
    // anterior.
    // R.: O(n) = n * O(1) = O(n)

    @Override
    public Iterator<Key> iterator() {
        return new Iterator<Key>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Key next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Elemento no existe");
                }
                return keys[i++];
            }
        };

    }
}
