package Teoria.Tabela_Simbolo;

import java.security.Key;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Uma tabela de símbolos implementada com um vetor ordenado
 * 
 * Algoritmos e Estruturas de Dados 2023-24, Faculdade de Ciências, Universidade
 * de Lisboa
 * 
 * @author Sedgewick and Waine, Algorithms, 4th edition, Addison-Wesley
 *
 * @param <Key>   As chaves desta tabela de símbolos
 * @param <Value> Os valores desta tabela de símbolos
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {

	private Key[] keys;
	private Value[] vals;
	private int size;
	private static final int DEFAULT_CAPACITY = 10000;

	public BinarySearchST() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}

	/**
	 * Associa o valor val à chave key.
	 * 
	 * @param key A chave
	 * @param val O valor a associar à chave
	 * @requires Existe espaço livre no array vals,
	 *           isto é, size seja inferior à capacidade do vetor.
	 */
	@Override
	public void put(Key key, Value val) {
		int i = rank(key);
		if (i < size && keys[i].compareTo(key) == 0) {
			vals[i] = val;
			if (val == null)
				size--; // delete
			return;
		}
		for (int j = size; j > i; j--) {
			keys[j] = keys[j - 1];
			vals[j] = vals[j - 1];
		}
		keys[i] = key;
		vals[i] = val;
		if (val != null)
			size++; // genuine put
	}

	@Override
	public Value get(Key key) {
		int i = rank(key);
		if (i < size && keys[i].compareTo(key) == 0)
			return vals[i];
		else
			return null;
	}

	/**
	 * @param key A chave
	 * @return número de chaves inferiores a key
	 */
	private int rank(Key key) {
		int lo = 0, hi = size - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0)
				hi = mid - 1;
			else if (cmp > 0)
				lo = mid + 1;
			else
				return mid;
		}
		return lo;
	}

	@Override
	public int size() {
		return size;
	}

	private void resize(int capacity) {
		// Cria novos vetores com a nova capacidade desejada
		@SuppressWarnings("unchecked")
		Key[] tempK = (Key[]) new Comparable[capacity];
		@SuppressWarnings("unchecked")
		Value[] tempV = (Value[]) new Object[capacity];

		// Copia todos os elementos atuais para os novos vetores
		for (int i = 0; i < size; i++) {
			tempK[i] = keys[i];
			tempV[i] = vals[i];
		}

		// Os nossos vetores principais passam a apontar para os novos vetores maiores
		keys = tempK;
		vals = tempV;
	}

	@Override
	public Iterator<Key> iterator() {
		return new Iterator<Key>() {
			private int current = 0;

			@Override
			public boolean hasNext() {
				return current < size;
			}

			@Override
			public Key next() {
				if (!hasNext())
					throw new NoSuchElementException();
				return keys[current++];
			}
		};
	}
}
