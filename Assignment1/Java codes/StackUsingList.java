package com.company;

public class StackUsingList {

    Node top;
    int size;

    StackUsingList(){
        size = 0;
    }

    void push(int a){
        if(size == 0 ){
            top = new Node();
            top.data = a;
            top.next = null;
        } else {
            Node tmp = new Node();
            tmp.data = a;
            tmp.next = top;
            top = tmp;
        }

        size++;
    }

    int peek(){
        return top.data;
    }

    int pop(){
        int tmp = top.data;
        top = top.next;
        size--;
        return tmp;
    }

    Boolean isEmpty(){
        return size == 0;
    }

    void clear(){
        if(!isEmpty()){
            top = null;
            size = 0;
        }
    }

    int getFrequency(int x){
        if(!isEmpty()){
            int count = 0;
            Node cur = top;
            for(int i=0; i< size; ++i){
                if (top.data == x) ++count;
                if(top.next != null)
                    cur = cur.next;
            }
            return count;
        }
        return -1; // -1 mean the stack is empty
    }

}
