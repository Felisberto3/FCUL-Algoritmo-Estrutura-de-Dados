package ForExame.ST;

public class SequentialSearchST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {

    Node first;
    int size;

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

    @Override
    public Value get(Key key) {
        for (Node i = first; i != null; i = i.next) {
            if (i.key.compareTo(key) == 0) {
                return i.value;
            }
        }

        return null;
    }

    @Override
    public void put(Key key, Value value) {
        for (Node i = first; i != null; i = i.next) {
            if (i.key.compareTo(key) == 0) {
                i.value = value;

                if (value == null)
                    size--;

                return;
            }
        }

        first = new Node(key, value, first);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

}
