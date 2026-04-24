package Serie07.ex4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class ConjuntoDeInteiros implements Iterable<Integer> {
    private int[] a;

    public ConjuntoDeInteiros(int[] chaves) {
        a = chaves.clone();
        Arrays.sort(a);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < a.length - 1;
            }

            @Override
            public Integer next() {
                if (!hasNext())
                    throw new NoSuchElementException("Fim do conjunto atingido");

                return a[i++];
            }
        };
    }

    public static void main(String[] args) {
        int[] b = { 5, 3, 6, 7 };
        ConjuntoDeInteiros a = new ConjuntoDeInteiros(b);
        System.out.print("[");
        for (int item : a) {
            System.out.print(item + ",");
        }

        System.out.print("]");
    }
}
