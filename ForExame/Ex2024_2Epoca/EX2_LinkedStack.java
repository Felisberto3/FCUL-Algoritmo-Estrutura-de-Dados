package ForExame.Ex2024_2Epoca;

public class EX2_LinkedStack<E extends Comparable<E>> implements Stack<E> {
    /**
     * Nos da pilha
     */
    private class Node {
        E item;
        Node next;
    }

    /**
     * Top da pilha;
     */
    private Node first;

    /**
     * Quantidade de elementos na pilha;
     */
    private int size;

    /**
     * Remove o topo da pilha
     * 
     * @requires first!= null;
     */
    @Override
    public void pop() {
        first = first.next;

    }

    /**
     * Acrescenta um elemento no topo da pilha
     * 
     * @requires e != null;
     */
    @Override
    public void push(E e) {
        Node newNode = new Node();
        newNode.item = e;
        newNode.next = first;

        first = newNode;
        size++;

    }

    /**
     * Devolve a quantidade de elemento na pilha
     * 
     * @return A quantidade de Elemento na pilha
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @require first!= null;
     * @return O elemento que esta no topo da pilha
     */
    @Override
    public E top() {
        return first.item;
    }

    public boolean isOrdemCrescente() {

        for (Node i = first; i != null; i = i.next) {
            if (i.next == null)
                return true;
            if (i.item.compareTo(i.next.item) >= 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        EX2_LinkedStack<Integer> stack = new EX2_LinkedStack<>();
        stack.push(5);
        stack.push(3);
        System.out.println("Stack => " + stack.isOrdemCrescente());
    }

}
