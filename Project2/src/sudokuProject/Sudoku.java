package sudokuProject;

public class Sudoku {
	
	//set length of one side to static variable. 
	static int length = 9;
	
	//generate puzzle to solve
	static char[][] puzzle = SudokuP.puzzle();
	
	// ---------------------------------------------------------------
	// check for duplicates
	// ---------------------------------------------------------------
	private static boolean arrayDupe(char[] dupe) {
		
		for(int j = 0; j < dupe.length; j++) {
			
//			System.out.println("------");
		
			for(int k = 0; k < dupe.length; k++) {
				
//				if (j != k) {
//					System.out.print("dupe j and k values: " + dupe[j] + " " + dupe[k] + "\n");
//				}
				if(k!=j && (int) dupe[k] == (int) dupe[j]) {
					if (dupe[j] == '.' && dupe[k] == '.') {
						continue;
					}
					System.out.println("comparison (j,k): " + "j: " + j + " k: "+ k + " ( " + dupe[j] + " ) ( " + dupe[k] + " )");
					return true;
				}
			}
		}
		return false;
	}
	
	
	// ---------------------------------------------------------------
	// checks validity of entire puzzle in current state (solved or unsolved)
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
			
			//iterate over every element in given column
//			System.out.println("puzzle[row][" + col + "]: ");
			for (int row = 0; row < puzzle.length; row++) {
//				System.out.print(puzzle[row][col]+ "\n");
				colDupe[row] = puzzle[row][col];
				
			}
//			System.out.println("Values of colDupe: ");
//			System.out.println(colDupe);
			
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
		//if all return true -> return true overall.
		return true;	
	}
	// ---------------------------------------------------------------
	// checks if specific num is in row
	// ---------------------------------------------------------------
	public static boolean curInRow(int row, int cur) {
		
//		System.out.println("current val: " + cur);

		String stringCur = Integer.toString(cur);
		for(int i=0; i < puzzle.length; i++) {
//			System.out.println("current index val: " + puzzle[row][i]);
			
			if(puzzle[row][i] ==  stringCur.toCharArray()[0]) {
				return true;
			}
		}
		return false;
	}
	
	// ---------------------------------------------------------------
	// checks if specific num is in colum
	// ---------------------------------------------------------------
	public static boolean curInCol(int col, int cur) {
		String stringCur = Integer.toString(cur);
		char charCur = stringCur.toCharArray()[0];
		for(int i=0; i < puzzle.length; i++) {
			
			char c = puzzle[i][col];
			if(c == charCur) {
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
				
				String stringCur = "" + cur;
				if(puzzle[i][j] == stringCur.toCharArray()[0]) {
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
		
		boolean rowTrue = curInRow(row, cur);
		boolean colTrue = curInCol(row, cur);
		boolean gridTrue =curInGrid(row, col, cur);
		
//		System.out.println("row true: "+rowTrue);
//		System.out.println("col true: "+colTrue);
//		System.out.println("grid true:"+gridTrue);
//		System.out.println("_______");
		
		if (rowTrue){
			return false;
		}
		if (colTrue){
			return false;
		}
		if (gridTrue){
			return false;
		}
		return true;
		
	}
	
	//---------------------------------------------------------------
	// return next empty slot in puzzle
	//---------------------------------------------------------------
	public static int[] emptySlot(char[][] puzzle2) {
		int[] fp = new int[2];
		
		fp[0] = -1;
		fp[1] = -1;
		
		for(int row = 0; row < puzzle2.length; row++) {
			for (int col = 0; col < puzzle2.length; col++) {
				if (puzzle2[row][col] == '.') {
					fp[0] = row;
					fp[1] = col;
					return fp;
				}
			}
		}
		return fp;
	}
	
	// ---------------------------------------------------------------
	// solve the sudoku automatically
	// ---------------------------------------------------------------
	public static boolean solve(char[][] puzzle) {
		
		boolean satisfied = false;
		
		int[] fp = emptySlot(puzzle);
		if (fp[0] == -1) {
			return true;
		}
		
		int row = fp[0];
		int col = fp[1];

		//check each possible number (1-9)
		for (int num = 1; num <= 9; num++) {
//			System.out.println("Satisfies: " + satisfies(row, col, num));
			satisfied = satisfies(row, col, num);
			if (satisfied) {
				String stringNum = Integer.toString(num);
				puzzle[row][col] = stringNum.toCharArray()[0];
				boolean check = solve(puzzle);
				if(check == true) {
					return true;
				}
				puzzle[row][col] = 0;
				
//				System.out.println(puzzle[row][col]);
//				System.out.println("assign puzzle to cur num: " + puzzle[row][col]);
			}
		}
//		if (!satisfied) {
//			puzzle[row][col] = '-';
//		}
//			System.out.println(" ");
		return false;
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
		
//		boolean rowTrue = curInRow(1, 1);
//		System.out.println("first num of first row equals 1: " + rowTrue);
		
		if(check(puzzle)) {
			solve(puzzle);
			System.out.println("Solved Puzzle: ");
			printPuzzle(puzzle);
		}

	}
	
}
