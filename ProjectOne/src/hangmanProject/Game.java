package hangmanProject;

//import utilities
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	// initialize variables
	Scanner sc = new Scanner(System.in);
	int numTries;
	int numSpaces;
	String secretWord;
	String solvedWord;
	String tempSolvedWord;
	
	// game constructor
	public Game(int tries, int spaces, String word) {
		
		// assign variable values
		numTries = tries;
		numSpaces = spaces;
		secretWord = word;
		
		// create solvedWord with dashes to display
		char[] chars = new char[word.length()];
		Arrays.fill(chars, '-');
		solvedWord = new String(chars);
	}
	
	
	// getNumTries - getter for numTries
	public int getNumTries() {
		return numTries;
	}
	
	// getNumSpaces - getter for numSpaces
	public int getNumSpaces() {
		return numSpaces;
	}
	
	// getSecretWord - getter for secret word
	public String getSecretWord() {
		return secretWord;
	}
	
	// getSolvedWord - getter for solved word
	public String getSolvedWord() {
		return solvedWord;
	}
	
	
	
	
	// checkGuess - determine if useGuess is in the chosen word slots. 
	public boolean checkGuess(String guess, ArrayList<Integer> slots) {
		boolean isTrue = false;
		
		// loop iterates over each value in slots ArrayList
		for (int i = 0; i < slots.size(); i++) {
			int slot = slots.get(i).intValue();
			
			// check that length of secretWord is not exceeded
			if (slot > secretWord.length()) {
				continue;
			}
			
			// check if user guess matches the character in the secretWord
			if (secretWord.substring(slot, slot + 1).equals(guess)) {
				isTrue = true;

				updateSolvedWord(guess, slot);
			}
		}
			
		// if true, print statement of success
		if (isTrue) {
			System.out.println("Your guess is in the word! ");	
			System.out.println("The updated word is: " + solvedWord);
		}
		
		// if guess is incorrect in every slot, reduce numTries and print statement. 
		if (isTrue == false) {
					
			numTries--;
			System.out.println("Your letter was not found in the spaces you provided.");
		}
		
		// print current number of tries remaining.
		System.out.println("Guesses Remaining: " + numTries);
		return isTrue;
	}
	
	// guesses - getter for numTries
	public int guesses() {
		return numTries;
	}
	
	// updateSolvedWord - update contents of string displayed to user. 
	private void updateSolvedWord(String replacement, int pos) {
		solvedWord = solvedWord.substring(0,pos) + replacement + solvedWord.substring(pos + 1, solvedWord.length());
	}
	
	// solve - checks if user's attempted solution is correct.
	public boolean solve(String solution) {
		if (solution.equals(secretWord)) {
			return true;
		}
		else {
			numTries--;
			System.out.println("That is not the secret word");
			System.out.println("Guesses Remaining: " + numTries);
			return false;
		}
	}
	
	// playAgain - asks user to play again and returns yes or no. 
	public boolean playAgain() {
		System.out.println("Would you like to play again? Yes (y) or No(n) ");
		String playAgain = sc.nextLine();
		
		if (playAgain.equals("n")) {
			System.out.println("Goodbye...");
			return false;
		}
		else {
			return true;
		}
	}
	
	// guessedEveryLetter - checks if each letter in word has been guessed correctly.
	public boolean guessedEveryLetter() {
		if (secretWord.equals(solvedWord)) {
			return true;
		}
		else {
			return false;
		}
	}
}
