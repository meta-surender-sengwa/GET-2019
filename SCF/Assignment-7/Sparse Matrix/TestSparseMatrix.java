import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;
import org.hamcrest.*;

public class TestSparseMatrix {
	int[][] array = new int[][] {{0,0,1},{0,2,0},{1,0,3}};
	SparseMatrix sparseMatrix = new SparseMatrix(array);
	
	@Test
	public void testGetTransposeMatrix() {
		int[][] expectedTranspose = new int[][] {{2,0,1},{1,1,2},{0,2,1},{2,2,3}};
		int[][] actualTranspose = sparseMatrix.getTransposeMatrix();
		assertArrayEquals(expectedTranspose, actualTranspose);
	}
	
	@Test
	public void testCheckSymmetryOfMatrix() {
		assertTrue(sparseMatrix.checkSymmetryOfMatrix());
	}
	
	@Test
	public void testGetSumOfMatrices() {
		int[][] array2 = new int[][] {{1,0,0},{2,0,0},{3,0,0}};
		int[][] expectedAddition = new int[][] {{1,0,1},{2,2,0},{4,0,3}};
		
		try {
			int[][] actualAddition = sparseMatrix.getSumOfMatrices(array2);
			assertArrayEquals(expectedAddition, actualAddition);
		} catch (IOException Ex) {
			Ex.printStackTrace();
		}
	}
	
	@Test
	public void testGetMultiplicationOfMatrices() {
		int[][] array2 = new int[][] {{1,0,0},{2,0,0},{3,0,0}};
		int[][] expectedMultiplication= new int[][] {{3,0,0},{4,0,0},{10,0,0}};
		
		try {
			int[][] actualMultiplication = sparseMatrix.getMultiplicationOfMatrices(array2);
			assertArrayEquals(expectedMultiplication, actualMultiplication);
		} catch (IOException Ex) {
			Ex.printStackTrace();
		}
	}
}
