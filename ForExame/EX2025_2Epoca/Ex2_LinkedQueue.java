package ForExame.EX2025_2Epoca;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ForExame.Ex2023_1Epoca.Queue;

public class Ex2_LinkedQueue<E> implements Queue<E> {
    /**
     * Os nós desta fila
     */
    private class Node {
        E item;
        Node next;
    }

    /**
     * O nó de onde retiramos
     * elementos na fila
     */
    private Node first;
    /**
     * O nó a partir do qual inserimos
     * elementos na fila
     */
    private Node last;

    private int size;

    @Override
    public boolean contains(E e) {
        for (Node i = first; i != null; i = i.next) {
            if (i.item.equals(e)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void dequeue() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        first = first.next;
        if (first == null) {
            last = null;
        }
        size--;

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
            throw new NoSuchElementException("Lista vazia");
        }
        return first.item;
    }

    @Override
    public int size() {
        return size;
    }

    public void deleteLast() {
        if (first == null) {
            return;
        }

        if (first.next == null) {
            first = last = null;
            size--;
            return;
        }

        Node i = first;
        while (i.next.next != null) {
            i = i.next;
        }

        i.next = null;
        last = i;
        size--;
    }

    public void delete(E e) {
        if (first == null) {
            return;
        }

        if (first.item.equals(e)) {
            first = first.next;
            if (first == null)
                last = null;
            size--;
            return;
        }

        for (Node i = first; i.next != null; i = i.next) {

            if (i.next.item.equals(e)) {
                if (i.next == last)
                    last = i;

                i.next = i.next.next;
                size--;

                return;
            }
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node i = first;

            @Override
            public boolean hasNext() {
                return i != null;
            }

            @Override
            public E next() {
                if (!hasNext())
                    throw new NoSuchElementException("Fila vazia");
                E item = i.item;
                i = i.next;
                return item;
            }

        };
    }

}