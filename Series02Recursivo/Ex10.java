public class Ex10 {
    // 10. Um vetor não vazio é bitonic se é constituído por uma sequência crescente
    // de
    // inteiros seguida de uma sequência decrescente. Considere o problema de
    // encontrar o maior elemento de um destes vetores. Assuma que o vetor é não
    // vazio.
    // Utilize a técnica da busca binária. Estime o número de chamadas recursivas
    // numa chamada com um vetor de comprimento n.

    /**
     * verifica se o vector v é botonic
     * 
     * @param vector v, left é o índice do primeiro elemento e right é o índice do
     *               último elemento
     * @requires v não pode ser null, v não pode ter elementos repetidos
     * @return return true se for botonic caso contrario false
     */
    public static void main(String[] args) {
        int[] v = { 1, 2, 4, 5, 0 };
        System.out.println(botonic(v, 0, v.length - 1));
    }

    public static boolean botonic(int[] v, int left, int right) {
        int middle = left + (right - left) / 2;
        if (left >= right) {
            return false;
        }
        if (v[middle - 1] < v[middle] && v[middle] < v[middle + 1]) {
            return botonic(v, middle + 1, right);
        } else if (v[middle] < v[middle - 1] && v[middle] > v[middle + 1]) {
            return botonic(v, left, middle - 1);
        }

        return true;
    }
}
