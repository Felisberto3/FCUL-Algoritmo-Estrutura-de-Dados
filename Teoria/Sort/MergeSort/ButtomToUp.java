package Teoria.Sort.MergeSort;

public class ButtomToUp {
    private static int[] b;

    public static void main(String[] args) {
        int[] a = { 1, 3, 2, 0, 10, 328, -1 };
        sort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] a) {
        b = new int[a.length];

        for (int sz = 1; sz < a.length; sz = sz + sz) {
            for (int lo = 0; lo < a.length - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, a.length - 1));
            }
        }
    }

    public static void merge(int[] a, int lo, int mid, int hi) {

        for (int k = lo; k <= hi; k++)
            b[k] = a[k];

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = b[j++];
            else if (j > hi)
                a[k] = b[i++];
            else if (b[i] > b[j])
                a[k] = b[j++];
            else
                a[k] = b[i++];
        }
    }

}
