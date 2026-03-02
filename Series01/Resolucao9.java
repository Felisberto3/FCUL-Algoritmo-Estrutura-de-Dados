package Series01;

// 9. Considere o problema de descobrir, numa dada sequência, o número de elementos iguais a um dado número que chamamos chave.
// (a) Escreva um método rank(chave, a) que recebe uma chave uma sequência ordenada de números inteiros como argumentos e devolve o número de
// elementos que são menores do que a chave.

// (b) De modo semelhante escreva um método count(chave, a) que devolva o
// número de elementos iguais à chave.
// (c) É fácil de ver que se i e j são os valores devolvidos por rank(chave, a) e
// por count(chave, a) respetivamente, então a[i..i+j-1] são os valores
// na sequência que são iguais à chave. Aproveite este facto para escrever um
// método main que verifique esta propriedade para diferentes sequências
public class Resolucao9 {
    public static void main(String[] args) {
        int[] a = { 1, 2, 4 };
        int resp = rank(3, a);

        System.out.println(resp);

    }

    public static int rank(int key, int[] a) {
        int left = 0, right = a.length - 1, middle = 0;

        while (left <= right) {
            middle = left + (right - left) / 2;
            if (a[middle] < key)
                left = middle + 1;
            else
                right = middle - 1; // 1,4,5,6,76
        }

        return left;
    }

    public static int count(int key, int[] a) {
        return rank(key + 1, a) - rank(key, a);
    }

}
