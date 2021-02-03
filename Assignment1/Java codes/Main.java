package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

/*      StackUsingArrays aStack= new StackUsingArrays(1);
        try{
            aStack.push(6);
            aStack.push(6);
            aStack.push(1);
            aStack.push(5);
            aStack.pop();
            aStack.pop();
            System.out.printf("Peeking the stack %d\n", aStack.peek()); // 7
            System.out.printf("Is the stack empty now: %s\n", aStack.isEmpty());
            System.out.printf("Number of occurrence of 6: %s\n", aStack.getFrequency(6));
            System.out.printf("Clearing the stack now...\n");
            aStack.clear();
            System.out.printf("Number of occurrence of 6: %s\n", aStack.getFrequency(6));
            System.out.printf("Is the stack empty now: %s\n", aStack.isEmpty());

        } catch(Exception e){
            System.out.println(e.getMessage());
        }*/

/*        StackUsingList aStackList = new StackUsingList();
        aStackList.push(6);
        aStackList.push(6);
        aStackList.push(1);
        aStackList.push(5);
        aStackList.pop();
        aStackList.pop();
        System.out.printf("Peeking the stack %d\n", aStackList.peek()); // 7
        System.out.printf("Is the stack empty now: %s\n", aStackList.isEmpty());
        System.out.printf("Number of occurrence of 6: %s\n", aStackList.getFrequency(6));
        System.out.printf("Clearing the stack now...\n");
        aStackList.clear();
        System.out.printf("Number of occurrence of 6: %s\n", aStackList.getFrequency(6));
        System.out.printf("Is the stack empty now: %s\n", aStackList.isEmpty());*/

/*        QueueUsingArrays aQueue =  new QueueUsingArrays();
        aQueue.insert(6);
        aQueue.insert(5);
        aQueue.insert(4);
        aQueue.insert(4);
        aQueue.remove();
        aQueue.remove();
        aQueue.insert(9);
        aQueue.insert(5);
        System.out.printf("peeking the queue: %d\n", aQueue.peek());  // should be 4
        System.out.printf("Is the queue empty now: %s\n", aQueue.isEmpty());
        System.out.printf("Number of occurrence of 4: %s\n", aQueue.getFrequency(4));
        System.out.printf("Clearing the queue now...\n");
        aQueue.clear();
        System.out.printf("Number of occurrence of 4: %s\n", aQueue.getFrequency(4));
        System.out.printf("Is the queue empty now: %s\n", aQueue.isEmpty());*/


/*      QueueUsingLists aQueue =  new QueueUsingLists();
        aQueue.insert(6);
        aQueue.insert(5);
        aQueue.insert(4);
        aQueue.insert(4);
        aQueue.remove();
        aQueue.remove();
        aQueue.insert(9);
        aQueue.insert(5);
        System.out.printf("peeking the queue: %d\n", aQueue.peek());  // should be 4
        System.out.printf("Is the queue empty now: %s\n", aQueue.isEmpty());
        System.out.printf("Number of occurrence of 4: %s\n", aQueue.getFrequency(4));
        System.out.printf("Clearing the queue now...\n");
        aQueue.clear();
        System.out.printf("Number of occurrence of 4: %s\n", aQueue.getFrequency(4));
        System.out.printf("Is the queue empty now: %s\n", aQueue.isEmpty());*/

/*        PriorityQueueUsingLists aQueuelist =  new PriorityQueueUsingLists();
        aQueuelist.insert(6);
        aQueuelist.insert(4);
        aQueuelist.insert(7);
        aQueuelist.insert(3);
        aQueuelist.remove();        // which item should be served if its data represent its priority (the higher the data, the higher the priority): 7
        aQueuelist.remove();        // remove 6
        aQueuelist.insert(9);
        aQueuelist.insert(5);
        // some debugging // front point to 7 and its value = 2
        // back points to 5 and values = 0
        System.out.println(aQueuelist.peek());*/

/*        QueueUsingCircularList aQueuelist =  new QueueUsingCircularList();
        aQueuelist.insert(6);
        aQueuelist.insert(4);
        aQueuelist.insert(7);
        aQueuelist.insert(3);
        aQueuelist.remove();        // which item should be served if its data represent its priority (the higher the data, the higher the priority): 7
        aQueuelist.remove();        // remove 6
        aQueuelist.insert(9);
        aQueuelist.insert(5);
        // some debugging // front point to 7 and its value = 2
        // back points to 5 and values = 0
        System.out.println(aQueuelist.peek());*/

/*        QueueUsingDoubleList aQueuelist =  new QueueUsingDoubleList();
        aQueuelist.insertAtBack(10);
        aQueuelist.insertAtBack(4);
        aQueuelist.insertAtBack(2);
        aQueuelist.insertAtBack(5);
        aQueuelist.removeFromBack();
        System.out.println(aQueuelist.peekFromBack()); //2*/

        int arr[] = new int[10];
        for(int i =0; i< arr.length; i++)
            arr[i] = i;

        Searching s = new Searching();
        int result = s.linear_search(arr, 111);
        result = s.binary_search_iterative(arr, 2);
        System.out.println(result);

    }
}
