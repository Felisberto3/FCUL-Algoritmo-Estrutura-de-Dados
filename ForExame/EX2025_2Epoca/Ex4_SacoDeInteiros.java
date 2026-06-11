package ForExame.EX2025_2Epoca;

import java.util.Arrays;

public class Ex4_SacoDeInteiros {
    /**
     * Os elementos do saco
     */
    private final int[] a;

    /**
     * Criar um saco a partir de um vetor
     * 
     * @param elementos O vetor
     */
    public Ex4_SacoDeInteiros(int[] elementos) {
        a = Arrays.copyOf(elementos, elementos.length);
        Arrays.sort(a);
    }

    public Ex4_SacoDeInteiros add(int e) {
        int[] novo = new int[a.length + 1];

        int i = 0;
        for (; i < a.length; i++) {
            novo[i] = a[i];
        }
        novo[i] = e;

        return new Ex4_SacoDeInteiros(novo);

    }
}
