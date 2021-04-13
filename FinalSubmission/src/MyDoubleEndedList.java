public class MyDoubleEndedList<T> extends MyList<T> implements DoubleEndedListInterface<T> {
    private Entry head;
    private Entry tail;
    private int count;

    public MyDoubleEndedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    @Override
    public void addFirst(T value) {
        if(value == null)
            return;

        Entry newEntry = new Entry(value);

        if(head != null){
            head.prev = newEntry;
            newEntry.next = head;
        } else{
            tail = newEntry;
        }

        head = newEntry;
        ++count;
    }

    @Override
    public void addLast(T value) {
        if(value == null)
            return;

        Entry newEntry = new Entry(value);

        if(tail != null){
            tail.next = newEntry;
            newEntry.prev = tail;
        } else{
            head = newEntry;
        }

        tail = newEntry;
        ++count;
    }

    @Override
    public T removeFirst() {
        if(head == null)
            return null;

        var temp = head.value;

        if(head.next != null){
            head = head.next;
        }else{
            head = null;
            tail = null;
        }

        count--;

        return temp;
    }

    @Override
    public T removeLast() {
        if(tail == null)
            return null;

        var temp = tail.value;

        if(tail.prev != null){
            tail = tail.prev;
        }else{
            head = null;
            tail = null;
        }

        count--;
        return temp;
    }

    @Override
    public T getFirst() {
        if(head == null)
            return null;

        return head.value;
    }

    @Override
    public T getLast() {
        if(tail == null)
            return null;

        return tail.value;
    }

    @Override
    public void moveToEnd() {

    }

    class Entry{
        public T value;
        public Entry next;
        public Entry prev;

        public Entry(T value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
}
