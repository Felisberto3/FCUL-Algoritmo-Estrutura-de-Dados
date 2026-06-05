package ForExame.Ex2024_1Epoca;

public class Ex6_BST<Key extends Comparable<Key>, Value> {
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

    private Node root;

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null)
            return null;

        int cmp = x.key.compareTo(key);

        if (cmp < 0) {
            return get(x.right, key);
        } else if (cmp > 0) {
            return get(x.left, key);
        } else {
            return x.val;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        return x == null ? 0 : x.n;
    }

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
        } else {
            x.val = value;
        }

        x.n = size(x.left) + size(x.right) + 1;

        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int cmp = x.key.compareTo(key);

        if (cmp < 0)
            x.right = delete(x.right, key);
        else if (cmp > 0)
            x.left = delete(x.left, key);
        else {
            if (x.left == null) {
                return x.right;
            } else if (x.right == null) {
                return x.left;
            }

            Node t = x;
            x = findMin(t.right);
            x.left = t.left;
            x.right = deleteMin(t.right);
        }

        x.n = size(x.right) + size(x.left) + 1;
        return x;
    }

    private Node findMin(Node x) {
        return (x.left == null) ? x : findMin(x.left);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    public static void main(String[] args) {
        Ex6_BST<Integer, Integer> b = new Ex6_BST<>();

        b.put(2, 5);
        System.out.println(b.get(2));
    }
}