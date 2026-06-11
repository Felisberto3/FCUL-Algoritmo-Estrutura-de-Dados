package ForExame.EX2025_2Epoca;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Ex3_SacoDeInteiros implements Iterable<Integer> {
    /**
     * Os elementos do saco
     */
    private final int[] a;

    /**
     * Criar um saco a partir de um vetor
     * 
     * @param elementos O vetor
     */
    public Ex3_SacoDeInteiros(int[] elementos) {
        a = Arrays.copyOf(elementos, elementos.length);
        Arrays.sort(a);
    }

    public int someTodos() {
        int count = 0;
        for (int i : this) {
            count += i;
        }
        return count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < a.length;
            }

            @Override
            public Integer next() {
                if (!hasNext())
                    throw new NoSuchElementException("Lista Vazia");
                return a[i++];
            }
        };

    }

}
