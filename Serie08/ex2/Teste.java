package Serie08.ex2;

public class Teste {
    public static void main(String[] args) {
        ConjuntoBits64 bits = new ConjuntoBits();

        System.out.println("Booleano " + bits.contem(-2));
        System.out.println("Quantidade " + bits.cardinal());
        System.out.println(bits);

        ConjuntoBits64 novoBits = bits.adicionar(2).adicionar(4);

        System.out.println("Booleano " + novoBits.contem(2));
        System.out.println("Quantidade " + novoBits.cardinal());

        System.out.println(novoBits);
    }
}
