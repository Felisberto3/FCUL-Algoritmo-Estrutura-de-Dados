package ForExame.EX2025_2Epoca;

import java.util.Iterator;
import java.util.LinkedList;

import Teoria.Tabela_Simbolo.ST;

public class EX7_BST<Key extends Comparable<Key>, Value>
        implements ST<Key, Value> {
    /**
     * A raiz da arvore
     */
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

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = x.key.compareTo(key);

        if (cmp > 0) {
            return get(x.left, key);
        } else if (cmp < 0) {
            return get(x.right, key);
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
        if (cmp > 0) {
            x.left = put(x.left, key, value);
        } else if (cmp < 0) {
            x.right = put(x.right, key, value);
        } else {
            x.val = value;
        }

        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public int size() {
        return size(root);
    }

    public int altura() {
        return altura(root);
    }

    private int altura(Node x) {
        return x == null ? 0 : Math.max(altura(x.left), altura(x.right)) + 1;
    }

    private int size(Node x) {
        return x == null ? 0 : x.n;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = x.key.compareTo(key);
        if (cmp < 0) {
            x.right = delete(x.right, key);
        } else if (cmp > 0) {
            x.left = delete(x.left, key);
        } else {
            if (x.left == null) {
                return x.right;
            }
            if (x.right == null) {
                return x.left;
            }

            Node t = x;

            x = findMin(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;

        }

        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    private Node deleteMin(Node x) {

        if (x.left == null) {
            return x.right;
        } else {
            x.left = deleteMin(x.left);
        }

        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    private Node findMin(Node x) {
        if (x.left == null) {
            return x;
        }
        return findMin(x.left);
    }

    @Override
    public Iterator<Key> iterator() {
        LinkedList<Key> l = new LinkedList<>();
        inOrder(l, root);
        return l.iterator();

    }

    private void inOrder(LinkedList<Key> l, Node x) {
        if (x == null)
            return;
        inOrder(l, x.left);
        l.add(x.key);
        inOrder(l, x.right);
    }

}
