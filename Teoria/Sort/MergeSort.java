package Teoria.Sort;

public class MergeSort {
    private static int[] b;

    public static void main(String[] args) {
        int[] a = { 3, 0, 2, -3, 5, -9 };
        sort(a);

        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] a) {
        b = new int[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi > lo) {
            int mid = lo + (hi - lo) / 2;
            sort(a, lo, mid);
            sort(a, mid + 1, hi);
            merge(a, lo, mid, hi);
        }
    }

    private static void merge(int[] a, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            b[k] = a[k]; // cópia
        }

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = b[j++];
            else if (j > hi)
                a[k] = b[i++];
            else if (b[j] < b[i])
                a[k] = b[j++];
            else
                a[k] = b[i++];
        }
    }
}