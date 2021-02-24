#include <iostream>
using namespace std;

class Node {
public:
	int data;
	Node* next;
};

class LinkedListStack {

	Node* top{ nullptr };
	int size{};

public:
	LinkedListStack(){}

	void push(int a ){
		if (size == 0) {
			top = new Node();
			top->data = a;
			top->next = NULL;
		}
		else {
			// this is a non empty list
			Node* tmp = new Node();
			tmp->data = a;
			tmp->next = top;
			top = tmp;
		}
		size++;
	
	}

	int pop() {
		int tmp = top->data;
		Node* toBeDeleted = top;
		top = top->next;
		delete(toBeDeleted);
		--size;
		return tmp;
	};

	int peek() {
		int tmp = top->data;
		return tmp;
	};

	bool isEmpty() {
		return size == 0;
	}

	void clear() {
		if (isEmpty()) return;

		// memory managment 
		Node* current = top;
		while (current->next != NULL) {
			Node* temp = current;
			current = current->next;
			delete temp;
		}
		delete current;

		size = 0;
	}

	int getFrequency(int x) {
		if (isEmpty()) return -1;  // -1 means the stack is empty

		Node* current = top;
		int count{};
		for (int i = 0; i < size; i++)
		{
			if (current->data == x) ++count;
			if(current->next != NULL)
				current = current->next;
		}

		return count;
	}

};

int main() {

	// testing for LinkedListStack;
	LinkedListStack myStack{};
	myStack.push(10);
	myStack.push(10);
	myStack.push(10);
	myStack.push(30);
	myStack.push(30);
	myStack.pop();
	myStack.pop();

	std::cout << "Peek the stack: " << myStack.peek() << std::endl;

	// Testing isEmpty() for an non-empty queue
	std::cout << std::boolalpha << "The stack is now empty: " << myStack.isEmpty() << std::noboolalpha << std::endl; // should be false

	// Testing getFrequency(int) : count the number of occurence of 5
	std::cout << "The number of occurence of 10 in the stack: " << myStack.getFrequency(10) << std::endl;

	// Testing clear()
	std::cout << "Clearing the stack now..." << std::endl;
	myStack.clear();

	// Testing isEmpty() for an empty queue
	std::cout << std::boolalpha << "The stack is now empty: " << myStack.isEmpty() << std::noboolalpha << std::endl; // should be True

	std::cout << "The number of occurence of 10 in the stack: " << myStack.getFrequency(10) << std::endl; // should be 0


	return 0;
}