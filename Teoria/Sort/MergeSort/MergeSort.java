package Teoria.Sort.MergeSort;

import java.util.Arrays;

import Teoria.Sort.InsertionSort.InsertionParams;

public class MergeSort {
    private static Comparable[] b;

    // Comparacoes :
    // ................Melhor Caso: n - 1 => O(n)
    // ................Pior Caso: n^2 / 2 => O(n^2)
    // Trocas :
    // ................Melhor Caso: 0 => O(1)
    // ................Pior Caso: n-1 => O(n)
    // Estável: Sim.
    // Adptativo: Sim.
    // In place: Sim.
    public static void main(String[] args) {
        Integer[] a = { 23, 700, 1, -3, 0, 5, 76, 3 };
        Integer[] v = { 5, 5, 5, 5, 3, 3, 3, 3, 1, 1, 1, 1 };

        sort(v);
        sort(a);
        System.out.print("Array Organizado: ");
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(v));
    }

    public static void sort(Comparable[] a) {
        b = new Comparable[a.length];

        mergeSort(a, 0, a.length - 1);
    }

    public static void mergeSort(Comparable[] v, int lo, int hi) {
        if (lo < hi) {
            if (hi - lo <= 15) {
                InsertionParams.sort(v, lo, hi);
                return;
            }

            int mid = lo + (hi - lo) / 2;

            mergeSort(v, lo, mid);
            mergeSort(v, mid + 1, hi);

            // Se as duas partes do vector pra fazer o merge ja estiver ordenada. Facto que
            // torna as trocas O(n)
            if (v[mid].compareTo(v[mid + 1]) <= 0)
                return;

            merge(v, lo, mid, hi);
        }
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++)
            b[k] = a[k];

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = b[j++];
            } else if (j > hi) {
                a[k] = b[i++];
            } else if (b[i].compareTo(b[j]) > 0) {
                a[k] = b[j++];
            } else {
                a[k] = b[i++];
            }
        }
    }
}
