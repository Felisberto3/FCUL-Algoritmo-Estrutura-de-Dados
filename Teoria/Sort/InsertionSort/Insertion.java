package Teoria.Sort.InsertionSort;

public class Insertion {
    public static void main(String[] args) {
        // int[] a = { 2, 54, 65, 3, 2, -1, 5, 0, 0, 3 };

        int[] a = { 23, 700, 1, -3, 0, 5, 76, 3 };
        otherSort(a);

        for (int i : a) {
            System.out.print(i + " ");
        }

    }

    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    public static boolean less(int[] a, int i, int j) {
        return a[i] < a[j];
    }

    public static void exch(int[] a, int i, int j) {
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }

    public static void otherSort(int[] a) {
        for (int i = 1; i < a.length; i++)
            for (int j = i; j > 0 && less(a, j, j - 1); j--)
                exch(a, j, j - 1);
    }
}
