package Serie02;

public class Ex8 {

    public static void main(String[] args) {
        System.out.println(fibInicial11(9, 1, 1));
        System.out.println(fibInicial01(9, 0, 1));
        System.out.println(fib(9));
    }

    public static long fibInicial11(int n, int a, int b) {
        if (n == 1)
            return a;
        if (n == 2)
            return b;

        return fibInicial11(n - 1, b, a + b);
    }

    public static long fibInicial01(int n, int a, int b) {
        if (n == 0) {
            return a;
        }

        return fibInicial01(n - 1, b, a + b);
    }

    public static long fib(int n) {
        return fibInicial11(n, 1, 1);
    }
}
