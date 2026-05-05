package Serie08.ex3;

public class Teste {
    public static void main(String[] args) {
        double[] list = { 5, 6, 9, 0, 0 };

        Polinomio poly = new Polinomio(list);

        System.out.println(poly);

        System.out.println(poly.valor(2));

        System.out.println(poly.menos());

        System.err.println(poly.menos(poly));

        double[] a = { 2, 1 };
        double[] b = { 0, 3, 1 };

        Polinomio c = (Polinomio) new Polinomio(a).vezes(new Polinomio(b));

        System.out.println(c);

    }
}
