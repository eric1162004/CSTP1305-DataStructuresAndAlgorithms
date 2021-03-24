public interface IDictionary<K, V> {

    /*Pre: check if key is unique, otherwise throw exception;
    * Post: add key and value pair into the dictionary; */
    void Add(K key, V value) throws InvalidKeyException;

    /*Pre: key as argument
    * Post: remove the key and value pair if the key exists; otherwise it does nothing */
    void Remove(K key);

    /*Pre: key as argument
    * Post: return value if key exists; otherwise returns null */
    V GetValue(K key);

    /*Pre: key as argument
    * Post: return a boolean to indicate whether the key exists in the dictionary; */
    boolean Contains(K key);

    /*Pre: none;
    * Post: return a boolean to indicate whether the dictionary empty; */
    boolean IsEmpty();

}
