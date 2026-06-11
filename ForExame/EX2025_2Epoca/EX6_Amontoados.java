package ForExame.EX2025_2Epoca;

public class EX6_Amontoados {
    public static <E extends Comparable<E>> boolean eAmontoadoMax(E[] a) {
        if (a == null || a.length <= 1)
            return true;

        int n = a.length - 1;

        for (int k = a.length / 2; k > 0; k--) {
            int filhoEsquerdo = 2 * k;
            int filhoDireito = 2 * k + 1;

            if (filhoEsquerdo <= n && Sorter.less(a[k], a[filhoEsquerdo])) {
                return false;
            }
            if (filhoDireito <= n && Sorter.less(a[k], a[filhoDireito])) {
                return false;
            }

        }

        return true;
    }
}
