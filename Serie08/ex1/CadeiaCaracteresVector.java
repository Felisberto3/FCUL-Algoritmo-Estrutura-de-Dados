package Serie08.ex1;

import java.util.Iterator;

public class CadeiaCaracteresVector implements CadeiaCaracteres {
    private final char[] cadeia;

    private CadeiaCaracteresVector(int n) {
        cadeia = new char[n];
    }

    public CadeiaCaracteresVector(char c) {
        this(1);
        this.cadeia[0] = c;
    }

    @Override
    public int comprimento() {
        // TODO Auto-generated method stub
        return this.cadeia.length;
    }

    @Override
    public CadeiaCaracteres concat(CadeiaCaracteres outra) {
        int novoComprimento = this.cadeia.length + outra.comprimento();
        CadeiaCaracteresVector newCadeiaCaractere = new CadeiaCaracteresVector(novoComprimento);

        for (int i = 0; i < novoComprimento; i++) {
            for (Character c : this) {
                newCadeiaCaractere.cadeia[i++] = c;
            }
            for (Character c : outra) {
                newCadeiaCaractere.cadeia[i++] = c;
            }
        }

        return newCadeiaCaractere;

    }

    @Override
    public CadeiaCaracteres subcadeia(int primeiro, int ultimo) {

        return null;

    }

    @Override
    public Iterator<Character> iterator() {
        return new Iterator<Character>() {
            private int i = 0;

            public boolean hasNext() {
                return i < cadeia.length;
            }

            public Character next() {
                return cadeia[i];
            }
        };
    }

}
