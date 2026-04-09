package Serie02;

public class Ex2_2 {

    /**
     * 
     * @param i must be initialized by 0
     */

    public static void main(String[] args) {
        char[] v = { '1', '3', '5', '3', '1' };
        System.out.println((int) converter(v, 0));

    }

    public static double converter(char[] v, int i) {
        if (i >= v.length - 1) {
            return v[i] - '0';
        }

        return (v[i] - '0') * Math.pow(10, v.length - 1 - i) + converter(v, i + 1);
    }
}