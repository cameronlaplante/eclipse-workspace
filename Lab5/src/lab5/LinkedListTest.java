package lab5;

public class LinkedListTest {

	public static void main(String[] args) {
		
		IntegerLinkedList myList = new IntegerLinkedList();
		
		System.out.println("insertFront: ");
		myList.insertFront(1);
		myList.print();
		myList.insertFront(2);
		myList.print();
		myList.insertFront(3);
		myList.print();
		myList.insertFront(4);
		myList.print();
		myList.insertFront(5);
		myList.print();
		
		System.out.println("insertBack:");
		myList.insertBack(6);
		myList.print();
		myList.insertBack(7);
		myList.print();
		myList.insertBack(8);
		myList.print();
		myList.insertBack(9);
		myList.print();
		myList.insertBack(0);
		myList.print();
		
		System.out.println("removeFront:");
		myList.removeFront();
		myList.print();
		
		System.out.println("removeBack:");
		myList.removeBack();
		myList.print();
		
		System.out.println("removeAt:");
		myList.removeAt(2);
		myList.print();
		
		System.out.println("get:");
		int test = myList.get(2);
		System.out.println(test);

	}
	
}
