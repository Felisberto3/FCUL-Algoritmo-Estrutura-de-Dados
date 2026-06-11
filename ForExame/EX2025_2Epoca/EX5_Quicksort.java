package ForExame.EX2025_2Epoca;

public class EX5_Quicksort {
    private static int M = 15;

    public static void sort(Comparable[] a) {
        Sorter.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi > lo) {
            if (hi - lo + 1 <= M) {
                insertion(a, lo, hi);
                return;
            }
            int j = partition(a, lo, hi);
            sort(a, lo, j - 1);
            sort(a, j + 1, hi);
        }
    }

    public static void insertion(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            for (int j = i; j > 0; j--)
                if (Sorter.less(j - 1, j))
                    Sorter.exch(a, j, j - 1);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable pivot = a[lo];
        while (lo <= hi) {
            while (Sorter.less(a[++i], pivot))
                if (i == hi)
                    break;
            while (Sorter.less(pivot, a[--j]))
                if (j == lo)
                    break;
            if (i >= j)
                break;

            Sorter.exch(a, i, j);

        }
        Sorter.exch(a, lo, j);

        return j;
    }
}