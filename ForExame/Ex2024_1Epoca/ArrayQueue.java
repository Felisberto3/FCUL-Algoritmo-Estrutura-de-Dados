package ForExame.Ex2024_1Epoca;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {
    private E[] data;
    private int size;
    private static final int CAPACITY = 100;

    private int front;
    private int rear;

    public ArrayQueue() {
        data = (E[]) new Object[CAPACITY];
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];

        for (int i = 0, j = front; i < size; j = (j + 1) % data.length, i++)
            newData[i] = data[j];

        data = newData;
        front = 0;
        rear = size;
    }

    /**
     * Elimina o primeiro elemento da fila
     * 
     * @requires size != 0;
     * 
     */
    @Override
    public void dequeue() {
        if (size == 0)
            return;
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

    }

    @Override
    public void enqueue(E e) {
        if (size >= data.length / 2) {
            resize(data.length * 2);
        }
        data[rear] = e;
        rear = (rear + 1) % data.length;
        size++;
    }

    /**
     * Mostra o primeiro elemento da fila
     * 
     * @return retorna o primeiro elemento da fila.
     */
    @Override
    public E front() {
        return data[front];
    }

    @Override
    public int size() {
        return size;
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
                if (!hasNext())
                    throw new NoSuchElementException("Nao tem mais elemento na fila!:(");
                E item = data[i];
                i = (i + 1) % data.length;
                count++;
                return item;
            }
        };
    }

}
