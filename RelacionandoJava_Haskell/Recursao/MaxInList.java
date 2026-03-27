package RelacionandoJava_Haskell.Recursao;

/**
 * Calcula o max numero de uma lista
 */
public class MaxInList {

    public static void main(String[] args) {
        int[] list = { 1, 1, -2 };
        System.out.println(maximum(list, 0));

        // replicar item.
        System.out.println(replicate(4, 2));

        // esta na lista
        System.out.println(isInList(2, list, 0));
    }

    /**
     * 
     * @param list é a lista a ser percorrida
     * @param r    é o inicio da comparação a ser feita
     * @return retorna o maior elemento desde r.
     */

    public static int maximum(int[] list, int r) {
        if (r >= list.length - 1) {
            return list[r];
        }

        return list[r] >= maximum(list, r + 1) ? list[r] : maximum(list, r + 1);
    }

    /**
     * 
     * @param quant quantidade de vezes que o item sera repetido
     * @param item  o elemento a ser repetido
     * @return retorna items repetidos quant vezes.
     */
    public static StringBuilder replicate(int quant, int item) {
        if (quant == 0) {
            return new StringBuilder();
        }
        if (quant <= 1) {
            StringBuilder sb = new StringBuilder();
            return sb.append(item);
        }

        return replicate(quant - 1, item).append(",").append(item);

    }

    public static boolean isInList(int a, int[] v, int i) {
        if (i >= v.length)
            return false;

        return (v[i] == a) ? true : isInList(a, v, i + 1);
    }
}
