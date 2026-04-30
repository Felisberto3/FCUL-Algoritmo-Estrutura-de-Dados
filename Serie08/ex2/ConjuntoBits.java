package Serie08.ex2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ConjuntoBits implements ConjuntoBits64 {
    private final long bits;

    public ConjuntoBits() {
        this.bits = 0;
    }

    private ConjuntoBits(long bits) {
        this.bits = bits;
    }

    @Override
    public ConjuntoBits64 adicionar(int pos) {
        return new ConjuntoBits(this.bits | (1L << pos));
    }

    @Override
    public int cardinal() {
        int count = 0;
        for (int x : this) {
            count++;
        }

        return count;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");

        boolean primeiro = true;
        for (int x : this) {
            if (!primeiro)
                sb.append(",");

            sb.append(x);
            primeiro = false;
        }

        return sb.append("}").toString();
    }

    @Override
    public boolean contem(int pos) {
        return (this.bits & (1L << pos)) != 0;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int i = 0;

            public boolean hasNext() {
                while (i < 64) {
                    if (contem(i))
                        return true;

                    i++;
                }

                return false;
            }

            public Integer next() {
                if (!hasNext())
                    throw new NoSuchElementException("Lista vazia");
                return i++;
            }

        };
    }

}
