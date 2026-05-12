package Teoria.Sort;

/**
 * EStou apresentando um merge Sort Optimizado
 */
public class MergeSort2 {

    public static void main(String[] args) {
        Integer x = 5;
        Integer y = -2;
        System.out.println(x.compareTo(y));
        int[] a = { 2, 5, -1, 11, 0 };
        sort(a);

        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] a) {
        int[] b = a.clone(); // cópia inicial
        sort(b, a, 0, a.length - 1);
    }

    private static void sort(int[] src, int[] dst, int lo, int hi) {
        if (lo >= hi)
            return;

        int mid = (lo + hi) / 2;

        // 🔁 troca papéis
        sort(dst, src, lo, mid);
        sort(dst, src, mid + 1, hi);

        merge(src, dst, lo, mid, hi);
    }

    private static void merge(int[] src, int[] dst, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                dst[k] = src[j++];
            else if (j > hi)
                dst[k] = src[i++];
            else if (src[j] < src[i])
                dst[k] = src[j++];
            else
                dst[k] = src[i++];
        }
    }
}
