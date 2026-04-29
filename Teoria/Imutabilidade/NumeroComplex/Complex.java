package Teoria.Imutabilidade.NumeroComplex;

public final class Complex {
    private final double re;
    private final double im;
    /**
     * Representacao textual deste complexo
     */
    private final String text;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
        this.text = "(" + re + "," + im + ")";

    }

    /**
     * 
     * A soma deste complexo com C
     * 
     * @param c O polinomio termo
     * @return this + c
     * @requires c!= null
     */
    public Complex plus(Complex c) {
        return new Complex(this.re + c.re, this.im + c.im);
    }

    public Complex divideBy(Complex c) {
        // return new Complex(this.re / c.re)
        return null;
    }

    /**
     * A raiz quadrada de um numero real
     * 
     * @param x O numero real
     * @return A raiz quadrada complexa
     */
    public static Complex sqrt(double x) {
        return x >= 0 ? new Complex(Math.sqrt(x), 0) : new Complex(0, Math.sqrt(-x));
    }

    public String toString() {
        return text;
    }
}
