package ForExame.Ex2023_2Epoca;

import java.util.Random;

public class EX03_Ordenacao {
    public static void main(String[] args) {
        Integer[] a = { 3, 5, 6, 7 };
        shuffle(a);
        for (int i : a) {
            System.out.print(i + " ");
        }

    }

    public static boolean ua(int i) {
        System.out.println("Dentro " + i);
        return i > 5;
    }

    public static void quick(Comparable[] a, int l, int h) {
        if (l < h) {
            int j = partition(a, l, h);
            quick(a, l, j - 1);
            quick(a, j + 1, h);
        }
    }

    public static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];

        while (less(a, i, j)) {

        }

        return -1;

    }

    public static void shuffle(Comparable[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            Random r = new Random();
            exch(a, r.nextInt(i + 1), i);
        }
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }

    public static boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }
}
