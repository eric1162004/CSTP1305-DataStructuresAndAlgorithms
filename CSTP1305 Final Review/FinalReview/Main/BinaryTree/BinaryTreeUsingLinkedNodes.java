package BinaryTree;

public class BinaryTreeUsingLinkedNodes implements IBinaryTree<Integer>{
    private Node root;

    @Override
    public void insert(Integer value) {
        var newNode = new Node(value);

        if(root == null){
            root = newNode;
            return;
        }

        Node temp = root;
        while(true){
            if(temp.value > value && temp.leftChild == null){
                temp.leftChild = newNode;
                break;
            }

            if(temp.value <= value && temp.rightChild == null){
                temp.rightChild = newNode;
                break;
            }

            temp = temp.value > value ? temp.leftChild : temp.rightChild;
        }
    }

    @Override
    public boolean find(Integer value) {
        Node temp = root;
        while(temp != null){
            if(temp.value == value)
                return true;
            temp = temp.value > value ? temp.leftChild : temp.rightChild;
        }

        return false;
    }

    public void traversePreOrder(){
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root){
        if(root == null) return;
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public int height(){
        return height(root);
    }

    private int height(Node root){
        if(root == null)
            return -1;

        if(root.leftChild == null &&
                root.rightChild == null)
            return 0;

        var leftHeight = height(root.leftChild);
        var rightHeight = height(root.rightChild);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int findMin(){
        return findMin(root);
    }

    private int findMin(Node root){
        if(root == null) return 0;

        if(root.leftChild == null && root.rightChild == null)
            return root.value;

        var leftValue = findMin(root.leftChild);
        var rightValue = findMin(root.rightChild);
        return Math.min(Math.min(leftValue, rightValue), root.value);
    }

    public boolean equals(BinaryTreeUsingLinkedNodes other){
        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second){
        if(first == null && second == null)
            return true;

        if(first != null && second != null)
            return first.value == second.value &&
                    equals(first.leftChild == second.leftChild) &&
                    equals(first.rightChild == second.rightChild);

        return false;
    }

    public boolean isBinarySearchTree(){
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBinarySearchTree(Node root, int min, int max){
        if(root == null)
            return true;

        if(root.value < min || root.value > max)
            return false;

        return
            isBinarySearchTree(root.leftChild, min, root.value - 1) &&
            isBinarySearchTree(root.rightChild,root.value + 1, max);
    }

    public void printNodesAtDistance(int distance){
        printNodesAtDistance(root, distance);
    }

    private void printNodesAtDistance(Node root, int distance){
        if(root == null) return;

        if(distance == 0){
            System.out.println(root.value);
            return;
        }

        printNodesAtDistance(root.leftChild, distance - 1);
        printNodesAtDistance(root.rightChild, distance - 1);
    }

    public void traverseLevelOrder(){
        for (int i = 0; i < height(); i++) {
            printNodesAtDistance(i);
        }
    }

    private class Node{
        public Integer value;
        public Node leftChild;
        public Node rightChild;

        public Node(Integer value) {
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

}
