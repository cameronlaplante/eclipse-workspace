package stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class QStack {
	
	//create queue
	Queue<Integer> myQueue = new LinkedList<Integer>();

	//---------------------------------------
	// push new element to queue. 
	//---------------------------------------
	public void push(int x) {
		
		int size = myQueue.size();
		
		//add new element x to myQueue.
		myQueue.add(x);
		
		//for each element in myQueue, reverse order
		for (int i = 0; i< size; i++) {
			int z = myQueue.remove();
			myQueue.add(z);
		}
	}
	
	//---------------------------------------
	//pop top element. 
	//---------------------------------------
	public int pop() {
		
		//if empty, print to screen
		if (myQueue.isEmpty()) {
			return(-1);
		}
		//remove element and return it. 
		int x = myQueue.remove();
		return x;
	}
	
	//---------------------------------------
	// return top element (do not remove)
	//---------------------------------------
	public int top() {
		
		//check if empty
		if (myQueue.isEmpty()) {
			return(-1);
		}
		
		//return top element (peek)
		int z = myQueue.peek();
		return z;
	}
	
	//---------------------------------------
	//return size of myQueue.
	//---------------------------------------
	public int size() {
		return myQueue.size();
	}
	
	//---------------------------------------
	//check if myQueue is empty
	//---------------------------------------
	public boolean isEmpty() {
	
		//if empty return true. otherwise false. 
		if (myQueue.isEmpty()){
			return true;
		}
		else {
			return false;
		}
	}
}
