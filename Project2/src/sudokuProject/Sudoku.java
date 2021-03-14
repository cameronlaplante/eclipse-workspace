package sudokuProject;

import java.util.HashMap;

public class Sudoku {
	
	//set length of one side to static variable. 
//	static int length = 9;
	
	//generate puzzle to solve
	static char[][] puzzle = SudokuP.puzzle();
	
	// ---------------------------------------------------------------
	// arrayDupe - check for duplicates in check method
	// ---------------------------------------------------------------
	private static boolean arrayDupe(char[] dupe) {
		
		for(int j = 0; j < dupe.length; j++) {
			for(int k = 0; k < dupe.length; k++) {
				if(k!=j && (int) dupe[k] == (int) dupe[j]) {
					if (dupe[j] == '.' && dupe[k] == '.') {
						continue;
					}
//					System.out.println("comparison (j,k): " + "j: " + j + " k: "+ k + " ( " + dupe[j] + " ) ( " + dupe[k] + " )");
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
		
		//row check
		for(int i = 0; i < puzzle.length-1; i++) {
			
			boolean duplicate = arrayDupe(puzzle[i]);
			
			if(duplicate) {
				System.out.println("duplicate found on row: " + i);
				return false;
			}
		}
	
		//column check
		for(int col = 0; col < puzzle.length; col++) {
			for (int row = 0; row < puzzle.length; row++) {
				colDupe[row] = puzzle[row][col];	
			}
			boolean duplicate = arrayDupe(colDupe);
			
			if(duplicate) {
				System.out.println("duplicate found on col: " + col);
				return false;
			}
		}
		
		//3X3 check (one at a time)
		for(int gridX = 0; gridX < 7; gridX += 3 ) {
			for( int gridY = 0; gridY < 7; gridY += 3) {
				
				char[] gridDupe = new char[9];
				int count = 0;
				
				for(int col = gridX; col < (3 + gridX); col++) {
					for(int row = gridY; row < (3 + gridY); row++) {
						char curPuzzleIndex = puzzle[row][col];
						gridDupe[count] = curPuzzleIndex;
						count++;
					}
				}
				
				boolean duplicate = arrayDupe(gridDupe);
				if(duplicate) {
					System.out.println("duplicate found in grid");
					return false;
				}
			}
		}
		return true;	
	}
	
	
	// ---------------------------------------------------------------
	// curInRow - checks if specific num is in row
	// ---------------------------------------------------------------
	public static boolean curInRow(char[][] puzzle, int row, int cur) {

		String stringCur = Integer.toString(cur);
		for(int i=0; i < puzzle.length; i++) {
			
			if(puzzle[row][i] ==  stringCur.toCharArray()[0]) {
				return true;
			}
		}
		return false;
	}
	
	// ---------------------------------------------------------------
	// checks if specific num is in colum
	// ---------------------------------------------------------------
	public static boolean curInCol(char[][] puzzle, int col, int cur) {
		
		String stringCur = Integer.toString(cur);
		for(int i=0; i < puzzle.length; i++) {
	
			if(puzzle[i][col] == stringCur.toCharArray()[0]) {
				return true;
			}
		}
		return false;
	}
	
	// ---------------------------------------------------------------
	// checks if specific num is in 3X3
	// ---------------------------------------------------------------
	public static boolean curInGrid (char[][] puzzle, int row1, int col1, int cur) {
		
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				
				if(puzzle[row + row1][col + col1] == cur) {
					return true;
				}
			}
		}
		return false;
	}
	
	// ---------------------------------------------------------------
	// determines if specific number satisfies conditions in index
	// ---------------------------------------------------------------
	public static boolean satisfies(char[][] puzzle, int row, int col, int cur) {
		
		boolean rowTrue = curInRow(puzzle, row, cur);
		boolean colTrue = curInCol(puzzle, col, cur);
		boolean gridTrue =curInGrid(puzzle, row - row % 3, col - col % 3, cur);
		
		return (!colTrue && !rowTrue && !gridTrue);
		
	}
	
	//---------------------------------------------------------------
	// return next empty slot in puzzle
	//---------------------------------------------------------------
	public static HashMap<String, Integer> emptySlot(char[][] puzzle) {
		
		HashMap<String, Integer> slot = new HashMap<>();
		
		slot.put("row", -1);
		slot.put("col", -1);
		
		
		for(int row = 0; row < puzzle.length; row++) {
			for (int col = 0; col < puzzle.length; col++) {
				if (puzzle[row][col] == '.') {
					
					slot.put("row", row);
					slot.put("col", col);
					
					return slot;
					
				}
			}
		}
		return slot;
	}
	
	// ---------------------------------------------------------------
	// solve the sudoku automatically
	// ---------------------------------------------------------------
	public static boolean solve(char[][] puzzle) {
		
//		boolean satisfied = false;
		HashMap<String, Integer> slot = emptySlot(puzzle);
		if (slot.get("row") == -1) {
			return true;
		}
		
		int row = slot.get("row").intValue();
		int col = slot.get("col");

		//check each possible number (1-9)
		for (int num = 1; num <= 9; num++) {

			if (satisfies(puzzle, row, col, num)) {
				puzzle[row][col] = Integer.toString(num).toCharArray()[0];
				
				//TEMP FOR TESTING
//				printPuzzle(puzzle); 
//				System.out.println("-----------------");
				//TEMP FOR TESTING ^^
				
				boolean check = solve(puzzle);
				if(check == true) {
					return true;
				}
				puzzle[row][col] = '.';
			}
		}
		return false;
	}
	
	// ---------------------------------------------------------------
	// prints puzzle to screen in current state. 
	// ---------------------------------------------------------------
	private static void printPuzzle(char[][] puzzle) {
		for (int row = 0; row < puzzle.length; row++) {
			for (int col = 0; col < puzzle.length; col++) {
				System.out.print(" " + puzzle[row][col] + " ");
			}
			System.out.println();
		}
	}
	
	// ---------------------------------------------------------------
	// main 
	// ---------------------------------------------------------------
	public static void main(String[] args) {
		
		System.out.println("Starting Board: ");
		printPuzzle(puzzle);
		System.out.println();
		
		if(check(puzzle)) {
			solve(puzzle);
			System.out.println("Solved Puzzle: ");
			printPuzzle(puzzle);
		}
	}
}
