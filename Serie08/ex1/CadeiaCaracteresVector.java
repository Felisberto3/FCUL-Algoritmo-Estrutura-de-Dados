package Serie08.ex1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CadeiaCaracteresVector implements CadeiaCaracteres {
    private final char[] cadeia;

    private CadeiaCaracteresVector(int n) {
        cadeia = new char[n];
    }

    public CadeiaCaracteresVector(char c) {
        this(1);
        this.cadeia[0] = c;
    }

    public CadeiaCaracteresVector(char[] list) {
        this(list.length);
        for (int i = 0; i < list.length; i++)
            this.cadeia[i] = list[i];
    }

    @Override
    public int comprimento() {
        return this.cadeia.length;
    }

    @Override
    public CadeiaCaracteres concat(CadeiaCaracteres outra) {
        int novoComprimento = this.comprimento() + outra.comprimento();
        CadeiaCaracteresVector newCadeiaCaracteres = new CadeiaCaracteresVector(novoComprimento);

        int i = 0;

        for (Character c : this) {
            newCadeiaCaracteres.cadeia[i++] = c;
        }
        for (Character c : outra) {
            newCadeiaCaracteres.cadeia[i++] = c;
        }

        return newCadeiaCaracteres;

    }

    @Override
    public CadeiaCaracteres subcadeia(int primeiro, int ultimo) {
        int novoComprimento = ultimo - primeiro + 1;
        if (primeiro < 0 || ultimo >= this.comprimento() || novoComprimento <= 0) {
            throw new IllegalArgumentException("Comprimento inválido");
        }
        CadeiaCaracteresVector novaCadeiaCaracteres = new CadeiaCaracteresVector(novoComprimento);

        for (int i = 0; i < novoComprimento; i++) {
            novaCadeiaCaracteres.cadeia[i] = this.cadeia[primeiro + i];
        }

        return novaCadeiaCaracteres;
    }

    @Override
    public Iterator<Character> iterator() {
        return new Iterator<Character>() {
            private int i = 0;

            public boolean hasNext() {
                return i < cadeia.length;
            }

            public Character next() {
                if (!hasNext())
                    throw new NoSuchElementException();

                return cadeia[i++];
            }
        };
    }

    public String toString() {
        return new String(this.cadeia);
    }

}
