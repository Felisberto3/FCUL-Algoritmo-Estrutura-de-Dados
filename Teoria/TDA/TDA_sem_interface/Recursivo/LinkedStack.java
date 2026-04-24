package Teoria.TDA.TDA_sem_interface.Recursivo;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<E> implements Iterable<E> {
    public class Node {
        E item;
        Node next;
    }

    private Node first;

    public void push(E item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = first;
        first = newNode;
    }

    public E pop() {
        E item = first.item;
        first = first.next;

        return item;
    }

    public E peek() {
        return first.item;
    }

    private class LinkedStackIterator implements Iterator<E> {
        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Pilha esta vazia");
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = first;
        if (current != null) {
            sb.append(current.item);
            current = current.next;
        }

        while (current != null) {
            sb.append(",").append(current.item);
            current = current.next;
        }

        return sb.append("]").toString();
    }

    public String toString2() {
        Iterator<E> it = this.iterator();
        StringBuilder sb = new StringBuilder("[");
        if (it.hasNext()) {
            sb.append(it.next());
        }

        while (it.hasNext()) {
            sb.append(",").append(it.next());
        }

        return sb.append("]").toString();
    }

    public static void main(String[] args) {

        LinkedStack<Integer> pilha = new LinkedStack<>();

        pilha.push(10);
        pilha.push(5);
        pilha.push(10);
        for (Integer integer : pilha) {
            System.out.println(integer);
        }

        System.out.println(pilha.toString2());

    }
}
