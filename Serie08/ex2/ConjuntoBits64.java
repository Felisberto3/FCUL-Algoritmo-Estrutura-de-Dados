package Serie08.ex2;

public interface ConjuntoBits64 extends Iterable<Integer> {

    /**
     * Este conjunto cont ém um dado elemento ?
     *
     * @param pos O elemento a procurar
     * @requires 0 <= pos < 64
     * @return true se cont ém, false caso contr á rio
     */
    boolean contem(int pos);

    /**
     * Construir um novo conjunto com um elemento adicional
     *
     * @param pos O elemento a adicionar
     * @requires 0 <= pos < 64
     * @return Um novo conjunto igual a este uniao com { pos }
     */
    ConjuntoBits64 adicionar(int pos);

    /**
     * O nú mero de elementos neste conjunto
     */
    int cardinal();
}