package lab5;

/*----------------------------------------------------------
 * author: Cameron LaPlante
 * course: CSCI 145
 * project: Lab5
 * Collaboration statement: By submitting this assignment,
 * I am attesting that this homework is in full compliance
 * with the course's Homework Collaboration Policy and with
 * all the other relevant academic honesty policies of the
 * course and university. I discussed this homework with no 
 * one and wrote this solution without input from anyone else.
 *------------------------------------------------------------*/

public class IntegerLinkedList {

	private IntegerNode head;
	
	// isEmpty - 
	public boolean isEmpty() {
		return head == null;
	}
	
	// insertFront - inserts node at head of list
	public void insertFront(int val) {
		IntegerNode node = new IntegerNode(val);
		node.setNext(head);
		head = node;
	}
	
	// insertBack - inserts node at tail of list. 
	public void insertBack(int val) {
		IntegerNode node = new IntegerNode(val);
		
		if(isEmpty()) {
			head = node;
		}
		else {
			IntegerNode cur = head;
			
			while(cur.getNext() != null) {
				// update cur to point to its successor
				cur = cur.getNext();
			}
			// set cur's successor to node
			cur.setNext(node);
		}
	}
	
	// print - used to print the current list
	public void print() {
		IntegerNode cur = head;
		
		// while loop iterate over each node.
		while (cur != null) {
			System.out.printf("%d", cur.getValue());
			// update cur to point to its successor
			cur = cur.getNext();
			
		}
		System.out.println();
	}
	
	// get - return value of node at specified index. 
	public int get(int index) {
		IntegerNode cur = head;
		
		//loop over each element up to the index position. 
		for(int i = 0; i <= index-1; i++) {
			//if out of bounds, print error message. 
			if (cur == null) {
				System.out.println("Index out of bounds.");
				return -1;
			}
			cur = cur.getNext();
		}
		//return value. 
		return cur.getValue();
	}
	
	// removeFront - remove node from head of list. 
	public void removeFront() {
		IntegerNode cur = head;
		
		if (head != null) {
			head = cur.getNext();
		}
	}
	
	//removeBack - remove node from tail of list. 
	public void removeBack() {
		IntegerNode cur = head;
		
		//if head or its successor are null, return
		if (head == null) {
			return;
		}
		else if (head.getNext() == null) {
			head = null;
			return;
		}
		else {
			//while next's successor is not null
			while (cur.getNext().getNext() != null) { 
				// set to successor
				cur = cur.getNext();
			}
			// set to null
			cur.setNext(null);
		}
	}
	
	//removeAt - remove node at specified index. 
	public void removeAt(int index) {
		IntegerNode cur = head;
		
		// if head is null, return
		if (head == null) {
			return;
		}
		
		// if index is zero, remove head. 
		if (index == 0) {
			head = cur.getNext();
			return;
		}
		
		// find node prior to one being deleted. 
		for (int i=0; cur != null && i < index - 1; i++) {
			cur = cur.getNext();
		}
		
		// if length of list is exceeded, return
		if (cur == null || cur.getNext() == null) {
			System.out.println("Index Out of Bounds.");
			return;
		}
		IntegerNode next = cur.getNext().getNext();
		cur.setNext(next);
		
	}
}
