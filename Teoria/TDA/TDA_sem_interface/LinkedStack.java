package Teoria.TDA.TDA_sem_interface;

public class LinkedStack<E> {
    /**
     * topo da pilha
     * O nó que foi mais recentemente adicionado
     */
    private Node first;

    /**
     * os nós desta pilha
     */
    private class Node {
        E item;
        Node next;
    }

    // push, pop, peek, isEmpty

    /**
     * acrescenta um elemento no topo da pilha
     * 
     * @param e elemento a ser incluido no topo da pilha
     */
    public void push(E e) {
        Node oldTop = first;
        first = new Node();
        first.item = e;
        first.next = oldTop;
    }

    /**
     * verifica se a pilha esta vazia
     * 
     * @return retorna true se estiver vazia e false caso contrario
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * retira o elemento no topo da pilhas
     * 
     * @requires a pilha nao esta vazia
     */
    public void pop() {
        first = first.next;
    }

    /**
     * mostra o elemento no topo da lista
     * 
     * @requires a pilha nao esta vazia
     * @return retorna o elemento no topo da pilha
     */
    public E peek() {
        return first.item;
    }
}
