import com.sun.javaws.exceptions.InvalidArgumentException;

public class MyDictionary implements IDictionary<String, Integer>{

    Node head;
    int count;

    public MyDictionary() {
        head = null;
        count = 0;
    }

    @Override
    public void Add(String key, Integer value) throws InvalidKeyException {
        // Check if Our dictionary already contains such key
        // if yes, throws exception
        if(Contains(key))
            throw new InvalidKeyException("Key already exists");

        // Adding the new key/value node
        if(head == null)
            head = new Node(key, value);
        else{
            Node new_node = new Node(key, value);
            new_node.next = head;
            head = new_node;
        }

        // increment count
        count++;
    }

    @Override
    public void Remove(String key) {

        // Check if the Dictionary is empty
        if(head == null) return;

        // Special Case: Check if the head contains the key
        if(head.key == key){
            if(head.next != null)
                head = head.next;
            else
                head = null;
            count--;
            return;
        }

        // General Case:
        Node temp = head.next;
        Node temp_prev = head;

        while(temp != null){
            if(temp.key == key){ // If key matches
                if(temp.next == null){ // if this is the last node in the list
                    temp_prev.next = null;
                } else{
                    temp_prev.next = temp.next;  // if not, set connect the next node to the prev node
                }
                count--;
                return;
            } else{  // if key does not match, continues
                temp_prev = temp;
                temp = temp.next;
            }
        }

    }

    @Override
    public Integer GetValue(String key){
        Node temp = head;
        while(temp != null){
            if(temp.key == key)
                return (Integer) temp.value;
            temp = temp.next;
        }
        return null;
    }

    @Override
    public boolean Contains(String key) {
        Node temp = head;
        while (temp != null){
            if(temp.key == key)
                return true;
            temp = temp.next;
        }
        return false;
    }

    @Override
    public boolean IsEmpty() {
        return count == 0;
    }
}
