package lab3;

//import scanner
import java.util.Scanner;

public class Summation {
	
	//main function
	public static void main(String[] args) {
		//invoke sumIntegers
		sumIntegers();
	}
	
	// ---------------------------------------------------------
	//sumIntegers - takes input from user and produces summation
	// ---------------------------------------------------------
	public static void sumIntegers() {
		//Initialize scanner and variables for summation
		Scanner sc = new Scanner(System.in);
		int total = 0;
		int i=0;
		int currentUserInt;
		
		//take user input for num integers 
		System.out.print("How many integers will be summed? ");
		int numInts = sc.nextInt();
		
		//while loop to sum user inputs
		while (i < numInts) {
			System.out.print("Enter an integer: ");
			currentUserInt = sc.nextInt();
			total = (total + currentUserInt);
			i = i + 1;
		}
		//print total summation and close scanner. 
		System.out.println("The Summation is: " + total);
		sc.close();
	}
}