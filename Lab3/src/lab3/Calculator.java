package lab3;

import java.util.Scanner;

public class Calculator {
	
	// ---------------------------------------------------------
	// main - take user input and call appropriate methods
	// ---------------------------------------------------------
	public static void main(String[] args) {
		//initialize scanner and operation variable
		Scanner sc = new Scanner(System.in);
		String userOperation = "";
		
		//while loop continues until user selects quit. 
		while (userOperation.toLowerCase() != "q") {
			//Ask user for operation type
			System.out.print("Please enter an operation - (A)ddition, (S)ubtraction, (M)ultiplication, (D)ivision, (Q)uit: ");
			userOperation = sc.next();
			
			//Check that user wants to continue
			if (userOperation.toLowerCase().equals("q")) {
				System.out.println("goodbye...");
				break;
			}
			
			//take input for both numbers
			System.out.print("Enter the first operand: ");
			double firstNum = sc.nextDouble();
			System.out.print("Enter the second operand: ");
			double secondNum = sc.nextDouble();
			
			//if block for executing operation type
			if (userOperation.toLowerCase().equals("a")) {
				add(firstNum, secondNum);
			}
			else if (userOperation.toLowerCase().equals("s")) {
				subtract(firstNum, secondNum);
			}
			else if (userOperation.toLowerCase().equals("m")) {
				multiply(firstNum, secondNum);
			}
			else if (userOperation.toLowerCase().equals("d")) {
				divide(firstNum, secondNum);
			}
			else {
				System.out.println("Operation not recognized.");
			}
		}	
		//close scanner
		sc.close();
	}
	
	// ---------------------------------------------------------
	// add - computes summation of two doubles 
	// ---------------------------------------------------------
	public static void add(double x, double y) {
		double solution = (x + y);
		System.out.println(String.format("%.2f",x) + " + " + String.format("%.2f",y) + " = " + String.format("%.2f",solution));
	}
	// ---------------------------------------------------------
	// subtract - computes subtraction of two doubles 
	// ---------------------------------------------------------
	public static void subtract(double x, double y) {
		double solution = (x - y);
		System.out.println(String.format("%.2f",x) + " - " + String.format("%.2f",y) + " = " + String.format("%.2f",solution));
	}
	// ---------------------------------------------------------
	// multiply - computes multiplication of two doubles
	// ---------------------------------------------------------
	public static void multiply(double x, double y) {
		double solution = (x * y);
		System.out.println(String.format("%.2f",x) + " * " + String.format("%.2f",y) + " = " + String.format("%.2f",solution));
	}
	// ---------------------------------------------------------
	// divide - compute division of two doubles 
	// ---------------------------------------------------------
	public static void divide(double x, double y) {
		double solution = (x / y);
		System.out.println(String.format("%.2f",x) + " / " + String.format("%.2f",y) + " = " + String.format("%.2f",solution));
	}
}