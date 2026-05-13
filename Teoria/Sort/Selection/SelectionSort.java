package Teoria.Sort.Selection;

public class SelectionSort {
    public static void main(String[] args) {
        int[] a = { 23, 700, 1, -3, 0, 5, 76, 3 };
        sort(a);

        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] a) {
        for (int i = 0; i < a.length - 2; i++) {
            int min = i;
            for (int j = min; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }

            exch(a, i, min);
        }
    }

    public static void exch(int[] a, int min, int j) {
        int aux = a[min];
        a[min] = a[j];
        a[j] = aux;
    }
}
