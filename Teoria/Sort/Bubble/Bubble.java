package Teoria.Sort.Bubble;

public class Bubble<T extends Comparable<T>> implements Comparable<Bubble<T>> {
    private T idade;

    public static void main(String[] args) {
        int[] a = { 23, 700, 1, -3, 0, 5, 76, 3 };
        sort(a);

        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    // Estava treinando como usar o Comparable
    @Override
    public int compareTo(Bubble<T> arg0) {
        return idade.compareTo(arg0.idade);
    }

    public static void sort(int[] a) {
        for (int i = a.length - 2; i >= 0; i--) {
            boolean isExch = false;
            for (int j = 0; j <= i; j++)
                if (a[j] > a[j + 1]) {
                    exch(a, j, j + 1);
                    isExch = true;
                }

            if (!isExch)
                break;
        }
    }

    public static void exch(int[] a, int i, int j) {
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }
}
