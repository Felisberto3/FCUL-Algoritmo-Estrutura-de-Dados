package Teoria.Sort.HeapSort;

public class HeapClass {
    /**
     * COMPLEXIDADE DE TEMPO (Comparações e Trocas):
     * ................Melhor Caso: O(n log n) -> Mesmo que esteja quase ordenado, a
     * estrutura de árvore exige travessias.
     * ................Médio Caso: O(n log n) -> Cenário perfeitamente consistente
     * para qualquer distribuição.
     * ................Pior Caso: O(n log n) -> Blindado contra degradação de
     * performance (máximo 2n log n comparações).
     * * ESTABILIDADE:
     * ................Não Estável -> As trocas distantes na Heap e a remoção da
     * raiz quebram a ordem relativa de elementos iguais.
     * * PROPRIEDADE ADAPTATIVA:
     * ................Não -> O algoritmo não altera o seu comportamento ou fluxo em
     * função da ordenação prévia do input.
     * * ESPAÇO EM MEMÓRIA:
     * ................In-Place -> Consumo de memória extra O(1). Não usa vetores
     * auxiliares e não é recursivo (não gasta Stack).
     */
    public static void main(String[] args) {
        int[] a = { 0, 1, 60, 50, 8, 20, 100 };
        sort(a);

        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] a) {
        int n = a.length - 1;

        // Fazendo o heapify
        for (int k = n / 2; k >= 1; k--) {
            sink(a, k, n);
        }

        while (n > 1) {
            exch(a, 1, n--);
            sink(a, 1, n);
        }
    }

    public static void sink(int[] a, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(a, j, j + 1))
                j++;
            if (!less(a, k, j))
                break;
            exch(a, k, j);
            k = j;

        }
    }

    public static void exch(int[] a, int k, int j) {
        int aux = a[k];
        a[k] = a[j];
        a[j] = aux;
    }

    public static boolean less(int[] a, int i, int j) {
        return a[i] < a[j];
    }
}
