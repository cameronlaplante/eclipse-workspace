package lab5;

public class IntegerLinkedList {

	private IntegerNode head;
	private IntegerNode next;
	
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
		
		if (head == null) {
			return;
		}
		else if (head.getNext() == null) {
			return;
		}
		else {
			while (cur.getNext().getNext() != null) { 
				cur = cur.getNext();
			}
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
		
		//
		if (cur == null || cur.getNext() == null) {
			return;
		}
		
		IntegerNode next = cur.getNext().getNext();
		
		cur.setNext(next);
		
		
//		IntegerNode cur = head, prev = null;
//		
//		if (cur != null && cur.getValue() == index) {
//			head = cur.getNext();
//			return;
//		}
//		
//		while(cur != null && cur.getValue() != index) { 
//			prev = cur;
//			cur = cur.getNext();
//		}
//		
//		
	}
	
	
	
}
