package Serie02;

public class Ex4 {
    // 4. Escreva um método recursivo que recebe uma cadeia de caracteres
    // (uma String) e produz o seu inverso. Por exemplo, o inverso de
    // "recursiva" é "avisrucer". Sugestão: comece por escrever uma função
    // StringBuilder inversa(String s, int indice) que, dada uma String e
    // um índice na String, produz um StringBuilder com os caracteres na string a
    // partir do indice e apresentados por ordem inversa.
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
