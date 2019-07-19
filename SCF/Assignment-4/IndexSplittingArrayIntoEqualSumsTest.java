
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IndexSplittingArrayIntoEqualSumsTest{
	
	private int[] inputArray;
	private int expectedResult;
	private ArrOperation arrOperations;

	@Before
	public void initialize() {
	arrOperations = new ArrOperation();
	}

	public IndexSplittingArrayIntoEqualSumsTest(int expectedResult, int[] inputArray) {
	this.expectedResult = expectedResult;
	this.inputArray = inputArray;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
	return Arrays.asList(new Object[][] {
	{ 4, new int[] {1,2,3,4,10}},
	{ 3, new int[] {4,5,6,6,5,4} },
	{ 4, new int[] {1,4,5,1,5,3,3}},
	{ 2, new int[] {6,5,11}},
	});
	}
	
	@Test
	public void testMaxMirror() {
		assertEquals(expectedResult, arrOperations.getArraySplittingIndex(inputArray));
	}
}