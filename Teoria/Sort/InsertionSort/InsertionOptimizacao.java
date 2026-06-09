package Teoria.Sort.InsertionSort;

import java.util.Arrays;

public class InsertionOptimizacao {
    // Comparacoes :
    // ................Melhor Caso: n - 1 => O(n)
    // ................Pior Caso: n^2 / 2 => O(n^2)
    // Trocas :
    // ................Melhor Caso: 0 => O(1)
    // ................Pior Caso: n^2 / 2 => O(n^2)
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
        for (int i = 1; i < v.length; i++) {
            Comparable chave = v[i];
            int j = i;
            while (j > 0 && less(chave, v[j - 1])) {
                v[j] = v[j - 1];
                j--;
            }
            v[j] = chave;
        }
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}
