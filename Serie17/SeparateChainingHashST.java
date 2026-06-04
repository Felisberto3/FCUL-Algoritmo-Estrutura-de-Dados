package Serie17;

import java.util.Iterator;

public class SeparateChainingHashST<Key extends Comparable<Key>, Value> implements Iterable<Key> {
    private SequentialSearch<Key, Value>[] st;
    private int m;

    @SuppressWarnings("unchecked")
    public SeparateChainingHashST(int m) {
        st = (SequentialSearch<Key, Value>[]) new SequentialSearch[m];
        this.m = m;
        for (int i = 0; i < m; i++)
            st[i] = new SequentialSearch<>();

    }

    public int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public void put(Key key, Value value) {
        st[hash(key)].put(key, value);
    }

    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    public void delete(Key key) {
        st[hash(key)].delete(key);
    }

    public Iterator<Key> iterator() {
        MyList<Key> l = new MyList<>();

        for (int i = 0; i < m; i++) {
            for (Key key : st[i]) {
                l.put(key);
            }
        }
        return l.iterator();
    }

    public static void main(String[] args) {
        SeparateChainingHashST<Integer, String> l = new SeparateChainingHashST<>(5);
        l.put(5, "FElisberto");
        l.put(0, "almoco");
        l.put(100, "almoco");

        System.out.println(l.get(5));
        System.out.println(l.get(0));
        System.out.println("===============");
        for (Integer integer : l) {
            System.out.println(integer);
        }
    }
}
