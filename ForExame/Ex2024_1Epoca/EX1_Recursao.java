package ForExame.Ex2024_1Epoca;

import java.util.Arrays;

public class EX1_Recursao {
    public static void main(String[] args) {
        Character[] v = { 'a', 'e', 'd' };

        System.out.println(Arrays.toString(inverterPalavra(v)));
    }

    public static Object[] inverterPalavra(Object[] v) {
        return inverter(v, 0, v.length - 1);
    }

    private static Object[] inverter(Object[] v, int i, int j) {
        if (i >= j) {
            return v;
        }

        Object aux = v[i];
        v[i] = v[j];
        v[j] = aux;

        return inverter(v, i + 1, j - 1);
    }
}
