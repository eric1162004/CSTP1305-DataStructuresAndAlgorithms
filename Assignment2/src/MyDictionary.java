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
        if(Contains(key))
            throw new InvalidKeyException("Key already exists");

        Node temp = head;
        if(head == null)
            head = new Node(key, value);
        else{
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node(key, value);
        }
        count++;
    }

    @Override
    public void Remove(String key) {
        Node temp = head;

        if(IsEmpty()) return;

        if(head.key == key){
            if(head.next == null)
                head = null;
            else
                head = head.next;
            count--;
            return;
        }

        while(temp.next != null){
            if(temp.next.key == key){
                if(temp.next.next != null)
                    temp.next = temp.next.next;
                else
                    temp.next = null;
                count--;
                break;
            }
            temp = temp.next;
        }
    }

    @Override
    public Integer GetValue(String key){
        if(!Contains(key))
            return null;

        Node temp = head;
        while(temp.key != key){
            temp = temp.next;
        }
        return (Integer) temp.value;
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
