package Serie03;

public class Ex12 {
    public static void main(String[] args) {
        int[] v = { 2, 3, 4, 7, 11, 20 };
        int[] m = ex(v);
        int[] melhorado = exMelhorado(v);

        for (int i : m) {
            System.out.print(i + " ");
        }

        System.out.println();
        for (int i : melhorado) {
            System.out.print(i + " ");
        }
    }

    public static int[] ex(int[] v) {
        int n = v.length;
        int[] m = new int[n];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum = sum + v[j];
            }
            m[i] = sum / (i + 1);
        }
        return m;
    }

    public static int[] exMelhorado(int[] v) {
        int n = v.length;
        int m[] = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + v[i];
            m[i] = sum / (i + 1);
        }

        return m;
    }
}
