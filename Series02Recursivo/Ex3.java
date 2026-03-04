public class Ex3 {
    // 3. Escreva um método Java recursivo que determine se uma cadeia de caracteres
    // é um palíndromo, ou seja, é igual à sua inversa. Exemplos de palíndromos
    // incluem "racecar" e "algoritmomtirogla". Sugestão: comece por escrever
    // um método
    // boolean palindromo (String s, int baixo , int alto)
    // que determina se a subtring

    public static void main(String[] args) {
        System.out.println(polindromo("racecar"));
        System.out.println(polindromo("algoritmomtirogla"));
        System.out.println(polindromo(""));
    }

    public static boolean polindromo(String s) {
        return polindromo(s, 0, s.length() - 1);
    }

    public static boolean polindromo(String s, int low, int high) {
        if (low >= high) {
            return true;
        }

        if (s.charAt(low) != s.charAt(high)) {
            return false;
        }
        return polindromo(s, low + 1, high - 1);

    }
}