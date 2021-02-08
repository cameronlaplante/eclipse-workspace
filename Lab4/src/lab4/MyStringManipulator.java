package lab4;

/*----------------------------------------------------------
author: Cameron LaPlante
course: CSCI 145
project: lab4 - string manipulator 
Collaboration statement: By submitting this assignment,
I am attesting that this homework is in full compliance 
with the course's Homework Collaboration Policy and with 
all the other relevant academic honesty policies of the 
course and university. I discussed this homework with no one
and wrote this solution without input from anyone else.
------------------------------------------------------------*/

//import scanner
import java.util.Scanner;

public class MyStringManipulator {

	public static void main (String[] args) {
		//initialize scanner and create variables. 
		Scanner sc = new Scanner(System.in);
		String userString = "";
		String userCommand = "";
		
		//receive string input from user. 
		System.out.println("Enter the string to be manipulated");
		userString = sc.nextLine();
		
		//while loop continues until user selects quit. 
		while (userCommand.toLowerCase() != "quit") {
		
			//Ask user for command
			System.out.println("Enter your command - (quit, print reverse, replace all, replace single, remove)");
			userCommand = sc.nextLine(); 
			
			//Check that user wants to continue
			if (userCommand.toLowerCase().equals("quit")) {
				System.out.println("goodbye!");
				break;
			}
			//if block for executing command type.
			else if (userCommand.toLowerCase().equals("print reverse")) {
				//invoke method
				printReverse(userString);
				continue;
			}
			else if (userCommand.toLowerCase().equals("replace all")) {
				//take input for char to be replaced and replacement
				System.out.println("Enter the character to replace ");
				String replaceChar = sc.nextLine();
				System.out.println("Enter the new character ");
				String newChar = sc.nextLine();
				//invoke method 
				userString = replaceAll(userString, replaceChar, newChar);
				continue;
			}
			else if (userCommand.toLowerCase().equals("replace single")) {
				//take input for char to be replace and replacement
				System.out.println("Enter the character to replace ");
				String replaceChar = sc.nextLine();
				System.out.println("Enter the new character ");
				String newChar = sc.nextLine();
				//invoke method
				userString = replaceSingle(userString, replaceChar, newChar);
				continue;
			}
			else if (userCommand.toLowerCase().equals("remove")) {
				//take user input for character to be removed
				System.out.println("Enter the character to remove");
				String removeChar = sc.nextLine();
				//invoke method
				userString = remove(userString, removeChar);
				continue;
			}
			else {
				System.out.println("Error: Operation not recognized.");
			}
		}
		//close scanner
		sc.close();
	}
	
	
	// ---------------------------------------------------------
	// printReverse - print reverse of original string
	// ---------------------------------------------------------
	public static void printReverse(String userString) {
		//create new reversed string
		String reverse = "";
		//for loop writes each character of userString to reverse. 
		for(int i = userString.length()-1; i>=0; i--) {
			reverse = reverse + userString.charAt(i);
		}
		System.out.println("Your new sentence is:" + reverse);
	}
	// ---------------------------------------------------------
	// replaceAll - replace all instances of character
	// ---------------------------------------------------------
	public static String replaceAll(String userString, String replaceChar, String newChar) {
		if(userString.contains(replaceChar)) {
			userString = userString.replaceAll(replaceChar, newChar);
			System.out.println("Your new sentence is: " + userString);
		}
		else {
			System.out.println("Error: The input sentence does not contain the given character.");
		}
		return userString;
	}
	// ---------------------------------------------------------
	// replaceSingle - replace one instance of character
	// ---------------------------------------------------------
	public static String replaceSingle(String userString, String replaceChar, String newChar) {
		if(userString.contains(replaceChar)) {
			userString = userString.replaceFirst(replaceChar, newChar);
			System.out.println("Your new sentence is:" + userString);
		}
		else {
			System.out.println("Error: The input sentence does not contain the given character.");
		}
		return userString;
	}
	// ---------------------------------------------------------
	// remove - remove specified character 
	// ---------------------------------------------------------
	public static String remove(String userString, String removeChar) {
		if(userString.contains(removeChar)) {
			userString = userString.replaceAll(removeChar, "");
			System.out.println("Your new sentence is:" + userString);
		}
		else {
			System.out.println("Error: The input sentence does not contain the given character.");
		}
		return userString;
	}
}