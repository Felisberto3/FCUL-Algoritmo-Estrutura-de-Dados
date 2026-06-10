package ForExame.Ex2024_2Epoca;

public class EX6_BST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int n;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            this.n = n;
        }
    }

    /**
     * Elimina o menor elemento da arvore
     */
    public void deleteMin() {
        if (root == null) {
            return;
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x == null) {
            return null;
        }

        if (x.left == null) {
            return x.right;
        }

        x.left = deleteMin(x.left);

        x.n = size(x.left) + size(x.right) + 1;

        return x;
    }

    private int size(Node x) {
        return x == null ? 0 : x.n;
    }

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        int cmp = x.key.compareTo(key);

        if (cmp < 0) {
            return get(x.right, key);
        } else if (cmp > 0) {
            return get(x.left, key);
        } else {
            return x.val;
        }
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            return new Node(key, value, 1);
        }
        int cmp = x.key.compareTo(key);
        if (cmp < 0) {
            x.right = put(x.right, key, value);
        } else if (cmp > 0) {
            x.left = put(x.left, key, value);
        }

        x.n = size(x.left) + size(x.right) + 1;

        return x;
    }

    @Override
    public int size() {
        return size(root);
    }

}