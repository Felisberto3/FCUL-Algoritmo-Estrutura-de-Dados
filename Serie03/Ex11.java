package Serie03;

public class Ex11 {

    public static void main(String[] args) {

    }

    public static void alineaA(int n, int[] v) {
        int soma = 0; // 1
        for (int i = 0; i < n; i++) // n
            for (int j = 1; j < 4; j++) // 4 => por estar dentro do for N entao = 4*n
                soma += v[i]; // 3 => pela mesma op. da linha anterior => 3*n

        // soma = ( 1 + n + 4n + 3n ) => mas a O(n)
    }

    public static void alineaB(int n) {
        int m = 0; // 1
        for (int i = 1; i < 10 * n; i++) // 10*n
            for (int j = 1; j < n; j++) // n => por estar aninhado = 10*n*n
                m++; // 2*n => por estar aninhado = 2*n*10*n

        // soma = (1 + 10n + 10n^2 + 20n^2) = > o O(n^2)
    }

    public static void alineaC(int n) {
        int b = n * n; // 1
        while (b > n) // acontece 1 + (n^2 - n + 1) / 2
            if (b % 2 == 0) // 2*(condicao do while)
                b--; // // 2*(condicao do while)
            else
                b -= 2; // // 2*(condicao do while)
        // why 1 + (n^2 - n + 1) / 2 =>
        // vamos resolver esse problema com PA, sabendo que PA = a1 + (k - 1)r
        // sabemos que os números reduz-se 1 na primeira e única vez,
        // depois diminui a 2, então:
        // n^2, n^2 -1, n^2 - 3, n^2 - 5,..n
        // considerei o a1 = n^2 -1, r = -2. Isso quer dizer que vou somar 1 na ultima
        // operacao porque descartei o n^2 como primeiro termo.
        // PA = n^2 -1 + (k -1 )(-2) => PA = n^2 - 2k + 1
        // sabendo que a PA termina no numero n entao:
        // n^2 - 2k + 1 > n => n^2 + 1 -n > 2k => (n^2 -n + 1) /2 > k

        // entao a quantidade de vezes que n^2 e diminuido para chegar em K é (n^2 -n +
        // 1) /2
        // vendo o historial do exercicio, este trecho é o maior, então a complexidade é
        // de:
        // O(n^2)
    }

    public static void alineaD(int n) {
        int x = n * n * n; // 1
        while (x > 1) // 3logn + 1
            x /= 2; // 2 => 2*(3logn + 1)
        // achei 3logx + 1 com PG.
        // sabendo que a operacao e de x, x/2, x/4,x/8.. ate 1.
        // PG = a1*q^(k -1), sabendo que q = 1/2. então:
        // PG = n^3.(1/2)^(k-1) => n^3.(1/2)^(k-1) > 1, calculando :
        // ((n^3) / 2^(k -1) ) > 1 => n^3 > 2^(k-1) => k < 3(logn / log2) + 1

        // somando =(1 + 3logn + 1 + 6logn + 2) => O(logn)

    }
}
