#include <iostream>

class Node {
public:
    int data;
    Node* next;
};

class QueueUsingLists {

    int size;
    Node* front;
    Node* back;

public:
    QueueUsingLists() {
        size = 0;
    }

    void insert(int a) {
        if (size == 0) {
            Node* aNewNode = new Node();
            aNewNode->data = a;
            aNewNode->next = nullptr;
            front = aNewNode;
            back = aNewNode;
        }
        else { // insert at the back
         // 1 - create a new node
            Node* aNewNode = new Node();
            aNewNode->data = a;
            aNewNode->next = nullptr;
            // 2 - Link the queue node to this new node
            back->next = aNewNode;
            // 3 - move the back now to the newly added node
            back = back->next;
        }
        size++;

    }

    int remove() {
        int result = front->data;
        Node* temp = front;
        // one step: moving the front
        front = front->next;
        delete temp;
        size--;
        return result;
    }

    int peek() {
        return front->data;
    }

    bool isEmpty() {
        return size == 0;
    }

    void clear() {
        if (isEmpty()) return;

        // memory managment 
        Node* current = front;
        while (current->next != NULL) {
            Node* temp = current;
            current = current->next;
            delete temp;
        }
        delete current;
        size = 0;
    }

    int getFrequency(int x) {
        if (isEmpty()) return -1; // -1 means the queue is empty
        
        Node* current = front;
        int count{};
        for (int i = 0; i < size; i++)
        {
            if (current->data == x) ++count;
            current = current->next;
        }
    
        return count;
    }

};

int main()
{
    QueueUsingLists aQueuelist;
    aQueuelist.insert(6);
    aQueuelist.insert(5);
    aQueuelist.insert(4);
    aQueuelist.remove();       
    aQueuelist.remove();      
    aQueuelist.insert(4);
    aQueuelist.insert(5);

    std::cout << "Peek the queue: "  << aQueuelist.peek() << std::endl;

    // Testing isEmpty() for an non-empty queue
    std::cout << std::boolalpha << "The queue is now empty: " << aQueuelist.isEmpty() << std::noboolalpha << std::endl; // should be false

    // Testing getFrequency(int) : count the number of occurence of 5
    std::cout << "The number of occurence of 5 in the queue: " << aQueuelist.getFrequency(5) << std::endl;

    // Testing clear()
    std::cout << "Clearing the queue now..." << std::endl;
    aQueuelist.clear();

    // Testing isEmpty() for an empty queue
    std::cout << std::boolalpha << "The queue is now empty: " << aQueuelist.isEmpty() << std::noboolalpha << std::endl; // should be True

    std::cout << "The number of occurence of 5 in the queue: " << aQueuelist.getFrequency(5) << std::endl; // should be 0
}

