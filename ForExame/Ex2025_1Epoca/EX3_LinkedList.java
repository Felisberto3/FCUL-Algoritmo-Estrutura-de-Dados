package ForExame.Ex2025_1Epoca;

public class EX3_LinkedList<E> {
    /**
     * Os nós desta lista
     */
    private class Node {
        E item;
        Node next;
    }

    /**
     * O primeiro nó
     */
    private Node first;
    /**
     * O número de elementos nesta lista
     */
    private int size;

    public void add(E e) {
        Node newNode = new Node();
        newNode.item = e;
        newNode.next = first;
        first = newNode;
        size++;

    }

    public void delete(E e) {
        if (first.item.equals(e)) {
            first = first.next;
            size--;
            return;
        }
        for (Node i = first; i.next != null; i = i.next) {
            if (i.next.item.equals(e)) {
                i.next = i.next.next;
                size--;
                return;
            }
        }
    }

    /**
     * Procura o index de um determinado elemento
     * 
     * @param e Elemento a ser pesquisado
     * @return - 1 se o elemento nao foi achado, caso contrario retorna o index do
     *         elemento q neste caso é maior ou que 0.
     */
    public int indexOf(E e) {
        int index = 0;
        for (Node current = first; current != null; current = current.next, index++) {
            if (current.item.equals(e)) {
                return index;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        EX3_LinkedList<Integer> l = new EX3_LinkedList<>();

        l.add(1);
        l.add(4);
        l.add(9);

        System.out.println("Index: ");
        System.out.println(l.indexOf(1));

        System.out.println("Deletando elemento..");
        l.delete(15);
        System.out.println(l.indexOf(1));
    }
}