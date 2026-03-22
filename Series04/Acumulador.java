package Series04;

public class Acumulador {
    /**
     * Acumulador de números double e mostra a sua média também
     */
    private double acumulador;
    private double index;

    /**
     * Adiciona um elemento no acumulador
     * 
     * @param valor a ser acrescentado no Acumulador
     */
    public void adicionar(double valor) {
        acumulador += valor;
        index++;
    }

    /**
     * Calcula a média dos valores acumulados.
     * 
     * @return A média de numeros acrescentado até então.
     */
    public double media() {
        return acumulador / index;
    }

    /**
     * @return O acumulador em String
     */
    public String toString() {
        return "Acumulador: " + acumulador + "\nMédia: " + media();
    }

    public static void main(String[] args) {
        Acumulador a = new Acumulador();
        a.adicionar(4.0);
        a.adicionar(3.0);
        a.adicionar(2.0);

        System.out.println(a.toString());
        System.out.println(a.media());
    }
}
