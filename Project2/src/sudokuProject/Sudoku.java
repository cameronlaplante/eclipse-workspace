package sudokuProject;

import java.util.Arrays;

public class Sudoku {
	
	//set length of one side to static variable. 
	static int length = 9;
	
	//generate puzzle to solve
	static char[][] puzzle = SudokuP.puzzle();
	
	
	// ---------------------------------------------------------------
	// checks validity of entire puzzle in current state (solved or unsolved)
	// ---------------------------------------------------------------
	public static boolean check(char[][] puzzle) {
		
		//create boolean array to return whether a duplicate exists in row/column/grid
		boolean[] noDuplicate = new boolean[length+1];
		
		//row check
		for(int i = 0; i < length; i++) {
			
			//set to false before iteration
			Arrays.fill(noDuplicate, false);
			//iterate over each element in given row
			for (int j = 0; j < length; j++) {
				//var to hold current value at specified index. 
				int val = puzzle[i][j];
				//check if duplicates found
				if (noDuplicate[val]) {
					return false;
				}
				noDuplicate[val] = true;
			}
		}
		
		//column check
		for(int i = 0; i < length; i++) {
			//set to false before iteration
			Arrays.fill(noDuplicate, false);
			//iterate over every element in given column
			for (int j = 0; j < length; j++) {
				//var to hold current value at specified index.
				int val = puzzle[j][i];
				//check if duplicates found
				if (noDuplicate[val]) {
						return false;
				}
				noDuplicate[val] = true;
			}
		}
		
		//3X3 check (one at a time)
		for(int i = 0; i < length-2; i += 3) {
			for(int j = 0; j < length-2; j += 3) {
				//set to false before iteration
				Arrays.fill(noDuplicate, false);
				//current 3X3
				for(int a = 0; a < 3; a++) {
					for(int b = 0; b < 3; b++) {
						
						//vars to hold current position at specified indexes
						int curRow = i + a;
						int curCol = j + b;
						
						//var to hold current value of specified position
						int val = puzzle[curRow][curCol];
						
						//check if duplicates found
						if (noDuplicate[val]) {
							return false;
						}
						noDuplicate[val] = true;
					}
				}
			}
		}
		//if all return true -> return true overall.
		return true;	
	}
	
	// ---------------------------------------------------------------
	// checks if specific num is in row
	// ---------------------------------------------------------------
	public static boolean curInRow(int row, int cur) {
		for(int i=0; i < length; i++) {
			if(puzzle[row][i] == cur) {
				return true;
			}
		}
		return false;
	}
	
	// ---------------------------------------------------------------
	// checks if specific num is in colum
	// ---------------------------------------------------------------
	public static boolean curInCol(int col, int cur) {
		for(int i=0; i < length; i++) {
			if(puzzle[i][col] == cur) {
				return true;
			}
		}
		return false;
	}
	
	// ---------------------------------------------------------------
	// checks if specific num is in 3X3
	// ---------------------------------------------------------------
	public static boolean curInGrid (int row, int col, int cur) {
		
		int curRow = row - row%3;
		int curCol = col - col%3;
		
		for(int i = curRow; i < curRow + 3; i++) {
			for(int j = curCol; j < curCol + 3; j++) {
				if(puzzle[i][j] == cur) {
					return true;
				}
			}
		}
		return false;
	}
	
	// ---------------------------------------------------------------
	// determines if specific number satisfies conditions in index
	// ---------------------------------------------------------------
	public static boolean satisfies(int row, int col, int cur) {
		
		return !(curInRow(row, cur) || curInCol(col, cur) || curInGrid(row, col, cur));
		
//		if (!curInRow(row, cur) || !curInCol(col, cur) || !curInGrid(row, col, cur)){
//			return false;
//		}
//		else {
//			return true;
//		}
	}
	
	
	// ---------------------------------------------------------------
	// solve the sudoku automatically
	// ---------------------------------------------------------------
	public static boolean solve(char[][] puzzle) {
		
		//traverse each element in each row
		for (int row = 0; row <= 9; row++ ) {
			for (int col = 0; col <= 9; col++) {
				
				//if the specified index is empty, solve it.
				if (puzzle[row][col] == '.') {
					//check each possible number (1-9)
					for (int num = 1; num <= 9; num++) {
						
						if (satisfies(row, col, num)) {
							puzzle[row][col] = (char) num;
							
							if (solve(puzzle)) {
								return true;
							}
							else {
								puzzle[row][col] = '.';
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	
	// ---------------------------------------------------------------
	// prints puzzle to screen in current state. 
	// ---------------------------------------------------------------
	private static void printPuzzle(char[][] puzzle) {
		for (int row = 0; row < length; row++) {
			for (int col = 0; col < length; col++) {
				System.out.print(puzzle[row][col] + " ");
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
		System.out.println();
		
//		boolean valid = check(puzzle);
//		System.out.println(valid);
		
		solve(puzzle);
		printPuzzle(puzzle);

	}
	
}
