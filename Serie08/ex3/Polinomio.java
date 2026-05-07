
package Serie08.ex3;

public class Polinomio implements IPolinomio {
    private final double[] conjunto;
    private final int grau;

    public Polinomio(double[] values) {
        conjunto = values;

        int maiorGrau = 0;

        int i = values.length - 1;
        while (i > 0 && maiorGrau == 0) {
            if (values[i] != 0) {
                maiorGrau = i;
            }
            i--;
        }

        grau = maiorGrau;
    }

    @Override
    public double coeficiente(int n) {
        if (n < 0 || n > this.grau()) {
            return 0;
        }

        return this.conjunto[n];
    }

    @Override
    public boolean constante() {
        return grau() == 0;
    }

    @Override
    public int grau() {
        return grau;
    }

    @Override
    public IPolinomio mais(IPolinomio outro) {
        int maiorGrau = Math.max(this.grau(), outro.grau());

        double[] values = new double[maiorGrau + 1];

        for (int i = 0; i < values.length; i++) {
            values[i] = this.coeficiente(i) + outro.coeficiente(i);
        }

        return new Polinomio(values);
    }

    @Override
    public IPolinomio menos(IPolinomio q) {
        return this.mais(q.menos());
    }

    @Override
    public IPolinomio menos() {
        double[] values = new double[this.grau() + 1];

        for (int i = 0; i <= this.grau(); i++) {
            values[i] = -1 * this.coeficiente(i);
        }

        return new Polinomio(values);

    }

    @Override
    public int valor(int x) {
        int soma = 0;
        for (int i = 0; i <= this.grau(); i++) {
            soma += this.coeficiente(i) * Math.pow(x, i);
        }

        return soma;
    }

    @Override
    public IPolinomio vezes(IPolinomio q) {
        int maiorGrau = this.grau() + q.grau();

        double[] values = new double[maiorGrau + 1];

        for (int i = 0; i <= this.grau(); i++) {
            for (int j = 0; j <= q.grau(); j++) {
                values[i + j] += this.coeficiente(i) * q.coeficiente(j);
            }
        }

        return new Polinomio(values);

    }

    @Override
    public boolean zero() {
        return this.grau() == 0 && this.coeficiente(0) == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= this.grau(); i++) {
            if (this.coeficiente(i) > 0)
                sb.append("+");

            sb.append(this.coeficiente(i)).append("x^").append(i);
        }

        return sb.toString();
    }

}