import static org.junit.Assert.*;

import org.junit.Test;

public class ArrOperationTest {

	ArrOperation arrOperation = new ArrOperation();
	
	@Test (expected = AssertionError.class)
	public void testGetSizeOfLargestMirrorSectionInArray() {
		System.out.println();
		
		int[] input = {};
		assertEquals(0, arrOperation.getSizeOfLargestMirrorSection(input));
	}
	
	@Test
	public void testGetSizeOfLargestMirrorSection() {
		System.out.println();
		
		int[] input1 = {1,2,3,4,5,2,1};
		assertEquals(2, arrOperation.getSizeOfLargestMirrorSection(input1));
		
		int[] input2 = {2,2,2,2,2};
		assertEquals(5, arrOperation.getSizeOfLargestMirrorSection(input2));
		
		int[] input3 = {1,2,3,4,5,2,1,4,3,2};
		assertEquals(3, arrOperation.getSizeOfLargestMirrorSection(input3));
		
		int[] input4 = {1,2,3,4,5,4,3,1,2};
		assertEquals(10, arrOperation.getSizeOfLargestMirrorSection(input4));
		
		int[] input5 = {1,2,3,4,5,4,1};
		assertEquals(3, arrOperation.getSizeOfLargestMirrorSection(input5));
	}
	
	@Test (expected = AssertionError.class)
	public void testGetNumberOfClumpsInArray() {
		System.out.println();
		
		int[] input = {};
		assertEquals(0, arrOperation.getNumberOfClumps(input));
	}
	
	@Test
	public void testGetNumberOfClumps() {
		System.out.println();
		
		int[] input1 = {1,1,1,1};
		assertEquals(1, arrOperation.getNumberOfClumps(input1));
		
		int[] input2 = {1,2,3,2,3,3,4,2,2};
		assertEquals(2, arrOperation.getNumberOfClumps(input2));
		
		int[] input3 = {1,1,1,3,1,4,4,3,2,2};
		assertEquals(3, arrOperation.getNumberOfClumps(input3));
		
		int[] input4 = {1,1,1,2,1,1,1,2,2};
		assertEquals(3, arrOperation.getNumberOfClumps(input4));
		
		int[] input5 = {1,1,2,2,3,4,4,5,4,1,1};
		assertEquals(4, arrOperation.getNumberOfClumps(input5));
	}

	
	@Test (expected = AssertionError.class)
	public void testSolveFixXYProblemInArray() {
		System.out.println();
		
		int[] input = {};
		int[] array = {};
		assertArrayEquals(array, arrOperation.solveFixXYProblem(input,0,0));
	}
	
	@Test
	public void testSolveFixXYProblem() {
		System.out.println();
		
		int[] input1 = {3,2,1};
		int[] array1 = {1,2,3};
		assertArrayEquals(array1, arrOperation.solveFixXYProblem(input1, 1, 2));
		
		int[] input2 = {2,5,1,5,2};
		int[] array2 = {1,5,2,5,2};
		assertArrayEquals(array2, arrOperation.solveFixXYProblem(input2, 5, 2));
		
		int[] input3 = {2,5,1,2,5,1};
		int[] array3 = {1,5,2,1,5,2};
		assertArrayEquals(array3, arrOperation.solveFixXYProblem(input1, 5, 2));
		
		int[] input4 = {3,4,1,4,3,2};
		int[] array4 = {3,4,1,2,3,4};
		assertArrayEquals(array4, arrOperation.solveFixXYProblem(input1, 3, 4));
		
		int[] input5 = {4,2,2,4,1};
		int[] array5 = {4,2,1,4,2};
		assertArrayEquals(array5, arrOperation.solveFixXYProblem(input1, 4, 2));
		
	}

	
	@Test (expected = AssertionError.class)
	public void testGetArraySplittingIndexInArray() {
		System.out.println();
		
		int[] input = {};
		assertEquals(0, arrOperation.getNumberOfClumps(input));
	}
	
	@Test
	public void testGetArraySplittingIndex() {
		System.out.println();
		
		int[] input1 = {1,1,1,1};
		assertEquals(2, arrOperation.getNumberOfClumps(input1));
		
		int[] input2 = {1,2,3,4,10};
		assertEquals(4, arrOperation.getNumberOfClumps(input2));
		
		int[] input3 = {9,2,3,5,3};
		assertEquals(2, arrOperation.getNumberOfClumps(input3));
		
		int[] input4 = {1,2,1,1,3,1,1,4,1,5,5,5};
		assertEquals(9, arrOperation.getNumberOfClumps(input4));
		
		int[] input5 = {10,8,2};
		assertEquals(1, arrOperation.getNumberOfClumps(input5));
	}

}
