package lab5;

public class LinkedListTest {

	public static void main(String[] args) {
		
		IntegerLinkedList myList = new IntegerLinkedList();
		
		myList.insertFront(2);
		myList.print();
		myList.insertFront(5);
		myList.print();
		myList.insertBack(6);
		myList.print();
		myList.insertFront(4);
		myList.print();
		myList.insertFront(9);
		myList.print();
		
		myList.removeFront();
		myList.print();
		
		myList.removeBack();
		myList.print();
		
		int test = myList.get(0);
		System.out.println(test);

	}
	
}
