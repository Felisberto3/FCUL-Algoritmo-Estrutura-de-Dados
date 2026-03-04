public class Ex7 {
    // 7. Dada uma sequência de inteiros a e um inteiro k, descreva um algoritmo
    // recursivo para reorganizar os elementos em a de modo a que todos os elementos
    // inferiores ou iguais a k venham antes de quaisquer elementos maiores ou
    // iguais
    // a k. Implemente o seu algoritmo em Java.

    /**
     * 
     * @param args i = 0, j = a.length
     * 
     */

    public static void main(String[] args) {
        int[] a = { 5, 3, 5, 7, 5, 2 };
        int k = 4;
        sort(a, k, 0, a.length - 1);

        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] a, int k, int i, int j) {
        if (i >= j) {
            return;
        }

        if (a[i] <= k) {
            sort(a, k, i + 1, j);
        } else if (a[j] >= k) {
            sort(a, k, i, j - 1);
        } else {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            sort(a, k, i + 1, j - 1);
        }
    }
}
