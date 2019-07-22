/**
 * @author Surender
 *  class NQueen implements functions to check if a solution exists for a n-Queen problem
 *  with different dimensions of the chess board 
 */
public class NQueen {
	int[][] board;
	
	/**
	 * @param board is 2d matrix for storing board
	 * @param row stores current row of matrix at which we are looking to place a queen
	 * @param column stores current column of matrix at which we are looking to place a queen
	 * @param dimensionOfMatrix is the size or dimension of the chess board
	 * @return true if the queen can be successfully placed else return false
	 */
	boolean  isValidToPlaceQueen(int board[][], int row, int column, int dimensionOfMatrix) { 
	     int i, j; 
	     for (i = 0; i < row; i++) { 
	         if (board[i][column] == 1) { 
	             return false;
	         }
	     }
	     for (i = row, j = column; i >= 0 && j >= 0; i--, j--) { 
	         if (board[i][j] == 1) { 
	             return false;
	         }
	     }
	        
	     for (i = row, j = column; i >= 0 && j < dimensionOfMatrix; i--, j++) { 
	    	 if (board[i][j] == 1) { 
	    		 return false;
	    	 }
	     }
	     return true;
	 }
	
	/**
	 * @param board is 2d matrix for storing board
	 * @param startRow stores the row at which we need to place a queen
	 * @param dimensionOfMatrix is the size or dimension of the chess board
	 * @return true if solution exist for n-Queen problem for given dimension else return false
	 */
	boolean nQueen(int[][] board, int startRow, int dimensionOfMatrix) {
		if (startRow >= dimensionOfMatrix) {
			return true;
		}
		
		for (int currentColumn = 0; currentColumn < dimensionOfMatrix; currentColumn++) { 
	        if (isValidToPlaceQueen(board, startRow, currentColumn, dimensionOfMatrix)){ 
	            board[startRow][currentColumn] = 1; 
	                if (nQueen(board, startRow + 1, dimensionOfMatrix)) {
	                	return true; 
	                }
	                board[startRow][currentColumn] = 0;
	        } 
	    } 
		return false;
	}
}
