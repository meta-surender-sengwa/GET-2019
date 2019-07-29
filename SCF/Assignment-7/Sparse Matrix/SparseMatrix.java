import java.io.IOException;

import org.junit.Test;

/**
 * @author Surender
 *	This class contains methods for operations on sparse matrices
 */
public final class SparseMatrix {
	private int[][] matrix;
	private int[][] sparseMatrix;
	
	SparseMatrix(int[][] array) {
		this.matrix = array; 
	}
	
	private int[][] convertToRepresentation(int[][] array) {
		int numberOfNonZeroElements = countNumberOfNonZeroElements(array);
		int[][] sparseArray = new int[numberOfNonZeroElements][3];
		int index = 0; 
		for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
			for (int columnIndex = 0; columnIndex < matrix[0].length; columnIndex++) {
				if (matrix[rowIndex][columnIndex] != 0) {
					sparseArray[index][0] = rowIndex;
					sparseArray[index][1] = columnIndex;
					sparseArray[index][2] = matrix[rowIndex][columnIndex];
					index++;
				}
			}
		}
		return sparseArray;
	}
	
	private int countNumberOfNonZeroElements(int[][] array) {
		int numberOfNonZeroElement = 0;
		for (int rowIndex = 0; rowIndex < array.length; rowIndex++) {
			for (int columnIndex = 0; columnIndex < array[0].length; columnIndex++) {
				if (array[rowIndex][columnIndex] != 0) {
					numberOfNonZeroElement++;
				}
			}
		}
		return numberOfNonZeroElement;
	}
	
	public int[][] getTransposeMatrix() {
		this.sparseMatrix = convertToRepresentation(this.matrix);;;
		int[][] transposeMatrix = new int[sparseMatrix.length][3];
		for(int index = 0; index < sparseMatrix.length; index++) {
			transposeMatrix[index][0] = sparseMatrix[index][1];
			transposeMatrix[index][1] = sparseMatrix[index][0];
			transposeMatrix[index][2] = sparseMatrix[index][2];
		}
		return transposeMatrix;
	}

	public boolean checkSymmetryOfMatrix() {
		for (int indexI = 0; indexI < this.matrix.length; indexI++) {
			for (int indexJ = 0; indexJ < this.matrix[0].length; indexJ++) {
				if (this.matrix[indexI][indexJ] != this.matrix[indexJ][indexI]) {
					return false;
				}
			}
			
		}
		return true;
	}
	
	public int[][] getSumOfMatrices(int[][] array2) throws IOException {
		if(this.matrix.length != array2.length || this.matrix[0].length != array2[0].length) {
			throw new IOException("Addition is not possible");
		}
		int[][] sumOfMatrices = new int[this.matrix.length][this.matrix[0].length];
		
		for (int indexI = 0; indexI < sumOfMatrices.length; indexI++) {
			for (int indexJ = 0; indexJ < sumOfMatrices[0].length; indexJ++) {
				sumOfMatrices[indexI][indexJ] = this.matrix[indexI][indexJ] + array2[indexI][indexJ];
			}
		}
		return sumOfMatrices;
	}
	
	public int[][] getMultiplicationOfMatrices(int[][] array2) throws IOException {
		if(this.matrix[0].length != array2.length){
			throw new IOException("Multiplication is not possible");
		}
		int[][] multiplicationOfMatrices = new int[this.matrix[0].length][array2.length];
		
		for (int indexI = 0; indexI < this.matrix.length; indexI++) {
			for (int indexJ = 0; indexJ < array2[0].length; indexJ++) {
				for (int indexK = 0; indexK < this.matrix[0].length; indexK++) {
					multiplicationOfMatrices[indexI][indexJ] = multiplicationOfMatrices[indexI][indexJ] +
							this.matrix[indexI][indexK] * array2[indexK][indexJ];
				}
			}
		}
		return multiplicationOfMatrices;
	}
}