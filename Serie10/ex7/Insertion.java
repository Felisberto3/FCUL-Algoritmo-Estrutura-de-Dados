package Serie10.ex7;

public class Insertion {
    class Item implements Comparable<Item> {
        int item;

        @Override
        public int compareTo(Item arg0) {
            return this.item - arg0.item;
        }

    }

    public static void main(String[] args) {
        int[] v = { 4, 5, 6, 3 / 5, -2 };
        Insertion.bubble(v);

        for (int i : v) {
            System.out.print(i + ",");
        }
    }

    public static void sort1(int[] v) {
        for (int i = 1; i < v.length; i++) {
            int key = v[i];
            int j = i;
            while (j > 0 && v[j - 1] > key) {
                v[j] = v[j - 1];
                j--;
            }
            v[j] = key;
        }
    }

    public static void sort2(int[] v) {
        for (int i = 1; i < v.length; i++) {
            int key = v[i];
            int j = i - 1;

            while (j >= 0 && v[j] > key) {
                v[j + 1] = v[j];
                j--;
            }

            v[j + 1] = key;
        }
    }

    public static void exch(int[] v, int i, int f) {
        int temp = v[i];
        v[i] = v[f];
        v[f] = temp;
    }

    public static void bubble(int[] v) {
        for (int i = v.length - 2; i >= 0; i--) {
            boolean changed = false;
            for (int j = 0; j <= i; j++) {
                if (v[j] > v[j + 1]) {
                    exch(v, j, j + 1);

                    changed = true;
                }
            }

            if (!changed) {
                return;
            }
        }
    }
}
