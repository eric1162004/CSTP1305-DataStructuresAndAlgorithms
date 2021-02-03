package com.company;

public class QueueUsingArrays {

    int [] arr = new int[6]; // a data member
    int size = 0; // it is num in the slides
    int front = 0;
    int back = -1;

    void insert (int a ){

        if (size == 6){
            System.out.println("The queue is full.");
            return;
        }

        if(back == -1){
            back = 0;
        } else {
            back = (front + size) %6;
        }
        arr[back] = a;
        size++;

    }

    int remove(){
        int result = arr[front];
        front = ( front + 1 ) % 6;
        size--;
        return result;
    }

    int peek(){
        return arr[front];
    }

    Boolean isEmpty() {
        return size == 0;
    }

    void clear(){
        if(!isEmpty()){
            size= front = 0;
            back = -1;
        }
    }

    int getFrequency(int x){
        if(isEmpty()) return -1;

        int count = 0;
        int index = front;
        for(int i = 0; i < size; ++i){
            if(arr[index++] == x) ++count;
        }
        return count;
    }


}
