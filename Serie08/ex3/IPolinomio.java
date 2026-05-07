package Serie08.ex3;

public interface IPolinomio {
    /**
     * O grau deste polinómio , ou seja , o maior expoente
     * com um coeficiente diferente de zero . Retorna 0
     * se este for o polin ó mio zero .
     */

    int grau();

    /**
     * O coeficiente do termo cujo expoente é d
     ** 
     * @param d Expoente
     */
    double coeficiente(int n);

    /**
     * A diferença deste polinómio para q
     *
     * @param q O polinómio termo
     * @return this + q
     * @requires q != null
     */
    IPolinomio menos(IPolinomio q);

    /**
     * A soma deste polinómio com q
     *
     * @param q O polin ó mio termo
     * @return this + q
     * @requires q != null
     */
    IPolinomio mais(IPolinomio outro);

    /**
     * A produto deste polinómio com q
     *
     * @param q O polinómio fator
     * @return this * q
     * @requires q != null
     */
    IPolinomio vezes(IPolinomio q);

    /**
     * O simétrico deste polinómio
     *
     * @return -this
     */
    IPolinomio menos();

    /**
     * Este polinómio é de grau 0?
     */
    boolean constante();

    /**
     * Este polinómio é de grau zero e o seu
     * único coeficiente é 0?
     */
    boolean zero();

    /**
     * O valor do polinomio num dado ponto x
     * 
     * @param x O ponto no qual calculamos o polinomio
     * @return O valor do polinomio em x
     */
    int valor(int x);
}
