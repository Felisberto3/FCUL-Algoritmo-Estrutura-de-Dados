package ForExame.Ex2023_1Epoca;

import java.util.Iterator;
import java.util.LinkedList;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        Key key;
        Value value;
        Node left, right;
        int n;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.n = 1;
        }

    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        return x == null ? 0 : x.n;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int cmp = x.key.compareTo(key);

        if (cmp < 0) {
            return get(x.right, key);
        } else if (cmp > 0) {
            return get(x.left, key);
        } else {
            return x.value;
        }
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.n = size(x.left) + size(x.right) + 1;
        return x;

    }

    private Node findMin(Node x) {
        return x.left == null ? x : findMin(x.left);
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int cmp = x.key.compareTo(key);

        if (cmp < 0) {
            x.right = delete(x.right, key);
        } else if (cmp > 0) {
            x.left = delete(x.left, key);
        } else {
            if (x.left == null) {
                return x.right;
            } else if (x.right == null) {
                return x.left;
            }

            Node t = x;

            x = findMin(x.right);
            x.left = t.left;
            x.right = deleteMin(t.right);
        }

        x.n = size(x.left) + size(x.right) + 1;

        return x;

    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            return new Node(key, value);
        }

        int cmp = x.key.compareTo(key);
        if (cmp < 0) {
            x.right = put(x.right, key, value);
        } else if (cmp > 0) {
            x.left = put(x.left, key, value);
        } else {
            x.value = value;
        }
        x.n = size(x.left) + size(x.right) + 1;

        return x;
    }

    public Iterator<Key> keys() {
        LinkedList<Key> linkedL = new LinkedList<>();
        inOrder(root, linkedL);
        return linkedL.iterator();

    }

    private void inOrder(Node x, LinkedList<Key> list) {
        if (x == null) {
            return;
        }
        inOrder(x.left, list);
        list.add(x.key);
        inOrder(x.right, list);
    }
}
