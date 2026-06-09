package Serie17;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class SequentialSearch<Key extends Comparable<Key>, Value> implements Iterable<Key> {
    private Node first;

    public class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public void put(Key key, Value value) {
        Node i = first;
        for (; i != null; i = i.next) {
            if (i.key.equals(key)) {
                i.value = value;
                return;
            }
        }

        first = new Node(key, value, first);
    }
    // public Node put(Key key, Value value, Node x) {
    // if (x == null) {
    // return new Node(key, value, null);
    // }

    // if (x.key.equals(key)) {
    // x.value = value;
    // return x;
    // }

    // x.next = put(key, value, x.next);

    // return x;
    // }

    public Value get(Key key) {
        return get(key, first);
    }

    private Value get(Key key, Node x) {
        if (x == null)
            return null;

        return x.key.equals(key) ? x.value : get(key, x.next);
    }

    public void delete(Key key) {
        if (first == null)
            return;

        first = delete(key, first);
    }

    private Node delete(Key key, Node x) {
        if (x == null)
            return null;

        if (x.key.equals(key))
            return x.next;

        x.next = delete(key, x.next);
        return x;
    }

    @Override
    public Iterator<Key> iterator() {
        MyList<Key> l = new MyList<>();

        for (Node i = first; i != null; i = i.next) {
            l.put(i.key);
        }
        return l.iterator();

    }

    public static void main(String[] args) {
        SequentialSearch<Integer, String> s = new SequentialSearch<>();

        s.put(1, "FElisberto");
        s.put(4, "Alberto");
        s.put(5, "Mukinda");

        System.out.println(s.get(5));

        s.delete(5);
        System.out.println(s.get(5));
    }
}
