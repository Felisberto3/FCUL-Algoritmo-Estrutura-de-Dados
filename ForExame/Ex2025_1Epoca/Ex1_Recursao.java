package ForExame.Ex2025_1Epoca;

import java.util.Arrays;

public class Ex1_Recursao {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(genVector(7)));
    }

    public static int[] genVector(int n) {
        int[] newVector = new int[n];
        gen(newVector, 0);
        return newVector;
    }

    public static void gen(int[] v, int i) {
        if (i > v.length - 1)
            return;

        if (i == 0) {
            v[i] = i;
            gen(v, i + 1);
            return;
        }

        v[i] = v[i - 1] + i;
        gen(v, i + 1);
    }
}
