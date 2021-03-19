public interface IDictionary<K, V> {

    /*Pre: check if key is unique, otherwise throw exception;
    * Post: add key and value pair into the dictionary; */
    void Add(K key, V value) throws InvalidKeyException;

    /*Pre: check if key exists, otherwise throw exception;
    * Post: remove the key and value pair if the key exists; */
    void Remove(K key);

    /*Pre: check if key exists, otherwise throw exception;
    * Post: return value if key exists; */
    V GetValue(K key);

    /*Pre: arg = key
    * Post: return a boolean to indicate whether the key exists in the dictionary; */
    boolean Contains(K key);

    /*Pre: none;
    * Post: return a boolean to indicate whether the dictionary empty; */
    boolean IsEmpty();

}
