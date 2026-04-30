package Serie08.ex1;

public class Teste {
    public static void main(String[] args) {
        char[] listChar = { 'a', 'b', 'c' };

        CadeiaCaracteres ca2 = new CadeiaCaracteresVector(listChar);
        CadeiaCaracteres ca = new CadeiaCaracteresVector('b');

        CadeiaCaracteres c3 = ca2.concat(ca);

        System.out.println(c3);
        System.out.println(c3.subcadeia(2, 3));

    }
}
