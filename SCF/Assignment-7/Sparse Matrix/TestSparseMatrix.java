import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSparseMatrix {
	
	@Test
	public void testGetTransposeOfSparseMatrix() {
		int[][] array1 = new int[][] {{0,0,1},{0,0,2},{0,0,3}};
		SparseMatrix matrix1 = new SparseMatrix(array1);
		int[][] expectedTranspose = new int[][] {{0,0,0},{0,0,0},{1,2,3}};
		int[][] actualTranspose = matrix1.getTransposeOfSparseMatrix().getMatrix();
		assertArrayEquals(expectedTranspose,actualTranspose);

		int[][] array2 = new int[][] {{1,0,0},{2,0,0},{3,0,0}};
		SparseMatrix matrix2 = new SparseMatrix(array2);
		expectedTranspose = new int[][] {{1,2,3},{0,0,0},{0,0,0}};
		actualTranspose = matrix2.getTransposeOfSparseMatrix().getMatrix();
		assertArrayEquals(expectedTranspose,actualTranspose);
	}
	
	@Test
	public void testIsSparseMatrixSymmetrical() {
		int[][] array1 = new int[][] {{0,0,1},{0,2,0},{1,0,3}};
		SparseMatrix matrix = new SparseMatrix(array1);
		assertTrue(matrix.isSparseMatrixSymmetrical());
		
		int[][] array2 = new int[][] {{1,0,0},{2,0,0},{3,0,0}};
		matrix = new SparseMatrix(array2);
		assertFalse(matrix.isSparseMatrixSymmetrical());
		
		int[][] array3 = new int[][] {{1,0,0},{0,1,0},{0,0,1}};
		matrix = new SparseMatrix(array3);
		assertTrue(matrix.isSparseMatrixSymmetrical());
	}
	
	@Test
	public void testGetAdditionOfTwoSparseMatrices() {
		int[][] array1 = new int[][] {{0,0,1},{0,2,0},{1,0,3}};
		SparseMatrix matrix1 = new SparseMatrix(array1);		
		int[][] array2 = new int[][] {{1,0,0},{2,0,0},{3,0,0}};
		SparseMatrix matrix2 = new SparseMatrix(array2);
		int[][] expectedAddition = new int[][] {{1,0,1},{2,2,0},{4,0,3}};
		
		try {
			int[][] actualAddition = matrix1.getAdditionOfTwoSparseMatrix(matrix2).getMatrix();
			assertArrayEquals(expectedAddition, actualAddition);
		} catch (IOException Ex) {
			Ex.printStackTrace();
		}
	}

	@Test
	public void testGetMultiplicationOfTwoSparseMatrix() {
		int[][] array1 = new int[][] {{0,0,1},{0,2,0},{1,0,3}};
		SparseMatrix matrix1 = new SparseMatrix(array1);		
		int[][] array2 = new int[][] {{1,0,0},{2,0,0},{3,0,0}};
		SparseMatrix matrix2 = new SparseMatrix(array2);
		int[][] expectedMultiplication = new int[][] {{3,0,0},{4,0,0},{10,0,0}};
		
		try {
			int[][] actualMultiplication = matrix1.getMultiplicationOfTwoSparseMatrices(matrix2).getMatrix();
			assertArrayEquals(expectedMultiplication, actualMultiplication);
		} catch (IOException Ex) {
			Ex.printStackTrace();
		}
	}
}
