public interface ListInterface <T>{

    // Pre: @entry should be unique
    // Post: @entry is added to the tail of the list
    void add(T entry);

    // Pre: @entry should exist in the list
    // Post: @entry is removed from the list if exist; else do nothing.
    void erase(T entry);

    // Pre: the list is not empty
    // Post: remove all entries in the list
    void removeAll();

    // Pre: require the @oldEntry to be replace and @newEntry
    // Post: the @oldEntry is replaced if the @oldEntry exist; else return;
    void replace(T oldEntry, T newEntry);

    // Pre: the list is not empty
    // Post: the entry at the given position is return; if such position is not found, return null;
    T get(int position);

    // Pre: none;
    // Post: return an array which contains all the entries in the list
    T[] getAll();

    // Pre: none
    // Post: return a boolean whether a given entry exist in the list
    boolean has(T entry);

    // Pre: none
    // Post: return the count of the list entries
    int count();

    // Pre: none
    // Post: tell whether the list is empty
    boolean isEmpty();

}

