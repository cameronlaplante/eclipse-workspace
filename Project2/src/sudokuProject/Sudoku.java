package sudokuProject;

/* 
 * Author: Cameron LaPlante 
 * Course: CS 145 
 * Assignment: Project 2 
 * Collaboration statement: By submitting this assignment, I am attesting 
 * that this homework is in full compliance with the course's Homework 
 * Collaboration Policy and with all the other relevant academic honesty 
 * policies of the course and university. I discussed this homework with 
 * no one and wrote this solution without input from anyone else.
 */

import java.util.HashMap;

public class Sudoku {
	
	//generate puzzle to solve
	static char[][] puzzle = SudokuP.puzzle();
	
	// ---------------------------------------------------------------
	// arrayDupe - check for duplicates in check method
	// ---------------------------------------------------------------
	private static boolean arrayDupe(char[] dupe) {
		
		//double for loop iterates over each element. 
		for(int j = 0; j < dupe.length; j++) {
			for(int k = 0; k < dupe.length; k++) {
				//determine if duplicate is found
				if(k!=j && (int) dupe[k] == (int) dupe[j]) {
					if (dupe[j] == '.' && dupe[k] == '.') {
						continue;
					}
					return true;
				}
			}
		}
		return false;
	}
	
	// ---------------------------------------------------------------
	// check - check validity of entire puzzle in current state 
	// ---------------------------------------------------------------
	public static boolean check(char[][] puzzle) {
		
		//create boolean array to return whether a duplicate exists in row/column/grid
		char[] colDupe = new char[9];
		
		//check for duplicates in row
		for(int i = 0; i < puzzle.length-1; i++) {
			//call arrayDupe to set boolean 
			boolean duplicate = arrayDupe(puzzle[i]);
			//if duplicate found, print statement to user
			if(duplicate) {
				System.out.println("duplicate found on row: " + i);
				return false;
			}
		}
		
		//check for duplicates in column
		for(int col = 0; col < puzzle.length; col++) {
			for (int row = 0; row < puzzle.length; row++) {
				colDupe[row] = puzzle[row][col];	
			}
			//call arrayDupe to set boolean 
			boolean duplicate = arrayDupe(colDupe);
			//if duplicate found, print statement to user
			if(duplicate) {
				System.out.println("duplicate found on col: " + col);
				return false;
			}
		}
		
		//Check each 3X3 grid for duplicates
		for(int gridX = 0; gridX < 7; gridX += 3 ) {
			for( int gridY = 0; gridY < 7; gridY += 3) {
				//Initialize char array and counter. 
				char[] gridDupe = new char[9];
				int count = 0;
				//iterate over each element in current 3X3 
				for(int col = gridX; col < (3 + gridX); col++) {
					for(int row = gridY; row < (3 + gridY); row++) {
						char curPuzzleIndex = puzzle[row][col];
						//add value to array and increase count. 
						gridDupe[count] = curPuzzleIndex;
						count++;
					}
				}
				//call arrayDupe with array gridDupe 
				boolean duplicate = arrayDupe(gridDupe);
				//if found, print and return false
				if(duplicate) {
					System.out.println("duplicate found in grid");
					return false;
				}
			}
		}
		//if no duplicates, return true
		return true;	
	}
	
	// ---------------------------------------------------------------
	// curInRow - checks if specific number is in row
	// ---------------------------------------------------------------
	public static boolean curInRow(char[][] puzzle, int row, int cur) {

		//iterate over each element in given row
		for(int i=0; i < puzzle.length; i++) {
			//if duplicate is found return true
			if(puzzle[row][i] ==  Integer.toString(cur).toCharArray()[0]) {
				return true;
			}
		}
		return false;
	}
	
	// ---------------------------------------------------------------
	// curInCol - checks if specific number is in column
	// ---------------------------------------------------------------
	public static boolean curInCol(char[][] puzzle, int col, int cur) {
		
		//iterate over each element in column
		for(int i=0; i < puzzle.length; i++) {
			//if duplicate is found return true
			if(puzzle[i][col] == Integer.toString(cur).toCharArray()[0]) {
				return true;
			}
		}
		return false;
	}
	
	// ---------------------------------------------------------------
	// curInGrid - checks if specific number is in 3X3
	// ---------------------------------------------------------------
	public static boolean curInGrid (char[][] puzzle, int row1, int col1, int cur) {
		
		//for each box (begins at first element in box.}
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				//if a duplicate is found in any element of grid, return true
				if(puzzle[row + row1][col + col1] == cur) {
					return true;
				}
			}
		}
		return false;
	}
	
	// ---------------------------------------------------------------
	// satisfies - determines if specific number satisfies all conditions for position
	// ---------------------------------------------------------------
	public static boolean satisfies(char[][] puzzle, int row, int col, int cur) {
		
		//Set three booleans to outputs of check methods for row, column, and 3X3s
		boolean rowTrue = curInRow(puzzle, row, cur);
		boolean colTrue = curInCol(puzzle, col, cur);
		boolean gridTrue =curInGrid(puzzle, row - row % 3, col - col % 3, cur);
		
		//return the result of the combined boolean outputs. 
		return (!colTrue && !rowTrue && !gridTrue);
		
	}
	
	//---------------------------------------------------------------
	// emptySlot - return next empty slot in puzzle to be solved
	//---------------------------------------------------------------
	public static HashMap<String, Integer> emptySlot(char[][] puzzle) {
		
		//Initialize hashmap 
		HashMap<String, Integer> slot = new HashMap<>();
		//add initial values to Hashmap 
		slot.put("row", -1);
		slot.put("col", -1);
		//iterate over each element in the puzzle 
		for(int row = 0; row < puzzle.length; row++) {
			for (int col = 0; col < puzzle.length; col++) {
				//if a slot containing a '.' is found, return that index. 
				if (puzzle[row][col] == '.') {
					slot.put("row", row);
					slot.put("col", col);
					return slot;
				}
			}
		}
		//otherwise, puzzle is solved. return initial values. 
		return slot;
	}
	
	// ---------------------------------------------------------------
	// solve - solve the sudoku automatically
	// ---------------------------------------------------------------
	public static boolean solve(char[][] puzzle) {
		
		//initialize hashmap
		HashMap<String, Integer> slot = emptySlot(puzzle);
		//if slot returns with initial value of -1, puzzle is solved. 
		if (slot.get("row") == -1) {
			//print solution
			System.out.println("Game Play: \n");
			printPuzzle(puzzle);
			return true;
		}
		//retrieve values of row and column from hashmap 
		int row = slot.get("row").intValue();
		int col = slot.get("col").intValue();

		//check each possible number (1-9)
		for (int num = 1; num <= 9; num++) {
			//if num is approved in satisfies, set that index to num.
			if (satisfies(puzzle, row, col, num)) {
				puzzle[row][col] = Integer.toString(num).toCharArray()[0];
				
				//recursion to determine if the num previous set works with next.
				boolean check = solve(puzzle);
				if(check == true) {
					return true;
				}
				//if not true, set back to '.' and try next num.
				puzzle[row][col] = '.';
			}
		}
		return false;
	}
	
	// ---------------------------------------------------------------
	// printPuzzle - prints puzzle to screen in current state. 
	// ---------------------------------------------------------------
	private static void printPuzzle(char[][] puzzle) {
		
		//print entire puzzle to screen 
		for (int row = 0; row < puzzle.length; row++) {
			for (int col = 0; col < puzzle.length; col++) {
				System.out.print(" " + puzzle[row][col] + " ");
			}
			System.out.println();
		}
	}
	
	// ---------------------------------------------------------------
	// main - main method to begin program
	// ---------------------------------------------------------------
	public static void main(String[] args) {
		
		//print starting board acquired from SudokuP
		System.out.println("Starting Board: \n");
		printPuzzle(puzzle);
		System.out.println();
		System.out.println("-------------------------- \n");
		
		//if check returns true, execute solve and print solution
		if(check(puzzle)) {
			solve(puzzle);
		}
		else {
			System.out.println("the given sudoku puzzle is invalid");
		}
	}
}
