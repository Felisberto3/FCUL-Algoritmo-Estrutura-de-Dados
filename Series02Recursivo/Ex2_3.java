public class Ex2_3 {
    /**
     * 
     * @param i must be initialized by 0
     */
    public static void main(String[] args) {
        char[] s = { '2', '3', '3', '3' };
        System.out.println(converterInteiro(s, 0));
    }

    public static double converterInteiro(char[] v, int i) {
        if (i >= v.length) {
            return 0;
        }
        return (v[i] - '0') * Math.pow(10, v.length - 1 - i) + converterInteiro(v, i + 1);
    }
}