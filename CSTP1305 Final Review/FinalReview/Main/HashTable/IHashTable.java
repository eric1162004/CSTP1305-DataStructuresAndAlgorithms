package HashTable;

public interface IHashTable <K, V>{

    // Pre: if key is unique, add the value to the table; else, replace the existing value.
    // Post: the key/value pair is added to the table
    void put(K key, V value);

    // Pre: key must already exist in the table; else return null
    // Post: return the value correspond to the given key
    V get(K key);

    // Pre: key must already exist in the table; else return null
    // Post: return the value correspond to the given key and remove the key/value pair from the table
    V remove(K key);

}
