package hangmanProject;

/*----------------------------------------------------------
 * author: Cameron LaPlante
 * course: CSCI 145
 * project: Project1 
 * Collaboration statement: By submitting this assignment,
 * I am attesting that this homework is in full compliance
 * with the course's Homework Collaboration Policy and with
 * all the other relevant academic honesty policies of the
 * course and university. I discussed this homework with no 
 * one and wrote this solution without input from anyone else.
 *------------------------------------------------------------*/

// import utilities
import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {

	// testingMode boolean for testing
	private static final boolean testingMode = true;
	
	public static void main(String[] args) {
		
		// initialize scanner and variables
		Scanner sc = new Scanner(System.in);
		String diffLevel = "";
		Game g = null;
		boolean win = false;
		boolean run = true;
		
		while (run == true) {
			
			// take user input for difficulty
			System.out.println("Enter your difficulty: Easy (e), Intermediate (i), Hard (h)");
			diffLevel = sc.nextLine();
			diffLevel = diffLevel.substring(0, 1);

			// case statement for game difficulty
			switch (diffLevel){
				case "e":
					g = new Game(15, 4, RandomWord.newWord());
					break;
				case "i":
					g = new Game(12, 3, RandomWord.newWord());
					break;
				case "h":
					g = new Game(10, 2, RandomWord.newWord());
					break;
				default:
					System.out.println("Difficulty level not valid. Try Again...");
					continue;
			}
			// print secret word for testing
			if (testingMode) {
				System.out.println("The secret word is: " + g.getSecretWord());
				
			}
			
			// print dashed word to screen
			System.out.println("The word is: " + g.getSolvedWord());
			
			while (g.guesses() > 0 && !win) {
				
				
				// prompt user for guess and spaces
				System.out.println("Please enter the letter you want to guess: ");
				String userGuess = sc.nextLine();
			//	String userGuess = sc.nextLine().substring(0, 0+1);
				
				// check that user input for guess is valid
				boolean shouldContinue = false;
				for (int i = 0; i < userGuess.length(); i++) {
					if ((Character.isLetter(userGuess.charAt(i)) == false)) {
						System.out.println("Input invalid. Try again.");
						System.out.println("Guesses remaining: " + g.getNumTries());
						shouldContinue = true;
					}
				}
				if (shouldContinue == true) {
					continue;
				}
				
				
				// if user requests to solve, check the guess against secret word and set boolean win
				if (userGuess.toLowerCase().equals("solve")) {
					System.out.println("Please solve the word: ");
					String solutionGuess = sc.nextLine();
					win = g.solve(solutionGuess);
					
					if (win) {
						System.out.println("You win!");
						run = g.playAgain();
						break;
					}
					else {
						continue;
					}
				}
				
				// any input other than "solve" leads to checking spaces
				else {
					userGuess = userGuess.substring(0, 0+1);
					
					System.out.println("Please enter the spaces you want to check (separated by spaces): ");
					String spaces = sc.nextLine();
			
					ArrayList<Integer> slotsList = new ArrayList<Integer>();
					
					// loop through each element in spaces and create substring of integers
					for (int i=0; i < spaces.length(); i++) {
						spaces = spaces.replaceAll(" ", "");
						String sub = spaces.substring(i, i+1);
						int c = Integer.parseInt(sub);
						slotsList.add(Integer.valueOf(c));
					}
					
					// check that length of slots list equals parameters of difficulty level.
					if (slotsList.size() != g.getNumSpaces()) {
						System.out.println("Your input is not valid. Try again.");
						System.out.println("Guesses remaining: " + g.getNumTries());
						continue;
					}
					
					// pass slotsList and guess to checkGuess
					g.checkGuess(userGuess, slotsList);
				} 
				
				// check if all letters have been guessed correct
				if (g.guessedEveryLetter()) {
					System.out.println("You have guessed the word! Congratulations");
					run = g.playAgain();;
					break;
				}
			}
			
			// if out of guesses, ask to play again
			if (g.guesses() == 0) {
				System.out.println("You have failed to guess the word... :(");
				run = g.playAgain();
			}
		}
		// close scanner
		sc.close();
	}	
}
