package Teoria.Tabela_Simbolo;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * Uma tabela de símbolos implementada com uma lista não ordenada. Não requer
 * que as chaves estejam equipodas com uma relação de ordem.
 * 
 * Algoritmos e Estruturas de Dados 2022-23, Faculdade de Ciências, Universidade
 * de Lisboa
 * 
 * @author Sedgewick and Waine, Algorithms, 4th edition, Addison-Wesley
 *
 * @param <Key>   As chaves desta tabela de símbolos
 * @param <Value> Os valores desta tabela de símbolos
 */
public class SequentialSearchST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {

	private Node first;
	private int size;

	private class Node {
		Key key;
		Value val;
		Node next;

		public Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}

	public void put(Key key, Value val) {
		for (Node x = first; x != null; x = x.next)
			if (key.equals(x.key)) {
				x.val = val;
				return;
			} // Search hit: update val.
		first = new Node(key, val, first); // Search miss: add new node.
		size++;
	}

	public Value get(Key key) {
		for (Node x = first; x != null; x = x.next)
			if (key.equals(x.key))
				return x.val; // search hit
		return null; // search miss
	}

	public int size() {
		return size;
	}

	@Override
	public Iterator<Key> iterator() {
		return new Iterator<Key>() {
			private Node current = first;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public Key next() {
				if (!hasNext())
					throw new NoSuchElementException();
				Key key = current.key;
				current = current.next;
				return key;
			}
		};
	}

	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(", ");
		for (Key k : this)
			sj.add(k.toString());
		return "[" + sj.toString() + "]";
	}
}
