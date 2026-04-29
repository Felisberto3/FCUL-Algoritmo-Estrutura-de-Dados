package Serie07.ex3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {
    private E[] data;
    private int front;
    private int near;
    private int size;

    private static final int CAPACITY = 8;

    public ArrayQueue() {
        data = (E[]) new Object[CAPACITY];
    }

    public ArrayQueue(Queue<E> queue) {
        this();

        for (E e : queue) {
            this.enqueue(e);
        }

    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];

        for (int i = 0, j = front; i < size; i++, j = (j + 1) % data.length) {
            newData[i] = data[j];
        }

        near = size;
        front = 0;
        data = newData;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Fila esta vazia!");
        }

        E item = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size > 0 && size == data.length / 4) {
            resize(size * 2);
        }

        return item;
    }

    @Override
    public void enqueue(E item) {
        if (size == data.length) {
            resize(data.length * 2);
        }

        data[near] = item;
        near = (near + 1) % data.length;
        size++;

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int i = front;
            int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                E item = data[i];
                i = (i + 1) % data.length;
                count++;
                return item;
            }
        };
    }

    public static class Node<E> {
        E item;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayQueue<>();
        System.out.println(q.isEmpty());
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        for (Integer integer : q) {
            System.out.print(integer + ",");
        }
        System.out.println("Fila r");
        ArrayQueue<Integer> r = new ArrayQueue<>(q);

        for (Integer integer : r) {
            System.out.print(integer + ",");
        }

        Queue<Node<String>> u = new ArrayQueue<>();
        Node<String> ya = new Node<>();
        ya.item = "String";
        u.enqueue(ya);
        Queue<Node<String>> t = new ArrayQueue<>(u);

        for (Node<String> node : t) {
            System.out.println("item T: " + node.item);
        }

        for (Node<String> y : u) {
            System.out.println("Item U: " + y.item);
            y.item = "FAlou";
        }

        for (Node<String> y : t) {
            System.out.println("Item T: " + y.item);
        }
        // System.out.println(q.dequeue());
        // System.out.println(q.dequeue());
        // System.out.println(q.dequeue());
    }
}
