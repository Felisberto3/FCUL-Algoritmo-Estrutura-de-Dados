package Serie07.ex5;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Iterable<E> {
    private int front;
    private int near;
    private int size;
    private E[] data;

    private final int CAPACITY = 8;

    public ArrayQueue() {
        data = (E[]) new Object[CAPACITY];
    }

    public void enqueue(E item) {
        data[near] = item;
        near = (near + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];

        for (int i = 0, j = front; i < size; i++, j = (j + 1) % data.length) {
            newData[i] = data[j];
        }
        front = 0;
        near = size;
        data = newData;
    }

    public E dequeue() {
        E item = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size > 0 && size == data.length / 4) {
            resize(data.length * 2);
        }
        return item;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int i = front;
            private int count = 0;

            public boolean hasNext() {
                return count < size;
            }

            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Fila Vazia!");
                }
                E item = data[i];
                i = (i + 1) % data.length;
                count++;
                return item;
            }
        };
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> q = new ArrayQueue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        for (Integer i : q) {
            System.out.println(i);
        }
    }

}