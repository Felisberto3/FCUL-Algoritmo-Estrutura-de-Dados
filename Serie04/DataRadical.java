package Serie04;

/**
 * Representa a data utilizando um único inteiro.
 */
public class DataRadical {

    private int data;

    /**
     * Pré condicao.
     * 
     * @params dia pertence ao [1..31];
     *         mes pertence {4,6,9,11} entao [1..30];
     *         se mes= 2 entao [1..29]
     * @params 1<= mes <=12,
     * @params ano >= 0.
     * 
     *         Pós condição
     *         O objecto data é usado com os dados fornecidos assumindo que são
     *         válidos.
     * 
     */
    public DataRadical(int dia, int mes, int ano) {
        if (!isValidData(dia, mes, ano)) {
            throw new IllegalArgumentException("Data não Válida!");
        }
        this.data = 512 * ano + mes * 32 + dia;
    }

    /**
     * 
     * @return dia da data específica.
     */
    public int dia() {
        return data % 32;
    }

    /**
     * 
     * @return mes da data específica.
     */
    public int mes() {
        return (data % 512) / 32;
    }

    /**
     * 
     * @return ano da data específica.
     */
    public int ano() {
        return data / 512;
    }

    /**
     * 
     * @param dia verifica se o dia e válido.
     * @param mes verifica se o mes é válido
     * @param ano verifica se o ano é válido.
     * @return true se a data é válida, false caso contrário.
     */
    private boolean isValidData(int dia, int mes, int ano) {

        switch (mes) {
            case 4, 6, 9, 11:
                return dia >= 1 && dia <= 30;
            case 2:
                return dia >= 1 && dia <= (isBisexto(ano) ? 29 : 28);
            case 1, 3, 5, 7, 8, 10, 12:
                return dia >= 1 && dia <= 31;
            default:
                return false;
        }
    }

    /**
     * 
     * @param ano
     * @return true se for bisexto e false caso contrário.
     */
    private boolean isBisexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    /**
     * @return a data de forma dd/mm/aa
     */
    public String toString() {
        return dia() + "/" + mes() + "/" + ano();
    }

    public static void main(String[] args) {
        DataRadical data = new DataRadical(29, 03, 2028);
        System.out.println(data);
    }

}
