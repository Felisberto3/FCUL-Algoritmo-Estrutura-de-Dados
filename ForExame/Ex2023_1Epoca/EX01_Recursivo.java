package ForExame.Ex2023_1Epoca;

public class EX01_Recursivo {
    public static void main(String[] args) {
        char[] v = { '1', '3', '5', '3', '1' };

        System.out.println(inteiro(v, 0));
    }

    public static int inteiro(char[] v, int i) {
        if (i >= v.length) {
            return 0;
        }

        return (v[i] - '0') * (int) Math.pow(10, v.length - 1 - i) + inteiro(v, i + 1);
    }
}
