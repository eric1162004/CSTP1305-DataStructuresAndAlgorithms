package Dictionary;

public class Dictionary implements IDictionary<String, Integer>{
    Node head;
    int count;

    public Dictionary() {
        head = null;
        count = 0;
    }

    @Override
    public void add(String key, Integer value) {
        if(contains(key))
            throw new IllegalArgumentException("This key already exists.");

        Node newNode = new Node(key, value);

        if(head != null)
            newNode.next = head;

        head = newNode;
        ++count;
    }

    @Override
    public void remove(String key) {
        if(head == null)
            return;

        Node temp = head;
        Node prev = null;
        while(temp != null && temp.key != key){
            temp = temp.next;
            prev = temp;
        }

        if(temp == null)
            return;

        if(prev != null && temp.next != null)
            prev.next = temp.next;
        else if(prev != null)
            prev.next = null;
        else
            head = null;

        --count;
    }

    @Override
    public Integer get(String key) {
        if(head == null)
            return null;

        Node temp = head;
        while(temp != null){
            if(temp.key == key)
                return temp.value;
            temp = temp.next;
        }

        return null;
    }

    @Override
    public boolean contains(String key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    class Node{
        private String key;
        private int value;
        private Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

