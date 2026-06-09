package Teoria.Sort.QuickSort;

import java.util.Arrays;

import Teoria.Sort.InsertionSort.InsertionOptimizacao;
import Teoria.Sort.InsertionSort.InsertionParams;

public class QuickSort {

    /**
     * 
     * 
     * @param Complexidade            de Tempo (Comparações e Trocas):
     *                                ................Melhor Caso: O(n log n) ->
     *                                Divisões
     *                                perfeitamente equilibradas.
     *                                ................Médio Caso: O(n log n) ->
     *                                Cenário
     *                                esperado para inputs aleatórios.
     *                                ................Pior Caso: O(n^2) ->
     *                                Sub-problemas
     *                                totalmente desequilibrados (vetor ordenado ou
     *                                invertido).
     * @param Estabilidade:           Não Estável (As trocas efetuadas no
     *                                particionamento
     *                                violam a ordem relativa de elementos iguais).
     * @param Propriedade_Adaptativa: Não (O algoritmo base não altera o seu
     *                                comportamento em função da ordenação prévia do
     *                                input).
     * @param Espaço_em_Memória:      In-Place (Consumo de memória extra O(1),
     *                                requer
     *                                apenas espaço O(log n) na Stack para a
     *                                recursão).
     */
    public static void main(String[] args) {
        Integer[] a = { 23, 700, 1, -3, 0, 5, 76, 3 };
        Integer[] v = { 5, 5, 5, 5, 3, 3, 3, 3, 1, 1, 1, 1 };

        sort(v);
        sort(a);
        System.out.print("Array Organizado: ");
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(v));
    }

    public static void sort(Comparable[] v) {
        quick(v, 0, v.length - 1);
    }

    public static void quick(Comparable[] v, int lo, int hi) {
        if (lo < hi) {
            if (hi - lo <= 15) {
                InsertionParams.sort(v, lo, hi);
                return;
            }
            int j = partition(v, lo, hi);

            quick(v, lo, j - 1);
            quick(v, j + 1, hi);
        }
    }

    public static int partition(Comparable[] v, int lo, int hi) {
        Comparable pivot = v[lo];
        int i = lo, j = hi + 1;

        while (true) {
            while (less(v[++i], pivot))
                if (i == hi)
                    break;
            while (less(pivot, v[--j]))
                if (lo == j)
                    break;

            if (i >= j) {
                break;
            }

            exch(v, i, j);
        }

        exch(v, lo, j);
        return j;

    }

    public static void exch(Comparable[] v, int i, int j) {
        Comparable aux = v[j];
        v[j] = v[i];
        v[i] = aux;

    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}
