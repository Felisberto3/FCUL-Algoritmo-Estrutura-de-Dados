package Teoria.Sort.MergeSort;

import java.util.List;

public class TopToDown {
    private static int[] b;

    public static void main(String[] args) {
        int[] a = { 1, 3, 2, 0, 10, 328, -1 };
        sort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] a) {
        b = new int[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(int a[], int lo, int hi) {

        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            sort(a, lo, mid);
            sort(a, mid + 1, hi);
            merge(a, lo, mid, hi);
        }
    }

    private static void merge(int[] a, int lo, int mid, int hi) {

        for (int k = 0; k <= hi; k++)
            b[k] = a[k];

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = b[j++];
            } else if (j > hi) {
                a[k] = b[i++];
            } else if (b[i] > b[j]) {
                a[k] = b[j++];
            } else {
                a[k] = b[i++];
            }
        }
    }
}
