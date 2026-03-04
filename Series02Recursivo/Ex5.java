public class Ex5 {
    // 5. Escreva um método recursivo que rearranja uma sequência (um vetor) de
    // valores inteiros de modo a que todos os valores pares apareçam antes de todos
    // os valores ímpares.
    public static void main(String[] args) {
        int[] v = { 1, 3, 5, 7, 8, 5, 3, 2, 2, 7 };
        rearanja(v, 0, v.length - 1);

        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }
    }

    public static void rearanja(int[] v, int i, int j) {
        if (i >= j) {
            return;
        }

        if (v[i] % 2 == 0) {
            rearanja(v, i + 1, j);
        } else if (v[j] % 2 == 1) {
            rearanja(v, i, j - 1);
        } else {
            int temp = v[i];
            v[i] = v[j];
            v[j] = temp;

            rearanja(v, i + 1, j - 1);
        }
    }
}
