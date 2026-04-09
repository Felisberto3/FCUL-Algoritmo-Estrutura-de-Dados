package Serie06;

public class ArrayQueue<E> implements Queue<E> {
    private E[] data;
    private int front;
    private int rear;
    private int size;

    private static final int CAPACITY = 8;

    public ArrayQueue() {
        data = (E[]) new Object[CAPACITY];
    }

    public ArrayQueue(Queue<E> q) {
        data = (E[]) new Object[CAPACITY];
        int n = q.size();

        for (int i = 0; i < n; i++) {
            E elem = q.front();
            q.dequeue();
            q.enqueue(elem);
            this.enqueue(elem);
        }
    }

    private void resize(int newLength) {
        E[] newData = (E[]) new Object[newLength];

        for (int i = 0, j = front; i < size; i++, j = (j + 1) % data.length)
            newData[i] = data[j];

        data = newData;
        front = 0;
        rear = size;
    }

    @Override
    public void dequeue() {
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size > 0 && size == data.length / 4) {
            resize(data.length / 2);
        }
    }

    @Override
    public void enqueue(E e) {
        if (size == data.length)
            resize(data.length * 2);

        data[rear] = e;
        rear = (rear + 1) % data.length;
        size++;
    }

    public int size() {
        return size;
    }

    @Override
    public E front() {

        return data[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        if (size >= 1) {
            sb.append(data[front]);
        }

        for (int i = 1, j = (front + 1) % data.length; i < size; i++, j = (j + 1) % data.length) {
            sb.append(",").append(data[j]);
        }

        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> fila = new ArrayQueue<>();
        System.out.println(fila.size());
        fila.enqueue(1);

        fila.dequeue();
        fila.enqueue(2);
        fila.dequeue();
        fila.enqueue(3);
        fila.dequeue();

        System.out.println(fila.size());

        System.out.println(fila);

    }

}
