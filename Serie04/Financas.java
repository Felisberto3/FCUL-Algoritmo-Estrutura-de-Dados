package Serie04;

public class Financas {

    /**
     * Mostra a lista de clientes que não são devedores
     * 
     * @param devedores é a lista dos devedores
     * @param clientes  é a lista dos clientes = (devedores como não devedores)
     */
    public void listaLivre(int[] devedores, int[] clientes) {
        ConjuntoDeInteiros zDevedores = new ConjuntoDeInteiros(devedores);

        for (int cliente : clientes) {
            if (!zDevedores.contem(cliente)) {
                System.out.println("Cliente: " + cliente);
            }
        }
    }

    public static void main(String[] args) {
        int[] devedores = { 142537498, 176483908, 210023492, 198361023 };
        int[] clientes = { 219826341, 210023492, 187232409, 198361023, 198436129 };

        Financas financas = new Financas();
        financas.listaLivre(devedores, clientes);

    }
}
