package Teoria.TDA.TDA_com_interface;

import java.util.Arrays;

public class ArrayStack<E> implements Stack<E> {
    private static final int INITIAL_CAPACITY = 10;
    /**
     * pilha emplementada com array
     * 
     * @params E tipo de dado da pilha
     */
    private E[] data;
    private int size;

    public ArrayStack() {
        data = (E[]) new Object[INITIAL_CAPACITY];
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return size == 0;
    }

    @Override
    public E peek() {
        // TODO Auto-generated method stub
        return data[size - 1];
    }

    @Override
    public void pop() {
        // TODO Auto-generated method stub
        data[--size] = null;

        if (size > 0 && size == data.length / 4) {
            resize(data.length / 2);
        }
    }

    /**
     * redimenciona o array
     */
    private void resize(int capacity) {
        data = Arrays.copyOf(data, capacity);
    }

    @Override
    public void push(E e) {
        // TODO Auto-generated method stub
        if (size == data.length)
            resize(size * 2);

        data[size++] = e;
    }

}
