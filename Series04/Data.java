package Series04;

/**
 * Pré Condição:
 * Dia deve ser [1..31],
 * -------se mes {4,6,9,11} pertence [1..31], se mes = 2 pertence
 * -------[1..29] no ano bisexto e [1..28] caso contrário.
 * Mes pertence [1..12]
 * Ano >= 0.
 * Método auxiliar: isValidData(dia, mes, ano)
 */
public class Data {
    /**
     * Cria uma data de acordo ao parametro informado
     */
    private int dia;
    private int mes;
    private int ano;

    /**
     * 
     * @param dia
     * @param mes
     * @param ano
     */
    public Data(int dia, int mes, int ano) {
        if (!isValidData(dia, mes, ano)) {
            throw new IllegalArgumentException("Data não Válida!");
        }
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    private boolean isValidData(int dia, int mes, int ano) {
        switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12:
                return dia >= 1 && dia <= 31;
            case 4, 6, 9, 11:
                return dia >= 1 && dia <= 30;
            case 2:
                return dia >= 1 && dia <= (isBisexto(ano) ? 29 : 28);
            default:
                return false;
        }
    }

    public boolean isBisexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    /**
     * 
     * @return o dia específico da data em questão.
     */
    public int dia() {
        return dia;
    }

    /**
     * 
     * @return mes específico da data em questão.
     */
    public int mes() {
        return mes;

    }

    /**
     * 
     * @return ano específico da data em questão.
     */
    public int ano() {
        return ano;
    }

    /**
     * Transforma a data em String
     */
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }

    public static void main(String[] args) {

        Data data = new Data(23, 12, 2003);
        System.out.println(data.toString());
    }

}
