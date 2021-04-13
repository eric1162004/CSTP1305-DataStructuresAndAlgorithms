package Dictionary;

public interface IDictionary<K, V> {

    // Pre: @key cannot overlap with existing keys;
    // Post: @key and @value pair is added to the dictionary; if @key already exists, throw IllegalArgumentException;
    void add(K key, V value);

    // Pre: an existing @key
    // Post: Remove the @key and @value pair from the dictionary; else, return.
    void remove(K key);

    // Pre: an existing @key
    // Post: return the value of the given @key; else, return null.
    V get(K key);

    // Pre: an existing @key
    // Post: return true if @key exists; else false
    boolean contains(K key);

    // Pre: none
    // Post: return true if the dictionary empty; else return false;
    boolean isEmpty();
}
