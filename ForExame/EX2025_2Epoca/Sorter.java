package ForExame.EX2025_2Epoca;

import java.util.Random;

public class Sorter {
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable[] v, int i, int j) {
        Comparable aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

    public static void shuffle(Comparable[] a) {
        Random rand = new Random();
        for (int i = a.length - 1; i > 0; i--) {
            exch(a, i, rand.nextInt(i + 1));
        }
    }
}
