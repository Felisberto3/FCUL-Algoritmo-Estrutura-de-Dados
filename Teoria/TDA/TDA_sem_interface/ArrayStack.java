package Teoria.TDA.TDA_sem_interface;

import java.util.Arrays;

public class ArrayStack<E> {
    /**
     * Uma pilha de Elementos do mesmo tipo
     * 
     */
    private E[] data;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public ArrayStack() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
    }

    // push, pop, peek, isEmpty, extras(resize)

    private void resize(int newCapacity) {
        data = Arrays.copyOf(data, newCapacity);
    }

    /**
     * Acrescenta um elemento no topo da pilha
     * 
     * @param e
     */
    public void push(E e) {
        if (size == data.length)
            resize(size * 2);

        data[size++] = e;
    }

    /**
     * elimina o ultimo elemento da pilha
     * 
     * @requires a pilha nao pode estar vazia
     * 
     */
    public void pop() {
        data[--size] = null;

        if (size > 0 && size == data.length / 4)
            resize(data.length / 2);
    }

    /**
     * verifica o elemento no topo da pilha
     * 
     * @requires !isEmpty()
     * @return o valor que esta no topo da pilha
     */
    public E peek() {
        return data[size - 1];
    }

    /**
     * Verifica se a pilha esta vazia
     * 
     * @return retorna True se a pilha esta vazia e false caso contrario.
     */
    public boolean isEmpty() {
        return size == 0;
    }

}
