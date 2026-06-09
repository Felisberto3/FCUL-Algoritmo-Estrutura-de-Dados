package Teoria.Sort.InsertionSort;

import java.util.Arrays;

public class InsertionParams {
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

    public static void sort(Comparable[] v) {
        sort(v, 0, v.length - 1);
    }

    public static void sort(Comparable[] v, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            for (int j = i; j > 0 && less(v[j], v[j - 1]); j--)
                exch(v, j, j - 1);
        }
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable[] v, int i, int j) {
        Comparable aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
