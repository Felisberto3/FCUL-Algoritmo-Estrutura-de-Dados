package ForExame.Ex2023_2Epoca;

public class EX02_LinkedQueue<E> implements Queue<E> {
    private int size;

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

    @Override
    public void dequeue() {
        if (first == null) {
            return;
        }

        first = first.next;

        if (first == null) {
            last = null;
        }
        size--;
    }

    /**
     * Acrescenta elemento na fila
     * 
     * @params E elemento que sera acrescentado na fila
     */
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
    public int size() {
        return size;
    }

    /**
     * Verifica se dado elemento esta na fila
     * 
     * @param e Elemento a ser pesquisado
     * @return true caso estiver na fila e false caso contrario.
     */
    public boolean contains(E e) {
        for (Node i = first; i != null; i = i.next) {
            if (i.item.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public boolean contains2(E e) {
        return containRec(e, first);
    }

    private boolean containRec(E e, Node x) {
        if (x == null) {
            return false;
        }
        return x.item.equals(e) || containRec(e, x.next);
    }

    /**
     * @requires A fila nao pode estar vazia
     * @return O primeiro elemento;
     */
    @Override
    public E peek() {
        return first.item;
    }

    public static void main(String[] args) {
        EX02_LinkedQueue<Integer> q = new EX02_LinkedQueue<>();

        q.enqueue(2);
        q.enqueue(110);
        q.enqueue(-3);
        q.enqueue(89);

        System.out.println(q.contains(89));
    }

}