package lab5;

public class IntegerNode {

	private int value;
	private IntegerNode next;
	// constructor to create an empty node
	public IntegerNode() {
	}
	// constructor to create a node with a specific value
	public IntegerNode(int val) {
		this.value = val;
	}
	// getter
	public int getValue() {
		return value;
	}
	// setter
	public void setValue(int val) {
		this.value = val;
	}
	// get the next node
	public IntegerNode getNext() {
		return next;
	}
	// set the next node
	public void setNext(IntegerNode n) {
		this.next = n;
	}
	
}
