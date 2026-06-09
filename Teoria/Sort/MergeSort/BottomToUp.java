package Teoria.Sort.MergeSort;

import java.util.Arrays;

public class BottomToUp {
    private static Comparable[] b;

    // Comparações e Movimentações:
    // ................Melhor Caso: O(n log n)
    // ................Médio Caso: O(n log n)
    // ................Pior Caso: O(n log n)
    // Estável: Sim (CORRIGIDO com o operador <=).
    // Adaptativo: Não (Esta versão base não tem cutoffs nem testes de salto).
    // In place: Não (Requer o vetor auxiliar 'b' de espaço O(n)).
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
        b = new Comparable[v.length];
        for (int sz = 1; sz < v.length; sz = sz + sz) {
            for (int lo = 0; lo < v.length - sz; lo += sz + sz) {
                merge(v, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, v.length - 1));
            }
        }
    }

    public static void merge(Comparable[] v, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++)
            b[k] = v[k];

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                v[k] = b[j++];
            } else if (j > hi) {
                v[k] = b[i++];
            } else if (b[i].compareTo(b[j]) <= 0) {
                v[k] = b[i++];
            } else {
                v[k] = b[j++];
            }
        }
    }
}
