package ForExame.Ex2023_1Epoca;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @param <E> Tipo do Elemento na fila
 */
public class EX02_ArrayQueue<E> implements Queue<E> {

    /**
     * Os elementos na fila
     */
    private E[] data;

    /**
     * indice do primeiro front
     */
    private int front;

    /**
     * Indice depois da cauda da lista
     */
    private int rear;

    /**
     * tamanho de elementos na fila
     */
    private int size;

    /**
     * Default capacity
     */
    private static int DEFAULT_CAPACITY = 40;

    public EX02_ArrayQueue() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * @deprecated E elemento a ser procurado
     * @requires E != null
     * @return true se encontrar o elemento e false caso contrario
     */
    @Override
    public boolean contains(E e) {
        for (int i = front, count = 0; count < size; i = (i + 1) % data.length, count++)
            if (data[i].equals(e))
                return true;
        return false;
    }

    /**
     * Elimina o ultimo elemento do Array
     */
    @Override
    public void dequeue() {
        if (size >= data.length * 3 / 4)
            resize(data.length * 2);

        data[front] = null;
        front = (front + 1) % data.length;
        size--;
    }

    @SuppressWarnings("uncheched")
    public void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];

        for (int i = 0, j = front; i < size; j = (j + 1) % data.length, i++) {
            newData[i] = data[j];
        }

        data = newData;
        front = 0;
        rear = size;
    }

    @Override
    public void enqueue(E e) {
        if (size < data.length * 3 / 4)
            resize(data.length * 2);

        data[rear] = e;
        rear = (rear + 1) % data.length;
        size++;
    }

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
            private int i = front;
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E item = data[i];
                i = (i + 1) % data.length;
                count++;

                return item;

            }
        };
    }

    public static void main(String[] args) {
        EX02_ArrayQueue<Integer> fila = new EX02_ArrayQueue<>();
        fila.enqueue(1);
        fila.enqueue(4);
        fila.enqueue(5);

        for (Integer integer : fila) {
            System.out.print(integer + " ");
        }
        System.out.println();

        System.out.println(fila.front());

        System.out.println("========TEstando contains =========");

        System.out.println("contains 4: " + fila.contains(4));
        System.out.println("contains 7: " + fila.contains(7));
        fila.dequeue();

        System.out.println(fila.front());

        for (Integer integer : fila) {
            System.out.print(integer + " ");
        }

    }

}
