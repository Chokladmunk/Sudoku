package model;

public class SudokuModel {
	
	private int[][] sudokuMatrix;
	
	public SudokuModel() {
		sudokuMatrix = new int[9][9];
	}
	
	/** 
	 * Method called when "Solve"-button is pressed
	 * @return true if there is a solution
	 * */
	public boolean solveMatrix() {
		return solve(0,0);
	}
	private boolean solve(int col, int row) {
		if(col == 9) {
			col = 0;
			row++;
		}
		if(row == 9) {
			return true;
		}
		// If box is empty
		if(sudokuMatrix[row][col] == 0) {
			for(int i = 1; i<=9; i++) {
				if(checkAvailability(col,row,i)) {
					sudokuMatrix[row][col] = i;
					if(solve(col+1, row)) {
						return true;
					}
					sudokuMatrix[row][col] = 0;
				}
			}
			return false;
		} else {			
			// If box is not empty
			return solve(col+1, row);
		}
	}
	private boolean checkValidInput(int col, int row, int input) {
		return input>0 && input<10 && checkAvailability(col, row, input);
	}
	private boolean checkAvailability(int col, int row, int value) {
		for(int i = 0; i<9; i++) {
			if((value == sudokuMatrix[row][i] && i != col) || (value == sudokuMatrix[i][col] && i != row)) {
				return false;
			}
		}
		return checkQuadrant(col, row, value);
	}
	private boolean checkQuadrant(int col, int row, int value) {
		int xQuad = (row/3) * 3;
		int yQuad = (col/3) * 3;
		for(int rowIndex = 0; rowIndex < 3; rowIndex++) {
			for(int colIndex = 0; colIndex < 3; colIndex++) {
				if(sudokuMatrix[xQuad+rowIndex][yQuad+colIndex] == value && !(rowIndex == row && colIndex == col)) {
					return false;
				}
			}
		}
		return true;
	}
	
	/** 
	 * Set a value 1-9 at row row and col col in the Sudoku Matrix. 
	 * @param row represents the row in the matrix
	 * @param col represents the col in the matrix
	 * @param value is an integer between 1-9
	 * @return true if the insert was successful
	 * */
	public boolean setValue(int col, int row, int value) {
		if(value<10 && value>0) {
			sudokuMatrix[row][col] = value;
			return true;
		}
		return false;
	}
	
	/** 
	 * Returns the value at row row and col col in the Sudoku Matrix. 
	 * @param row represents the row in the matrix
	 * @param col represents the col in the matrix
	 * @return 0 if empty, else the value
	 * */
	public int getValue(int col, int row) {
		return sudokuMatrix[row][col];
	}
	
	/** 
	 * Clears the Sudoku Board. 
	 * */	
	public void clear() {
		sudokuMatrix = new int[9][9];
	}
	
	public String printSudoku() {
		StringBuilder sb = new StringBuilder();
		for(int row = 0; row<9; row++) {
			for(int col = 0; col<9; col++) {
				sb.append(sudokuMatrix[row][col] + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
