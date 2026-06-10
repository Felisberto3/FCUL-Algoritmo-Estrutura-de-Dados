package ForExame.Ex2024_2Epoca;

public interface ST<Key, Value> {

    void put(Key key, Value value);

    Value get(Key key);

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }
}
