package ForExame.ST;

/**
 * Armazena dados em forma de chave - valor numa tabela hash
 * 
 * @param <Key>   chaves do rash table
 * @param <Value> valor da rash table
 */
public class LinearProbingST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int m;
    private int size;

    @SuppressWarnings("unchecked")
    public LinearProbingST(int m) {
        keys = (Key[]) new Comparable[m];
        values = (Value[]) new Object[m];

        this.m = m;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    /**
     * @param Key chave a ser pesquisada
     * @return null se nao encontrar e Value caso contrario
     */
    @Override
    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].compareTo(key) == 0) {
                return values[i];
            }
        }

        return null;
    }

    /**
     * @param Key   chave a ser inserida ou pesquisada
     * @param Value valor a ser inserido.
     */
    @Override
    public void put(Key key, Value value) {
        if (size >= (keys.length * (3 / 4)))
            resize(m * 2);

        int i = hash(key);
        for (; keys[i] != null; i = (i + 1) % m) {
            if (keys[i].compareTo(key) == 0) {
                values[i] = value;

                if (value == null)
                    size--;
                return;
            }
        }

        keys[i] = key;
        values[i] = value;
        if (value != null)
            size++;

    }

    /**
     * @return O tamanho de chave e valores.
     */
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return size;
    }

    private void resize(int capacity) {
        LinearProbingST<Key, Value> t = new LinearProbingST<>(capacity);

        for (int i = 0; i < size; i++) {
            if (values[i] != null) {
                t.put(keys[i], values[i]);
            }
        }

        keys = t.keys;
        values = t.values;
        size = t.size;
        m = t.m;

    }

    public static void main(String[] args) {
        System.out.println((int) 'E');
        System.out.println((int) 'A');
        System.out.println((int) 'S');
        System.out.println((int) 'Y');
        System.out.println((int) 'Q');
        System.out.println((int) 'U');
        System.out.println((int) 'T');
        System.out.println((int) 'I');
        System.out.println((int) 'O');
        System.out.println((int) 'N');

        System.out.println("===========IN HASH ========");
        System.out.println(((Character) 'E').hashCode() * 11 % 5);
        System.out.println(((Character) 'A').hashCode() * 11 % 5);
        System.out.println(((Character) 'S').hashCode() * 11 % 5);
        System.out.println(((Character) 'Y').hashCode() * 11 % 5);
        System.out.println(((Character) 'Q').hashCode() * 11 % 5);
        System.out.println(((Character) 'U').hashCode() * 11 % 5);
        System.out.println(((Character) 'T').hashCode() * 11 % 5);
        System.out.println(((Character) 'I').hashCode() * 11 % 5);
        System.out.println(((Character) 'O').hashCode() * 11 % 5);
        System.out.println(((Character) 'N').hashCode() * 11 % 5);
        // LinearProbingST<Integer, String> t = new LinearProbingST<>(45);
        // t.put(4, "Felisberto");
        // t.put(-2, "Alberto");

        // System.out.println(t.get(1));
    }

}