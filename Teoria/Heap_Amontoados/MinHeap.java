package Teoria.Heap_Amontoados;

public class MinHeap<Key extends Comparable<Key>> {
    Key[] heap;
    private int size;

    public MinHeap(int n) {
        this.heap = (Key[]) new Comparable[n + 1];
    }

    public MinHeap(Key[] arr) {
        this(arr.length);
        size = arr.length;

        for (int i = 0; i < arr.length; i++) {
            this.heap[i + 1] = arr[i];
        }

        heapify();
    }

    public Key delMin() {
        Key min = this.heap[1];
        exch(1, size--);
        this.heap[size + 1] = null;
        sink(1);
        return min;
    }

    private void heapify() {
        for (int k = size / 2; k >= 1; k--) {
            sink(k);
        }
    }

    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && less(j + 1, j))
                j++;
            if (!less(j, k))
                break;
            exch(k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        Integer[] a = { 2, 1, 0, 3, 1, 4, 2 };
        // MaxHeap<Integer> maxHeap = new MaxHeap<>(10);
        MinHeap<Integer> minHeap = new MinHeap<>(a);

        // for (Object i : minHeap.heap) {
        // System.out.print(i + " ");
        // }

        for (int i = 0; i < a.length; i++) {
            System.out.println("Min : => " + minHeap.delMin());
        }
    }

    private boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;

    }

    private void exch(int i, int j) {
        Key a = heap[i];
        heap[i] = heap[j];
        heap[j] = a;
    }

}