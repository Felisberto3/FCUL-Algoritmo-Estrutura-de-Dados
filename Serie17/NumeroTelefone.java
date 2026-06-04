package Serie17;

public class NumeroTelefone {
    private String codigoPais;
    private String codigoCidade;
    private Integer telefone;

    public NumeroTelefone(String codigoPais, String codigoCidade, Integer telefone) {
        this.telefone = telefone;
        this.codigoCidade = codigoCidade;
        this.codigoPais = codigoPais;
    }

    public int hashCode() {
        int result = 5;
        result = 31 * result + this.codigoCidade.hashCode();
        result = 31 * result + this.codigoPais.hashCode();
        result = 31 * result + this.telefone.hashCode();

        return result;

    }
}
