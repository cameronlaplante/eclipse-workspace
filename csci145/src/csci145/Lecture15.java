package csci145;

import java.util.Stack;

public class Lecture15 {

	public static void main(String[] args) {

		Stack<Integer> myStack = new Stack<Integer>();

		myStack.push(34);
		myStack.push(43);
		System.out.println(myStack.peek());
		int stackOutput = myStack.pop();
		myStack.push(-76321);
		myStack.push(56 % 17);
		
		if (myStack.peek() == 5){
			stackOutput = myStack.pop();
		}
		
		myStack.push(34);
		System.out.println(myStack.pop());
		System.out.print(stackOutput);
		myStack.push(-17);
		myStack.push(7);
		stackOutput = 378923;
		System.out.println(myStack.pop());
		System.out.println(myStack.peek());
		
	}
}
