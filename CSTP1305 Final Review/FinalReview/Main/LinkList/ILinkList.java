package LinkList;

public interface ILinkList <V>{

    // Pre: Add @node to the list and @node is not null; if @node is null, do nothing
    // Post: @node is added to the list
    void add(V value);

    // Pre: Remove the first node in the list that contains @value; else do nothing
    // Post: the first node in the list that contains @value, if exists, remove from the list
    V remove(V value);

    // Pre: none
    // Post: returns a boolean to indicate whether the list is empty or not
    boolean isEmpty();

    // Pre: none
    // Post: return the count of the list
    Integer count();
}
