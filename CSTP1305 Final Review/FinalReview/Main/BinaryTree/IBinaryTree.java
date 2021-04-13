package BinaryTree;

public interface IBinaryTree<T> {

    // Pre: if @value is null, return.
    // Post: @value is added to the correct position of the tree
    void insert(T value);

    // Pre: if @value is null, return false;
    // Post: if @value is found, return true; else return false;
    boolean find(T value);
}
