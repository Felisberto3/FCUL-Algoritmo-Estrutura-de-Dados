package ForExame.Ex2023_1Epoca;

import java.util.Iterator;

public class Ex7 {
    public static void main(String[] args) {
        int[] r = unicos(new int[] { 1, 4, 5, 6, 7, 7 });

        for (int i : r) {
            System.out.print(i + " ");
        }
    }

    public static int[] unicos(int[] a) {
        BST<Integer, Boolean> bst = new BST<>();

        for (int i : a)
            bst.put(i, true); // O(n)

        int[] result = new int[bst.size()]; // O(1)

        Iterator<Integer> it = bst.keys(); // O(n)

        int i = 0; // linha 24 a 28 => O(n)
        while (it.hasNext()) {
            result[i++] = it.next();
        }

        return result;

        // total => O(n)

    }
}
