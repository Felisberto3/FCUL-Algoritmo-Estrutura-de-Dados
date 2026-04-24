package Serie07.ex1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<E> implements Stack<E> {
    private class Node {
        E item;
        Node next;
    }

    private Node first;

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public E peek() {
        return first.item;
    }

    @Override
    public E pop() {
        E item = first.item;
        first = first.next;
        return item;
    }

    @Override
    public void push(E item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = first;
        first = newNode;
    }

    private class LinkedStackIterator implements Iterator<E> {
        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (current == null) {
                throw new NoSuchElementException("Lista vazia!");
            }

            E item = current.item;
            current = current.next;
            return item;
        }

    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedStackIterator();
    }

}
