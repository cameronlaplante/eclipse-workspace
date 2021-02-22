package testingCodes;

public class Lecture14 {

	public static void main(String args[]){
		Node myList = new Node("a");
		Node aNode = new Node("c");
		myList.next = aNode;
		myList.next.previous = myList;
		aNode = new Node("e");
		aNode.next = myList;
		myList = aNode;
		myList.next.previous = myList;
		aNode = new Node("d");
		
		myList.next.next.next = aNode;
		Node printNode = myList;
		for (int i=0; i<4; i++){
			System.out.print(printNode.content);
			printNode = printNode.next;
		}
	}
	
}
