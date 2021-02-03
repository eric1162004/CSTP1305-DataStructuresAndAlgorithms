#include <iostream>
using namespace std;

class myStack {

	static const int SIZE{ 5 };
	int arr[SIZE]; // this array can only hold 5 items
	int top = -1;

public:
	void push(int a) {
		if (top+1 == SIZE) {
			std::cout << "the stack is full." << std::endl;
			return;
		}
		arr[++top] = a;
	}

	int pop() {
		return arr[top--];
	}

	int peek() {
		return arr[top];
	}

	bool isEmpty() {
		return top == -1;
	}

	void clear() {
		if (isEmpty()) return;

		for (int i{ 0 }; i < SIZE; ++i) 
			arr[i] = NULL;

		top = -1;
	}

	int getFrequency(int x) {
		if (isEmpty()) return -1;  // -1 means the stack is empty

		int count{ 0 };
		for (int i{ 0 }; i <= top; ++i) 
			if (x == arr[i]) ++count;

		return count;
	}

};

int main() {
	
	myStack st;
	st.push(1);
	st.push(1);
	st.push(3);
	st.push(4);
	st.push(5);
	st.push(6); // should not be able to add onto the stack

	std::cout << st.peek() << std::endl; // should be 5
	st.pop(); // remove 5
	std::cout << st.peek() << std::endl; // should be 4

	// Testing isEmpty() for an non-empty queue
	std::cout << std::boolalpha << "The stack is now empty: " << st.isEmpty() << std::noboolalpha << std::endl; // should be false

	// Testing getFrequency(int) : count the number of occurence of 5
	std::cout << "The number of occurence of 1 in the stack: " << st.getFrequency(1) << std::endl;

	// Testing clear()
	std::cout << "Clearing the stack now..." << std::endl;
	st.clear();

	// Testing isEmpty() for an empty queue
	std::cout << std::boolalpha << "The stack is now empty: " << st.isEmpty() << std::noboolalpha << std::endl; // should be True

	std::cout << "The number of occurence of 1 in the stack: " << st.getFrequency(1) << std::endl; // should be -1


	return 0;
}