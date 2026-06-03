package ForExame.Ex2023_1Epoca;

public class SequentialSearchST<Key, Value> {
    private Node first;

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node x) {
            this.key = key;
            this.value = value;
            next = x;
        }
    }

    public void put(Key key, Value value) {
        for (Node i = first; i != null; i = i.next) {
            if (i.key.equals(key)) {
                i.value = value;
                return;
            }
        }

        first = new Node(key, value, first);
    }

    public Value get(Key key) {
        for (Node i = first; i != null; i = i.next) {
            if (i.key.equals(key)) {
                return i.value;
            }
        }

        return null;
    }

    public void delete(Key key) {
        first = delete(first, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }

        if (x.key.equals(key)) {
            return x.next;
        } else {
            x.next = delete(x.next, key);
        }

        return x;

    }

}
