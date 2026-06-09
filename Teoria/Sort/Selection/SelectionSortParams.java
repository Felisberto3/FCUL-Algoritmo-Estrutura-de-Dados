package Teoria.Sort.Selection;

import java.util.Arrays;

public class SelectionSortParams {
    // Comparacoes : Todos os casos => n^2 / 2 => O(n^2 )
    // Trocas: Todos os casos => n-1 trocas => O(n )
    // Estával: Não.
    // Adptativo: Não.
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
        for (int i = lo; i <= hi; i++) {
            int min = i;
            for (int j = i + 1; j <= hi; j++) {
                if (less(v[j], v[min]))
                    min = j;
            }

            exch(v, i, min);
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
