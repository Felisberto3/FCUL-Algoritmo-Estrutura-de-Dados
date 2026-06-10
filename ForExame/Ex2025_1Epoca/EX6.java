package ForExame.Ex2025_1Epoca;

import java.util.Arrays;
import java.util.Iterator;

import ForExame.Ex2023_1Epoca.BST;

public class EX6 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(unicos(new Integer[] { 2, 6, -3, 4, 5, 2, 6 })));
    }

    /**
     * 
     * @param <Key> tipo que compoe o array que sera moldado
     * @param a     o array em questao
     * @return novo array sem elementos repetidos
     */
    public static <Key extends Comparable<Key>> Key[] unicos(Key[] a) {
        if (a == null || a.length == 0)
            return a;

        BST<Key, Boolean> b = new BST<>();
        for (Key key : a)
            b.put(key, true);

        Key[] v = (Key[]) new Comparable[b.size()];

        Iterator<Key> it = b.keys();

        for (int i = 0; it.hasNext(); i++)
            v[i] = it.next();
        return v;
    }
}
