package Teoria.Sort.QuickSort;

public class QuickSimple {
    public static void main(String[] args) {
        int[] a = { 4, 2, 8, 32, 8, 2, 1, 1, 1, 9, -6, 5 };

        sort(a, 0, a.length - 1);

        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] a, int lo, int hi) {
        if (lo < hi) {
            int j = partition(a, lo, hi);
            sort(a, lo, j - 1);
            sort(a, j + 1, hi);
        }
    }

    public static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        int v = a[lo];

        while (true) {
            while (v > a[++i]) {
                if (i == j)
                    break;
            }
            while (v < a[--j]) {
                if (lo == j)
                    break;
            }

            if (i >= j)
                break;

            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    static void exch(int[] a, int i, int j) {
        int aux = a[j];
        a[j] = a[i];
        a[i] = aux;
    }

}
