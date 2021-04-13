package LinkList;

import java.util.Iterator;

public class LinkList<V> implements ILinkList<V>, Iterable<Node<V>>{

    private Node<V> head;
    private int count;

    public LinkList() {
        this.count = 0;
    }

    @Override
    public void add(V value) {
        if(head != null){
            Node<V> temp = head;
            while(temp.next != null)
                temp = temp.next;

            temp.next = new Node(value);
            count++;

            return;
        }

        head = new Node(value);
        count++;
    }

    @Override
    public V remove(V value) {
        if(head == null) return null;

        if(head.value == value){
            Node<V> temp = head;

            if(head.next != null){
                head = temp.next;
            }else{
                head = null;
            }
            count--;

            return temp.value;
        }

        Node<V> temp = head;
        Node<V> prev = null;
        while(temp.next != null){
            if(temp.value == value){
                prev.next = temp.next;
                count--;
                return temp.value;
            }
            prev = temp;
            temp = temp.next;
        }

        return null;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public Integer count() {
        return count;
    }

    @Override
    public Iterator<Node<V>> iterator() {
        return new ListIterator<V>(head);
    }

}

class ListIterator<V> implements Iterator<Node<V>> {
    private Node<V> current;

    public ListIterator(Node<V> first) {
        current = first;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Node<V> next() {
        Node<V> tempo = current;
        current = current.next;
        return tempo;
    }
}

