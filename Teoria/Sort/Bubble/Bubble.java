package Teoria.Sort.Bubble;

import java.util.Arrays;

public class Bubble {

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
        for (int i = v.length - 2; i >= 0; i--) {
            boolean exchanges = false;
            for (int j = 0; j <= i; j++) {
                if (less(v[j + 1], v[j])) {
                    exch(v, j, j + 1);
                    exchanges = true;
                }
            }

            if (!exchanges)
                return;
        }
    }

    public static void exch(Comparable[] v, int i, int j) {
        Comparable aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

}