package com.company;
//import java.lang.Exception;

public class StackUsingArrays {

    int[] arr;
    int top = -1;
    int size;

    StackUsingArrays(int s){
        size = s;
        arr = new int[size];
    }

    // create a function called resize; call this when the array has reached the limit
    // increase the size of the array by 2 times
    // copy the old data into the new arrays
    // delete the array

    void resize(){
        size = size*2;
        int[] newArr = new int[size];

        for(int i = 0; i<=top; i++){
            newArr[i] = arr[i];
        }

        arr = newArr;
    }

    void push(int a){
        top++;

        // try to use exception handling
        if (size-1 <= top){
            resize();
        }
        arr[top] =a;
    }

    int pop() throws Exception {
        if(top < 0){
            throw new Exception("The stack is empty");
        } else {
            int tmp  = arr[top];
            top--;
            return tmp;
        }
    }

    int peek(){
        return arr[top];
    }

    Boolean isEmpty(){
        return size == 0;
    }

    void clear(){
        if(!isEmpty()){
            top = -1;
            size = 0;
        }
    }

    int getFrequency(int x){
        if(isEmpty()) return -1; // -1 mean the stack is empty

        int count = 0;
        for(int i=0; i<top+1; ++i){
            if(arr[i] == x) ++count;
        }
        return count;
    }

}