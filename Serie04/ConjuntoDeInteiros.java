package Serie04;

import java.util.Arrays;

public class ConjuntoDeInteiros {
    /**
     * cria um conjunto de numeros inteiros
     */
    private int[] conjunto;

    /**
     * copia um array de inteiros na propriedade conjunto e organiza em ordem
     * crescente
     * 
     * @param a conjunto de numeros inteiros
     */
    public ConjuntoDeInteiros(int[] a) {
        conjunto = Arrays.copyOf(a, a.length);
        Arrays.sort(conjunto);
    }

    /**
     * Verifica se um elemento faz parte do conjunto
     * 
     * @param elemento a ser pesquisado no conjunto
     * @return True se o elemento estiver no conjunto e false caso contrario
     */
    public boolean contem(int elemento) {
        return Arrays.binarySearch(conjunto, elemento) >= 0;
    }

    public static void main(String[] args) {
        int[] a = { 1, 6, 4, 0, -3, 6, -3 };
        ConjuntoDeInteiros z = new ConjuntoDeInteiros(a);

        System.out.println(z.contem(10));

    }

}