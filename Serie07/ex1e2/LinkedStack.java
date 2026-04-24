package Serie07.ex1e2;

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

    /**
     * Verifica se algo item esta na lista
     * 
     * @requires item não pode ser null
     * @param item é o elemento procurado
     * @return True se o elemento *item* estiver na lista
     */
    public boolean contains(E item) {
        for (E element : this) {
            if (element.equals(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica se algo item esta na lista
     * 
     * @requires item não pode ser null
     * @param item é o elemento procurado
     * @return True se o elemento *item* estiver na lista
     */
    public boolean contain(E item) {
        Iterator<E> it = this.iterator();

        while (it.hasNext()) {
            if (it.next().equals(item)) {
                return true;
            }
        }

        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator<E> iterator = this.iterator();
        if (iterator.hasNext()) {
            sb.append(iterator.next());
        }
        while (iterator.hasNext()) {
            sb.append(",").append(iterator.next());
        }

        return sb.append("]").toString();
    }

    public static void main(String[] args) {
        LinkedStack<Integer> pilha = new LinkedStack<>();
        pilha.push(10);
        pilha.push(7);
        pilha.push(9);

        boolean ya = pilha.contains(7);
        System.out.println("is true: " + ya);

        System.out.println(pilha);

        // Respondendo pergunta numero 2.
        // Não precisamos de alterar nada nas estruturas de dados
        // ArrayQueue e ArrayStack se na verdade eles emplementam os seus mesmos
        // Iteradores
        // Porque estamos usamos a TDA do iterator em todos os casos, isso significa que
        // nao
        // precisamos nos preocupar a emplementacoa de cada Estrutura de Dados

    }

}
