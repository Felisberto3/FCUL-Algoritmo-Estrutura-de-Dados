package Serie05;

import java.util.Arrays;

public class ArrayList<E> implements Stack<E> {
    private E[] data;
    private int size;

    private static final int CAPACITY = 8;

    public ArrayList() {
        data = (E[]) new Object[CAPACITY];
    }

    @Override
    public E peek() {
        return data[size - 1];
    }

    @Override
    public void pop() {
        data[--size] = null;

        if (size > 0 && size == data.length / 4) {
            resize(data.length / 2);
        }
    }

    private void resize(int newSize) {
        data = Arrays.copyOf(data, newSize);
    }

    @Override
    public void push(E item) {
        if (size == data.length) {
            resize(data.length * 2);
        }

        data[size++] = item;

    }

    @Override
    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < size; i++) {

            sb.append(data[i]);

            if (size - 1 > i)
                sb.append(",");
        }

        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayList<Integer> pilha = new ArrayList<>();

        System.out.println("is empty: " + pilha.isEmpty());
        pilha.push(1);
        pilha.push(2);
        pilha.push(3);
        System.out.println("is empty: " + pilha.isEmpty());
        // pilha.push(1);

        System.out.println(pilha);
    }
}
