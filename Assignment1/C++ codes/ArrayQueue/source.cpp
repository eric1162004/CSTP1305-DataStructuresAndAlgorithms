#include <iostream>

class QueueUsingArrays {

    int arr[10]; // this array only holds 10 items
    int size = 0; // the current size of the queue
    int frontIndex = 0;
    int backIndex = -1;

public:

    void insert(int a) {
        
        // The queue is max at 10 items. No more cannot be added after.
        if (size == 10) {
            std::cout << "the queue is full" << std::endl;
            return;
        }

        if (backIndex == -1) {
            ++backIndex;
        }
        else {
            backIndex = (frontIndex + size) % 10;
        }
        arr[backIndex] = a;
        size++;

    }

    int remove() {
        if (isEmpty()) return -1; // return -1 if the queue is empty
        int result = arr[frontIndex];
        frontIndex = (frontIndex + 1) % 10;
        size--;
        return result;
    }

    int peek() {
        return arr[frontIndex];
    }

    bool isEmpty() {
        return size == 0;
    }

    void clear() {
        for (int i = 0; i < size; i++)
        {
            arr[i] = NULL;
        }
        size = 0;
    }

    int getFrequency(int x) {
        if (isEmpty()) return -1; // -1 means error

        int count{ 0 };
        for (int i = 0; i < size; i++) {
            int index = (frontIndex + i) % 10;
            if (arr[index] == x) ++count;
        }
        return count;
    }

};


int main()
{
        QueueUsingArrays aQueue;
        aQueue.insert(6);
        aQueue.insert(4);
        aQueue.insert(7);
        aQueue.insert(8);
        aQueue.remove();
        aQueue.remove();
        aQueue.insert(9);
        aQueue.insert(5);
        aQueue.insert(5);
        aQueue.insert(5);
        std::cout << "Peeking the Queue: "<< aQueue.peek() << std::endl; // should be 7

        // Testing isEmpty() for an non-empty queue
        std::cout << std::boolalpha << "The queue is now empty: " << aQueue.isEmpty() << std::noboolalpha << std::endl; // should be false

        // Testing getFrequency(int) : count the number of occurence of 5
        std::cout << "The number of occurence of 5 in the queue: "<< aQueue.getFrequency(5) << std::endl;
        std::cout << "The number of occurence of 100 in the queue: "<< aQueue.getFrequency(100) << std::endl;

        // Testing clear()
        std::cout << "Clearing the queue now..." << std::endl;
        aQueue.clear();

       // Testing isEmpty() for an empty queue
        std::cout << std::boolalpha << "The queue is now empty: " << aQueue.isEmpty() << std::noboolalpha << std::endl; // should be True

}


