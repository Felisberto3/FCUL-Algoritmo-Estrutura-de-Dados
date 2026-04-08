package Serie05;


public class LinkedList<E> implements Stack<E> {
    private class Node {
        E item;
        Node next;
    }

    private Node first;
    private int size;


    @Override
    public E peek() {
       return  first.item;
    }

    @Override
    public E pop() {
        Node oldFirst = first;
        first = first.next;
        return oldFirst.item;
    }

    @Override
    public void push(E item) {
        Node current  = new Node();
        current.item = item;

        if (first != null) {
            current.next = first;
        }
        first = current;
        size++;
        
    }

    @Override
    public int size() {
        return size;
    }

    // ex2
    @Override
    public String toString() {
       Node current = first;

       StringBuilder sb = new StringBuilder();

       while (current != null) {
         sb.append(current.item);
         current = current.next;
       }

       return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> pilha = new LinkedList<>();
        pilha.push(1);
        pilha.push(2);
        pilha.push(3);
        pilha.push(1);

        System.out.println(pilha);
    }


}
