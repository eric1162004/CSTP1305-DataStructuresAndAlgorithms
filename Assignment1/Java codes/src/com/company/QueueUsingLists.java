package com.company;

public class QueueUsingLists {

    int size;
    Node front;
    Node back;

    QueueUsingLists(){
        size = 0;
    }

    void insert(int a){
        if(size ==0){
            Node aNewNode = new Node();
            aNewNode.data = a;
            aNewNode.next = null;
            front = aNewNode;
            back = aNewNode;
        } else { // insert at the back
            // 1 - create a new node
            Node aNewNode = new Node();
            aNewNode.data = a;
            aNewNode.next = null;
            // 2 - Link the queue node to this new node
            back.next = aNewNode;
            // 3 - move the back now to the newly added node
            back = back.next;
        }
        size++;

    }

    int remove(){
        int result = front.data;
        // one step: moving the front
        front = front.next;
        size--;
        return result;
    }

    int peek(){
        return front.data;
    }

    boolean isEmpty(){
        return size == 0;
    }

    void clear(){
        size = 0;
        back = front = null;  // thanks garbage collector!
    }

    int getFrequency(int x){
        if(isEmpty()) return -1; // -1 means the queue is empty

        Node cur = front;
        int count = 0;
        for(int i=0; i<size; ++i){
            if(cur.data == x) ++count;
            if(cur.next != null)
                cur = cur.next;
        }
        return count;
    }

}
