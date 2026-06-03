package ForExame.ST;

public class BinarySearchST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int size;
    private static final int DEFAULT_CAPACITY = 1000;

    public BinarySearchST() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    private int rank(Key key) {
        int l = 0, r = size - 1;

        while (l <= r) {
            int md = l + (r - l) / 2;
            int cmp = keys[md].compareTo(key);

            if (cmp < 0) {
                r = md - 1;
            } else if (cmp > 0) {
                l = md + 1;
            } else {
                return md;
            }
        }

        return l;

    }

    @Override
    public Value get(Key key) {
        int i = rank(key);

        if (i < size && keys[i].compareTo(key) == 0)
            return values[i];

        return null;
    }

    @Override
    public void put(Key key, Value value) {
        if (size >= 3 * keys.length / 4)
            resize(size * 2);
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            values[i] = value;
            if (value == null) {
                size--;
            }
        }

        for (int j = size; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }

        keys[i] = key;
        values[i] = value;
        if (value != null)
            size++;
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        Key[] tempKeys = (Key[]) new Comparable[capacity];
        Value[] tempValues = (Value[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            tempKeys[i] = keys[i];
            tempValues[i] = values[i];
        }

        keys = tempKeys;
        values = tempValues;

    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        BinarySearchST<Integer, String> bs = new BinarySearchST<>();
        bs.put(1, "Felisberto");
        bs.put(-1, "Alberto");
        bs.delete(-1);
        System.out.println(bs.get(-1));
    }
}
