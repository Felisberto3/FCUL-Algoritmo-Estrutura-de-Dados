package ForExame.Ex2023_2Epoca;

public class EX01_Recursivo {

    public static void main(String[] args) {
        String s = "";
        System.out.println("isPolindromo: " + isPolindromo("ovo"));
    }

    public static boolean isPolindromo(String s) {
        return s == null ? false : polindromo(s, 0, s.length() - 1);
    }

    private static boolean polindromo(String s, int i, int j) {
        if (i >= j) {
            return true;
        }

        return s.charAt(i) == s.charAt(j) ? polindromo(s, i + 1, j - 1) : false;
    }
}
