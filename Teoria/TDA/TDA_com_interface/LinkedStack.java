package Teoria.TDA.TDA_com_interface;

public class LinkedStack<E> implements Stack<E> {
    private Node first;

    /**
     * Os nos da pilha
     */
    private class Node {
        E item;
        Node next;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return first == null;
    }

    @Override
    public E peek() {
        // TODO Auto-generated method stub
        return first.item;
    }

    @Override
    public void pop() {
        // TODO Auto-generated method stub
        first = first.next;
    }

    @Override
    public void push(E e) {
        // TODO Auto-generated method stub
        Node oldFirst = first;
        first = new Node();
        first.item = e;
        first.next = oldFirst;

    }

}
