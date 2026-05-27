package Teoria.Heap_Amontoados;

public class MaxHeap<Key extends Comparable<Key>> {
    private Key[] heap;
    private int size = 0;

    public MaxHeap(int n) {
        this.heap = (Key[]) new Comparable[n + 1];
    }

    public MaxHeap(Key[] arr) {
        this(arr.length);

        for (int i = 0; i < arr.length; i++) {
            this.heap[i + 1] = arr[i];
        }

        size = arr.length;

        heapify();
    }

    private boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    public void exch(int i, int j) {
        Key aux = heap[i];
        heap[i] = heap[j];
        heap[j] = aux;
    }

    public void insert(Key key) {
        heap[++size] = key;
        swim(size);
    }

    private void heapify() {
        for (int i = size / 2; i >= 1; i--) {
            sink(i);
        }
    }

    public Key delMax() {
        Key max = heap[1];
        exch(1, size--);
        heap[size + 1] = null;
        sink(1);

        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;

            if (j < size && less(j, j + 1))
                j++;

            if (!less(k, j))
                break;

            exch(k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        Integer[] a = { 2, 1, 0, 3, 1, 4, 2 };
        // MaxHeap<Integer> maxHeap = new MaxHeap<>(10);
        MaxHeap<Integer> maxHeap = new MaxHeap<>(a);

        // for (int i : a) {
        // maxHeap.insert(i);
        // }

        for (int i = 0; i < a.length; i++) {
            System.out.println("Max: => " + maxHeap.delMax());
        }
    }

}