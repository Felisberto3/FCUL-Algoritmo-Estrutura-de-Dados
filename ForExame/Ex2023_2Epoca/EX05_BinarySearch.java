package ForExame.Ex2023_2Epoca;

public class EX05_BinarySearch<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int size;
    private int m;

    /**
     * @param key A chave
     * @return n´u mero de chaves inferiores a key
     */

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

    public Value get(Key key) {

        int i = rank(key);

        if (i < size && keys[i].compareTo(key) == 0) {
            return vals[i];
        } else {
            return null;
        }
    }
}
