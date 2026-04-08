package Serie05;

public class MoveToFrontSet<E> implements Conjunto<E> {
    private class Node {
        E item;
        Node next;
    }

    private int size;
    private Node first;

    @Override
    public void add(E item) {

        if (contains(item))
            return;

        Node current = new Node();
        current.item = item;
        current.next = first;

        first = current;
        size++;

    }

    @Override
    public boolean contains(E item) {
        Node current = first;

        while (current != null) {
            if (current.item == item) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = first;
        while (current != null) {
            sb.append(current.item);

            if ((current = current.next) != null) {
                sb.append(",");
            }
        }

        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {
        MoveToFrontSet<Integer> z = new MoveToFrontSet<>();
        System.out.println(z.size());
        z.add(1);
        z.add(2);
        z.add(3);
        z.add(2);
        System.out.println(z.size());
        System.out.println(z);
    }

}
