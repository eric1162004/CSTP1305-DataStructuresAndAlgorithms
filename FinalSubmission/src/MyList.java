public class MyList <T> implements ListInterface<T>{
    protected Entry head;
    protected Entry tail;
    protected int count;

    public MyList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    @Override
    public void add(T value) {
        Entry newEntry = new Entry(value);

        if(head == null){
            head = newEntry;
            tail = newEntry;
            ++count;
            return;
        }

        tail.next = newEntry;
        newEntry.prev = tail;
        tail = newEntry;
        ++count;
    }

    @Override
    public void erase(T value) {
        if(head == null)
            return;

        Entry temp = head;
        while(temp != null && temp.value != value){
            temp = temp.next;
        }

        if(temp == null)
            return;

        if(temp.prev != null && temp.next != null){
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        } else if(temp.prev != null && temp.next == null){
            tail = temp.prev;
            tail.next = null;
        } else if(temp.next != null && temp.prev == null){
            head = temp.next;
            head.prev = null;
        } else {
            head = null;
            tail = null;
        }
        --count;
    }

    @Override
    public void replace(T oldValue, T newValue) {
        if(head == null || oldValue == null || newValue == null)
            return;

        Entry temp = head;
        while(temp != null){
            if(temp.value == oldValue){
                temp.value = newValue;
                return;
            }
            temp = temp.next;
        }

    }

    @Override
    public T get(int position) {
        if(position > count || position < 0)
            return null;

        Entry temp = head;
        int currentPosition = 0;
        while(currentPosition < position){
            temp = temp.next;
            currentPosition++;
        }

        return temp == null ? null : temp.value;
    }

    @Override
    public T[] getAll() {
        // var tempLists = new T[count];
        return null;
    }

    @Override
    public boolean has(T value) {
        Entry temp = head;
        while(temp != null){
            if(temp.value == value)
                return true;
            temp = temp.next;
        }
        return false;
    }

    @Override
    public void removeAll() {
        head = null;
        tail = null;
        count = 0;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    protected class Entry{
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
