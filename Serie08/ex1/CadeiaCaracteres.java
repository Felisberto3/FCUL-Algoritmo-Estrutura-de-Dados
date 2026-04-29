package Serie08.ex1;

public interface CadeiaCaracteres extends Iterable<Character> {
    /**
     * O número de elementos nesta cadeia
     */
    int comprimento();

    /**
     * Concatena a cadeia de caracteres outra no
     * final desta cadeia de caracteres
     *
     * @param outra A cadeia a concatenar
     * @return O resultado da concatena ção
     */
    CadeiaCaracteres concat(CadeiaCaracteres outra);

    /**
     * Devolve uma cadeia de caracteres que é uma
     * subcadeia desta cadeia de caracteres
     *
     * @param primeiro O í ndice inicial , inclusiv é
     * @param ultimo   O í ndice final , exclusiv é
     * @requires 0 <= primeiro <= ultimo <= comprimento ()
     * @return A subcadeia compreendida entre os
     *         dois í ndices
     */
    CadeiaCaracteres subcadeia(int primeiro, int ultimo);
}
