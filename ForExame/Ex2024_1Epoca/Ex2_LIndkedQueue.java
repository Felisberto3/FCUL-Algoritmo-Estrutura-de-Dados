package ForExame.Ex2024_1Epoca;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Ex2_LIndkedQueue<E> implements Queue<E> {
    /**
     * Os n´os desta fila
     */
    private class Node {
        E item;
        Node next;
    }

    /**
     * O n´o de onde retiramos * elementos na fila
     */
    private Node first;
    /**
     * O n´o a partir do qual inserimos * elementos na fila
     */
    private Node last;

    private int size;

    @Override
    public void dequeue() {
        first = first.next;
        if (first == null) {
            last = null;
        }

        size--;
    }

    public int ocurrence(E e) {
        int ocurrence = 0;
        for (Node i = first; i != null; i = i.next)
            if (i.item.equals(e))
                ocurrence++;

        return ocurrence;
    }

    @Override
    public void enqueue(E e) {
        Node newNode = new Node();
        newNode.item = e;

        if (first == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }

        last = newNode;
        size++;

    }

    @Override
    public E front() {
        if (first == null) {
            return null;
        }
        return first.item;
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Ex2_LIndkedQueue<Integer> fila = new Ex2_LIndkedQueue<>();
        fila.enqueue(1);
        fila.enqueue(1);
        fila.enqueue(1);
        fila.enqueue(1);
        fila.enqueue(1);
        fila.enqueue(1);

        System.out.println(fila.ocurrence(1));
        System.out.println("Elementos da fila: ");
        for (Integer integer : fila) {
            System.out.print(integer + " ");
        }

    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node i = first;

            @Override
            public boolean hasNext() {
                return i != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                E current = i.item;
                i = i.next;
                return current;
            }
        };
    }

}
