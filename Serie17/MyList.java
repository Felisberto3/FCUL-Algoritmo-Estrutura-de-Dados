package Serie17;

import java.util.Iterator;

public class MyList<Key> implements Iterable<Key> {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        Key key;
        Node next;

        public Node(Key key, Node next) {
            this.key = key;
            this.next = next;
        }

        public Node(Key key) {
            this.key = key;
        }
    }

    public void put(Key key) {
        Node oldLast = last;
        Node last = new Node(key);

        if (first == null)
            first = last;
        else
            oldLast.next = last;
        size++;
    }

    public Key get(Key key) {
        return get(key, first);
    }

    private Key get(Key key, Node x) {
        if (x == null) {
            return null;
        }
        return x.key.equals(key) ? x.key : get(key, x.next);
    }

    public Iterator<Key> iterator() {
        return new Iterator<Key>() {
            Node x = first;

            @Override
            public boolean hasNext() {
                return x != null;
            }

            @Override
            public Key next() {
                Key result = x.key;
                x = x.next;

                return result;
            }
        };
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyList<Integer> l = new MyList<>();
        l.put(2);
        l.put(2);
        l.put(2);
        l.put(2);

    }
}
