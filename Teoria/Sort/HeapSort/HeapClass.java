package Teoria.Sort.HeapSort;

public class HeapClass {
    public static void main(String[] args) {
        int[] a = { 0, 1, 60, 50, 8, 20, 100 };
        sort(a);

        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] a) {
        int n = a.length - 1;

        // Fazendo o heapify
        for (int k = n / 2; k >= 1; k--) {
            sink(a, k, n);
        }

        while (n > 1) {
            exch(a, 1, n--);
            sink(a, 1, n);
        }
    }

    public static void sink(int[] a, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(a, j, j + 1))
                j++;
            if (!less(a, k, j))
                break;
            exch(a, k, j);
            k = j;

        }
    }

    public static void exch(int[] a, int k, int j) {
        int aux = a[k];
        a[k] = a[j];
        a[j] = aux;
    }

    public static boolean less(int[] a, int i, int j) {
        return a[i] < a[j];
    }
}
