package ForExame.Ex2023_1Epoca;

public class EX03_estaOrdenado {
    public static void main(String[] args) {
        int[] v = { 1, 3, 3, 4, 6, 6 };
        System.out.println("Esta ordenado: " + estaOrdenadoPro(v, 0));
    }

    public static boolean estaOrdenado(int[] v, int i) {
        if (i >= v.length - 1) {
            return true;
        }

        return v[i] <= v[i + 1] && estaOrdenado(v, i + 1);
    }

    public static boolean estaOrdenadoPro(int[] v, int i) {
        return (i >= v.length - 1) ? true : v[i] <= v[i + 1] && estaOrdenadoPro(v, i + 1);
    }
}
