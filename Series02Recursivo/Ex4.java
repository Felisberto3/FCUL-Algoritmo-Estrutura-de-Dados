public class Ex4 {
    public static void main(String[] args) {
        System.out.println(inversa("recursiva", 12));
    }

    public static StringBuilder inversa(String s, int indice) {
        if (indice >= s.length()) {
            return new StringBuilder();
        }
        return inversa(s, indice + 1).append(s.charAt(indice));
    }
}
