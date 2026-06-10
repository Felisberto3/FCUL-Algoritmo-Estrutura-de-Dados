package ForExame.Ex2024_2Epoca;

public class SequentialSearchST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node first;
    private int size;

    @Override
    public Value get(Key key) {
        for (Node i = first; i != null; i = i.next)
            if (i.key.equals(key))
                return i.value;

        return null;
    }

    @Override
    public void put(Key key, Value value) {
        for (Node i = first; i != null; i = i.next)
            if (i.key.equals(key)) {
                i.value = value;
                return;
            }

        first = new Node(key, value, first);
        size++;

    }

    @Override
    public int size() {
        return size;
    }

}
