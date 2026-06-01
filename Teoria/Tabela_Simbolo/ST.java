package Teoria.Tabela_Simbolo;

/**
 * Associação de valores a chaves
 * 
 * Algoritmos e Estruturas de Dados 2025-26, Faculdade de Ciências, Universidade
 * de Lisboa
 * 
 * @author Sedgewick and Waine, Algorithms, 4th edition, Addison-Wesley
 *
 * @param <Key>   As chaves desta tabela de símbolos
 * @param <Value> Os valores desta tabela de símbolos
 */
public interface ST<Key extends Comparable<Key>, Value> extends Iterable<Key> {

	/**
	 * Associa o valor especificado à chave indicada nesta tabela de símbolos.
	 * Se a chave já existir, o valor anterior é substituído. Se o valor for
	 * {@code null}, a chave é removida da tabela.
	 *
	 * @param key a chave
	 * @param val o valor a associar à chave
	 * @requires key != null
	 */
	void put(Key key, Value val);

	/**
	 * Devolve o valor associado à chave indicada.
	 *
	 * @param key a chave
	 * @return o valor associado à chave, ou {@code null} se a chave não existir
	 * @requires key != null
	 */
	Value get(Key key);

	/**
	 * Devolve o número de pares chave-valor presentes na tabela de símbolos.
	 *
	 * @return o número de pares chave-valor
	 */
	int size();

	/**
	 * Indica se a tabela contém um valor associado à chave indicada.
	 *
	 * @param key a chave
	 * @return {@code true} se a tabela contiver a chave; {@code false} caso
	 *         contrário
	 * @requires key != null
	 */
	default boolean contains(Key key) {
		return get(key) != null;
	};

	/**
	 * Indica se a tabela de símbolos está vazia.
	 *
	 * @return {@code true} se a tabela não tiver pares chave-valor; {@code false}
	 *         caso contrário
	 */
	default boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Remove a chave indicada (e o valor associado) da tabela de símbolos.
	 *
	 * @param key a chave a remover
	 * @requires key != null
	 */
	default void delete(Key key) {
		put(key, null);
	}
}
