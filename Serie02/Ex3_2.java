package Serie02;

public class Ex3_2 {

    public static void main(String[] args) {
        // String s = "racecar";
        String s = "algoritmomtirogla";
        System.out.println(polindromo(s, 0, s.length() - 1));
    }

    public static boolean polindromo(String s, int low, int high) {
        if (low >= high)
            return true;

        return (s.charAt(low) != s.charAt(high))
                ? false
                : polindromo(s, low + 1, high - 1);
    }

}
