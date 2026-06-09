package ForExame.Ex2023_2Epoca;

public class EX06_BST<Key extends Comparable<Key>, Value> {
    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int n; // size
    }

    private Node root;

    /**
     * @param key A chave * @return n´u mero de chaves inferiores a key
     */
    private int rank(Key key) {
        return rank(root, key);
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        return x == null ? 0 : x.n;
    }

    private int rank(Node x, Key key) {
        int cmp = x.key.compareTo(key);
        if (cmp <= 0) {
            return x.n;
        } else {
            return size(x.left) + rank(x.right, key);
        }
    }

    public int countRange(Key k1, Key k2) {
        return rank(k2) - rank(k1);
    }
}
