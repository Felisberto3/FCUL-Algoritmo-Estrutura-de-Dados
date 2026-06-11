package ForExame.EX2025_2Epoca;

import java.util.Arrays;

public class Teste {
    public static void main(String[] args) {

        int[] a = { 1, 3 };

        int[] b = new int[5];
        b = a.clone();
        System.out.println(Arrays.toString(b));
        // Ex3_SacoDeInteiros f = new Ex3_SacoDeInteiros(new int[] { 1, 3, 4, 5, 4 });

        // System.out.println("Somei todos=> " + f.someTodos());
    }
}
