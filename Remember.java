public class Remember {
    public static void main(String[] args) {
        int[] v = { 1, 4, 5, 7, 8, 9 };
        System.out.println("Fib: " + fib(7, 0, 1));
        // System.out.println("Iqual : " + iqual(v, 5, 0, v.length - 1));
    }

    public static long fib(int n, int a, int b) {
        if (n == 1) {
            return a;
        }

        return fib(n - 1, b, b + a);
    }

    public static boolean iqual(int[] v, int k, int i, int j) {
        if (i >= j) {
            return false;
        }
        if (v[i] + v[j] < k) {
            return iqual(v, k, i + 1, j);
        } else if (v[i] + v[j] > k) {
            return iqual(v, k, i, j - 1);
        } else {
            return true;
        }
    }
}
