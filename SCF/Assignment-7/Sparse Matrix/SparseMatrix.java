import java.io.IOException;

/**
 * This class contains methods for operations on sparse matrices
 * @author Surender
 *
 */
public class SparseMatrix {
	private final int[][] SparseMatrix;
	private final int noOfRows;
	private final int noOfColumns;

	/**
	 * This parameterized is constructor used to initialize matrix in reduced form
	 * @param reducedSparseMatrix is a 2d array containing information about nonzero element's row, column and value
	 * @param matrixRow stores number of rows in original matrix
	 * @param matrixColumn stores number of column in original matrix
	 */
	public SparseMatrix(int[][] reducedSparseMatrix, int matrixRow, int matrixColumn) {
		this.SparseMatrix = reducedSparseMatrix;
		this.noOfColumns = matrixRow;
		this.noOfRows = matrixColumn;
	}
	
	/**
	 * This parameterized constructor initializes sparse matrix by storing only non zero element and their row and column
	 * @param matrix is a 2d sparse matrix array
	 */
	public SparseMatrix(int matrix[][]) {
		this.noOfRows = matrix.length;
		this.noOfColumns = matrix[0].length;

		int numberOfNonZeroElements = countNonZeroElementsInSparseMatrix(matrix);
		this.SparseMatrix = new int[numberOfNonZeroElements][3];

		int rowIndex = 0; 
		for (int arrayRowIndex = 0; arrayRowIndex < matrix.length; arrayRowIndex ++) {
			for (int arrayColIndex = 0; arrayColIndex < matrix[0].length; arrayColIndex ++) {
				if (matrix[arrayRowIndex][arrayColIndex] != 0) {
					this.SparseMatrix[rowIndex][0] = arrayRowIndex;
					this.SparseMatrix[rowIndex][1] = arrayColIndex;
					this.SparseMatrix[rowIndex][2] = matrix[arrayRowIndex][arrayColIndex];
					rowIndex++;
				}
			}
		}
	}

	/**
	 * This function counts the non zero elements in the 2d sparse matrix array
	 * @param matrix is a 2d sparse matrix array
	 * @return number of non zero elements in the 2d matrix array
	 */
	private int countNonZeroElementsInSparseMatrix(int[][] matrix) {
		int numberOfNonZeroElement = 0;
		for (int arrayRowIndex = 0; arrayRowIndex < matrix.length; arrayRowIndex ++) {
			for (int arrayColIndex = 0; arrayColIndex < matrix[0].length; arrayColIndex ++) {
				if (matrix[arrayRowIndex][arrayColIndex] != 0) {
					numberOfNonZeroElement++;
				}
			}
		}
		return numberOfNonZeroElement;
	}
	
	/**
	 * This method converts the reduced sparse matrix array to its full size
	 * @return  full size sparse matrix array containing zero element and non zero elements
	 */
	public int[][] getMatrix() {
		int matrix[][] = new int[this.noOfRows][this.noOfColumns];
		
		for (int arrayRowIndex = 0; arrayRowIndex < this.noOfRows; arrayRowIndex ++) {
			for (int arrayColumnIndex = 0; arrayColumnIndex < this.noOfColumns; arrayColumnIndex++) {
				boolean elementFound = false;
				for(int rowIndex =0; rowIndex < this.SparseMatrix.length; rowIndex++) {
					if (this.SparseMatrix[rowIndex][0] == arrayRowIndex && this.SparseMatrix[rowIndex][1] == arrayColumnIndex) {
						elementFound = true;
						matrix[arrayRowIndex][arrayColumnIndex] = this.SparseMatrix[rowIndex][2];
						rowIndex ++;
						break;
					}
				}
					if(!elementFound){
						matrix[arrayRowIndex][arrayColumnIndex] = 0;
					}
			}
		}
		return matrix;
	}
	
	/**
	 * This method sorts the 2d array containing only non zero element according to their stored row and column value
	 * @param matrix is 2d array containing row, column and value of non zero element
	 * @return sorted 2d array containing row, column and value of non zero element
	 */
	private int[][] sortMatrixAccordingToRowColumn(int[][] matrix) {
		for(int firstRowIndex =0; firstRowIndex < matrix.length; firstRowIndex ++) {
			for(int secondRowIndex = (firstRowIndex+1); secondRowIndex < matrix.length; secondRowIndex ++ ) {
				
				if(matrix[firstRowIndex][0] > matrix[secondRowIndex][0]) {
					int tempData = matrix[secondRowIndex][0];
					matrix[secondRowIndex][0] = matrix[firstRowIndex][0];
					matrix[firstRowIndex][0] = tempData;
					
					tempData = matrix[secondRowIndex][1];
					matrix[secondRowIndex][1] = matrix[firstRowIndex][1];
					matrix[firstRowIndex][1] = tempData;
					
					tempData = matrix[secondRowIndex][2];
					matrix[secondRowIndex][2] = matrix[firstRowIndex][2];
					matrix[firstRowIndex][2] = tempData;
				}
			}
		}
		
		for(int firstRowIndex = 0; firstRowIndex < matrix.length; firstRowIndex ++) {
			for(int secondRowIndex = (firstRowIndex+1); secondRowIndex < matrix.length; secondRowIndex ++ ) {
				
				if(matrix[firstRowIndex][0] == matrix[secondRowIndex][0]) {
					if(matrix[firstRowIndex][1] > matrix[secondRowIndex][1]) {
						int tempData = matrix[secondRowIndex][1];
						
						matrix[secondRowIndex][1] = matrix[firstRowIndex][1];
						matrix[firstRowIndex][1] = tempData;
						
						tempData = matrix[secondRowIndex][2];
						matrix[secondRowIndex][2] = matrix[firstRowIndex][2];
						matrix[firstRowIndex][2] = tempData;
					}
				}
			}
		}
		return matrix;
	}
	
	/**
	 * This method is used to find the transpose of a sparse matrix
	 * @return transpose of the sparse matrix 
	 */
	public SparseMatrix getTransposeOfSparseMatrix() {
		int[][] transposeMatrix = new int[this.SparseMatrix.length][3];
		for(int rowIndex = 0; rowIndex < this.SparseMatrix.length; rowIndex ++) {
			transposeMatrix[rowIndex][0] = this.SparseMatrix[rowIndex][1];
			transposeMatrix[rowIndex][1] = this.SparseMatrix[rowIndex][0];
			transposeMatrix[rowIndex][2] = this.SparseMatrix[rowIndex][2];
		}
		transposeMatrix = sortMatrixAccordingToRowColumn(transposeMatrix);
		return new SparseMatrix(transposeMatrix, this.noOfColumns, this.noOfRows);
	}
	
	/**
	 * This method is used to check if the given matrix is symmetrical or not
	 * @return true if matrix is symmetrical else return false
	 */
	public boolean isSparseMatrixSymmetrical(){
		SparseMatrix transposeMatrix = this.getTransposeOfSparseMatrix();
		int counter = 0;
		for(int firstIndex=0; firstIndex < this.SparseMatrix.length; firstIndex++) {
			for(int secondIndex=0; secondIndex < transposeMatrix.SparseMatrix.length; secondIndex++) {
				
				if(this.SparseMatrix[firstIndex][0] == transposeMatrix.SparseMatrix[secondIndex][0] 
						&& this.SparseMatrix[firstIndex][1] == transposeMatrix.SparseMatrix[secondIndex][1] 
								&& this.SparseMatrix[firstIndex][2] == transposeMatrix.SparseMatrix[secondIndex][2]) {
					counter ++;
				}
			}
		}
		if(counter == this.SparseMatrix.length) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method is used to add two sparse matrices
	 * @param matrix is an object of SparseMatrix class containing only non zero element
	 * @return object of SparseMatrix containing only non zero element
	 * @throws IOException throws IO-exception when the size of the two matrices is different
	 */
	public SparseMatrix getAdditionOfTwoSparseMatrix(SparseMatrix matrix) throws IOException {
		if(this.noOfRows != matrix.noOfRows || this.noOfColumns != matrix.noOfColumns) {
			throw new IOException("Addition is not possible");
		}
		
		int sameElementCount = 0;
		for(int firstIndex = 0; firstIndex < this.SparseMatrix.length; firstIndex ++) {
			boolean elementFound = false;
			for(int secondIndex =0; secondIndex < matrix.SparseMatrix.length; secondIndex ++) {
				
				if(this.SparseMatrix[firstIndex][0] == matrix.SparseMatrix[secondIndex][0]) {
					if(this.SparseMatrix[firstIndex][1] == matrix.SparseMatrix[secondIndex][1]) {
						sameElementCount ++;
					}
				}
			}
			
		}
		int[][] sumMatrix = new int[ (this.SparseMatrix.length + matrix.SparseMatrix.length) - sameElementCount ][3];
		int rowIndex = 0;
		for(int firstIndex = 0; firstIndex < this.SparseMatrix.length;firstIndex++) {
			boolean elementFound = false;
			for(int secondIndex =0; secondIndex < matrix.SparseMatrix.length; secondIndex ++) {
				
				if(this.SparseMatrix[firstIndex][0] == matrix.SparseMatrix[secondIndex][0]) {
					if(this.SparseMatrix[firstIndex][1] == matrix.SparseMatrix[secondIndex][1]) {
						sumMatrix[rowIndex][0] = this.SparseMatrix[firstIndex][0];
						sumMatrix[rowIndex][1] = this.SparseMatrix[firstIndex][1];
						sumMatrix[rowIndex][2] = this.SparseMatrix[firstIndex][2] + matrix.SparseMatrix[secondIndex][2];
						rowIndex ++;
						elementFound = true;
					}
				}
			}
			if(!elementFound) {
				sumMatrix[rowIndex][0] = this.SparseMatrix[firstIndex][0];
				sumMatrix[rowIndex][1] = this.SparseMatrix[firstIndex][1];
				sumMatrix[rowIndex][2] = this.SparseMatrix[firstIndex][2]; 
				rowIndex ++;
			}
		}
		
		for(int firstIndex = 0; firstIndex < matrix.SparseMatrix.length; firstIndex ++) {
			boolean elementFound = false;
			for(int secondIndex =0; secondIndex < this.SparseMatrix.length; secondIndex++) {
				if(matrix.SparseMatrix[firstIndex][0] == this.SparseMatrix[secondIndex][0]) {
					if(matrix.SparseMatrix[firstIndex][1] == this.SparseMatrix[secondIndex][1]) {
						elementFound = true;
					}
				}
			}
			if(!elementFound) {
				sumMatrix[rowIndex][0] = matrix.SparseMatrix[firstIndex][0];
				sumMatrix[rowIndex][1] = matrix.SparseMatrix[firstIndex][1];
				sumMatrix[rowIndex][2] = matrix.SparseMatrix[firstIndex][2]; 
				rowIndex++;
			}
		}
		return new SparseMatrix(sumMatrix, this.noOfRows, this.noOfColumns);
		
	}


	/**
	 * This method is used to multiply two sparse matrices
	 * @param matrix is an object of SparseMatrix class containing only non zero element
	 * @return multiplication result of the two Sparse Matrices
	 * @throws IOException throws IO-exception when no of columns of first matrix is not equal to the no of rows of second matrix
	 */
	public SparseMatrix getMultiplicationOfTwoSparseMatrices(SparseMatrix matrix) throws IOException {
		if(this.noOfColumns != matrix.noOfRows){
			throw new IOException("Multiplication is not possible");
		}
		
		int[][] multiplicationMatrix = new int[this.noOfRows][matrix.noOfColumns];
		int sum = 0, firstMatrixElement = 0, secondMatrixElement = 0;
		boolean firstMatrixElementFound = false, secondMatrixElementFound = false;
	
		for (int firstMatricRowIndex = 0; firstMatricRowIndex < this.noOfRows; firstMatricRowIndex ++) {
			for (int secondMatrixColumnIndex = 0; secondMatrixColumnIndex < matrix.noOfColumns; secondMatrixColumnIndex ++) {
				for (int firstMatrixColumnIndex = 0; firstMatrixColumnIndex < this.noOfColumns; firstMatrixColumnIndex ++) {
					
					for (int rowIndex = 0; rowIndex < this.SparseMatrix.length; rowIndex ++) {
						
						if (this.SparseMatrix[rowIndex][0] == firstMatricRowIndex && this.SparseMatrix[rowIndex][1] == firstMatrixColumnIndex) {
							firstMatrixElement = this.SparseMatrix[rowIndex][2];
							firstMatrixElementFound = true;
							break;
						}
					}
					for (int rowIndex = 0; rowIndex < matrix.SparseMatrix.length; rowIndex ++) {
						if (matrix.SparseMatrix[rowIndex][0] == firstMatrixColumnIndex && matrix.SparseMatrix[rowIndex][1] == secondMatrixColumnIndex) {
							secondMatrixElement = matrix.SparseMatrix[rowIndex][2];
							secondMatrixElementFound = true;
							break;
						}
					}
					if (!firstMatrixElementFound) {
						firstMatrixElement = 0;
					}
					if (!secondMatrixElementFound) {
						secondMatrixElement = 0;
					}
					sum = sum + firstMatrixElement * secondMatrixElement;
					firstMatrixElementFound = false;
					secondMatrixElementFound = false;
				}

				multiplicationMatrix[firstMatricRowIndex][secondMatrixColumnIndex] = sum;
				sum = 0;
			}
		}
		return new SparseMatrix(multiplicationMatrix);
	}
}	
	
	
	