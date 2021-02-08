package lab3;

//import scanner
import java.util.Scanner;

public class SmallestDouble {

	//main function 
	public static void main(String[] args) {
		//invoke findSmallestDouble
		findSmallestDouble();
	}
	// ---------------------------------------------------------
	// findSmallestDouble - takes input from user and identifies
	// smallest double number
	// ---------------------------------------------------------
	public static void findSmallestDouble() {
		//initialize scanner and variables.
		Scanner sc = new Scanner(System.in);
		int i = 0;
		double userDouble;
		
		//take input for how many doubles 
		System.out.print("How many doubles will be entered? ");
		double numDoubles = sc.nextDouble();
	 
		//take input for initial double
		System.out.print("Enter a number: ");
		userDouble = sc.nextDouble();
		double smallest = userDouble;
		
		//take input for all consecutive doubles
		while (i < numDoubles - 1) {
			System.out.print("Enter a number: ");
			userDouble = sc.nextDouble();
			
			//if statement to re-assign smallest 
			if (smallest > userDouble) {
				smallest = userDouble;
			}
			//increase counter by 1 
			i = i + 1;
		}
		//print smallest output and close scanner. 
		System.out.println("The smallest double is: " + smallest);
		sc.close();
	}
}