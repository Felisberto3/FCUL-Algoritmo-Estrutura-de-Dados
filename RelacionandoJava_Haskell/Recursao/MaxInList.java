package RelacionandoJava_Haskell.Recursao;

/**
 * Calcula o max numero de uma lista
 */
public class MaxInList {

    public static void main(String[] args) {
        int[] list = { 1, 1, -2 };
        System.out.println(maximum(list, 0));
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
}
