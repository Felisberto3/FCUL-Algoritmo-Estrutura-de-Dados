package Series04;

import java.util.Arrays;

public class ConjuntoDeInteiros {
    private int[] conjunto;

    public ConjuntoDeInteiros(int[] a) {
        conjunto = Arrays.copyOf(a, a.length);
        Arrays.sort(conjunto);
    }

    public boolean contem(int elemento) {
        return Arrays.binarySearch(conjunto, elemento) >= 0;
    }

    public static void main(String[] args) {
        int[] a = { 1, 6, 4, 0, -3, 6, -3 };
        ConjuntoDeInteiros z = new ConjuntoDeInteiros(a);

        System.out.println(z.contem(10));

    }

}