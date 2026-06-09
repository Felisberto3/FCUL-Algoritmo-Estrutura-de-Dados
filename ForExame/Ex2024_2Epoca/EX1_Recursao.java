package ForExame.Ex2024_2Epoca;

import java.util.Arrays;

public class EX1_Recursao {
    public static void main(String[] args) {
        int[] v = { 4, 6, -2, 0, 1 };

        int[] w = quadrado(v);
        System.out.println(Arrays.toString(w));
    }

    public static int[] quadrado(int[] antigo) {
        int[] novo = new int[antigo.length];

        quadrado(novo, antigo, 0, novo.length - 1);
        return novo;
    }

    public static void quadrado(int[] novo, int[] antigo, int i, int j) {

        if (i > j)
            return;

        if (i == j) {
            novo[i] = antigo[i] * antigo[i];
            return;
        }

        novo[i] = antigo[i] * antigo[i];
        novo[j] = antigo[j] * antigo[j];

        quadrado(novo, antigo, i + 1, j - 1);

    }
}
