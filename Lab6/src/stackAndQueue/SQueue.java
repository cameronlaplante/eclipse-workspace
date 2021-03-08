package stackAndQueue;

import java.util.Stack;

public class SQueue {

	//create stack
	Stack<Integer> myStack = new Stack<Integer>();
	
	//---------------------------------------
	//add element to stack
	//---------------------------------------
	public void add(int x) {
		
		//assign variable to size of myStack
		int size = myStack.size();
		
		//add new element to myStack
		myStack.push(x);
		
		//for each element in myStack, reverse order
		for (int i = 0; i< size; i++) {
			int z = myStack.pop();
			myStack.push(z);
		}
	}
	
	//---------------------------------------
	//remove top element
	//---------------------------------------
	public int remove() {
		
		//if empty, print to screen
		if (myStack.isEmpty()) {
			return(-1);
		}
		
		//remove element and return it. 
		int x = myStack.pop();
		return x;	
	}
	
	//---------------------------------------
	//get top element with peek (do not remove)
	//---------------------------------------
	public int peek() {
		
		//check if empty
		if (myStack.isEmpty()) {
			return(-1);
		}
		
		//return top element
		int z = myStack.peek();
		return z;
	}
	
	//---------------------------------------
	//return size of myStack
	//---------------------------------------
	public int size() {
		return myStack.size();
	}
	
	//---------------------------------------
	//check if myStack is empty
	//---------------------------------------
	public boolean isEmpty() {
		//if empty return true. otherwise false. 
			if (myStack.isEmpty()){
				return true;
			}
			else {
				return false;
			}
	}
}
