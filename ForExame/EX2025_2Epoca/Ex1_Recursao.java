package ForExame.EX2025_2Epoca;

public class Ex1_Recursao {
    public static void main(String[] args) {
        int[] v = { 1, 1, 1, 1 };
        System.out.println("Numeros Repetivos => " + repeticao(v));
    }

    public static int repeticao(int[] v) {
        return repeticao(v, 1, v.length - 1, 0);
    }

    public static int repeticao(int[] v, int l, int r, int count) {
        if (l > r) {
            return count;
        }
        if (l == r) {
            if (v[0] == v[l])
                count++;
            return count;
        }

        if (v[0] == v[l])
            count++;
        if (v[0] == v[r])
            count++;

        return repeticao(v, l + 1, r - 1, count);

    }

}
