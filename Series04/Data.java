package Series04;

public class Data {
    /**
     * Cria uma data de acordo ao parametro informado
     */
    private int dia;
    private int mes;
    private int ano;

    /**
     * Cria a data no momento da inicialização.
     * 
     * @param dia da data em questão.
     * @param mes da data em questão.
     * @param ano da data em questão.
     * @requires Dia deve ser maior que 0 e inferior a 32.
     * @requires Mes deve ser maior que 0 e inferior a 13.
     * @requires Ano deve ser maior que 0.
     */
    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
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
