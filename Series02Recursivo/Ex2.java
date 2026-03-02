public class Ex2 {
    // 2. Escreva um algoritmo recursivo para converter uma sequência de algarismos
    // no número inteiro que representa. Como parâmetro utilize um vetor (array)
    // de caracteres. Por exemplo, o vetor {'1', '3', '5', '3', '1'} representa o
    // número inteiro 13531. Assuma que a sequência é não vazia e que contém apenas
    // algarismos. Implemente o seu algoritmo em Java

    public static void main(String[] args) {
        // System.out.println(Math.pow(10, 2));
        char[] v = { '1', '3' };
        double numero = numeroInt(v, v.length - 1);
        System.out.println(numero);

    }

    static double numeroInt(char[] v, int i) {
        if (i <= 0) {
            return v[v.length - 1] - '0';
        } else {
            return ((v[v.length - 1 - i]) - '0') * Math.pow(10, i) + numeroInt(v, i - 1);
        }
    }
}
