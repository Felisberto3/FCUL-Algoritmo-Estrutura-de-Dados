public class Ex6 {
    // 6. Suponha dado um vetor contendo n números inteiros distintos listados por
    // ordem crescente. Dado um número k, descreva um algoritmo recursivo para
    // determinar se o vetor contem dois inteiros que somam k. Implemente o seu
    // algoritmo em Java.

    /**
     * 
     * @param l must initialized by 0
     * @param r must initialized by v.length -1
     * @return boolean if there is a both number that sum k
     */

    public static void main(String[] args) {
        int[] v = { 2, 4, 5, 6, 7, 7, 8, 8, 7, 7, 8, 9 };
        System.out.println(somamK(v, 10, 0, v.length - 1));
    }

    public static boolean somamK(int[] v, int k, int l, int r) {

        if (l >= r) {
            return false;
        }

        if (v[l] + v[r] < k) {
            return somamK(v, k, l + 1, r);
        } else if (v[l] + v[r] > k) {
            return somamK(v, k, l, r - 1);
        } else {
            return true;
        }
    }
}
