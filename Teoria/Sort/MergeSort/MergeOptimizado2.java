package Teoria.Sort.MergeSort;

import java.util.Arrays;

import Teoria.Sort.InsertionSort.InsertionParams;

public class MergeOptimizado2 {
    // Comparações e Movimentações:
    // ................Melhor Caso: O(n log n)
    // ................Médio Caso: O(n log n)
    // ................Pior Caso: O(n log n)
    // Estável: Sim.
    // Adaptativo: Sim (Usa o InsertionSort para acelerar sub-vetores pequenos).
    // In place: Não (Requer espaço extra O(n) devido ao dst.clone()).
    public static void main(String[] args) {
        Integer[] a = { 23, 700, 1, -3, 0, 5, 76, 3 };
        Integer[] v = { 5, 5, 5, 5, 3, 3, 3, 3, 1, 1, 1, 1 };

        sort(v);
        sort(a);
        System.out.print("Array Organizado: ");
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(v));
    }

    public static void sort(Comparable[] dst) {
        Comparable[] src = dst.clone();
        mergeSort(src, dst, 0, dst.length - 1);
    }

    public static void mergeSort(Comparable[] src, Comparable[] dst, int lo, int hi) {
        if (lo < hi) {

            // se o pedaço do array a ser ordenado for menor que 15 elementos.
            if (hi - lo <= 15) {
                InsertionParams.sort(dst, lo, hi);
                for (int k = lo; k <= hi; k++)
                    src[k] = dst[k];
                return;
            }
            int mid = lo + (hi - lo) / 2;

            mergeSort(dst, src, lo, mid);
            mergeSort(dst, src, mid + 1, hi);

            // Se as duas partes do vector pra fazer o merge ja estiver ordenada. Facto que
            // torna as trocas O(n)
            if (src[mid].compareTo(src[mid + 1]) <= 0) {
                for (int k = lo; k <= hi; k++)
                    dst[k] = src[k];
                return;
            }
            merge(src, dst, lo, mid, hi);
        }
    }

    public static void merge(Comparable[] src, Comparable[] dst, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                dst[k] = src[j++];
            } else if (j > hi) {
                dst[k] = src[i++];
            } else if (less(src[i], src[j])) {
                dst[k] = src[i++];
            } else {
                dst[k] = src[j++];
            }
        }
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}
