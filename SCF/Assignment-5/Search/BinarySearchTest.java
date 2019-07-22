import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BinarySearchTest {
	private int[] inputArray;
	private int numberToSearch;
	private int expectedResult;
	
	private Search search;

	@Before
	public void initialize() {
		search = new Search();
	}
	
	public BinarySearchTest(int expectedResult, int[] inputArray, int numberToSearch) {
		this.expectedResult = expectedResult;
		this.inputArray = inputArray;
		this.numberToSearch = numberToSearch;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
		{ 2, new int[] {1,2,3}, 3},
		{ -1, new int[] {1,2,3}, 5},
		{ 2, new int[] {100,120,122,500}, 122},
		{ 4, new int[] {1,2,3,4,5,6,7}, 5},
		{ 1, new int[] {7,40,55,92}, 40}
		});
	}
	
	@Test
	public void test() {
		assertEquals(expectedResult,search.setBoundayIndex(inputArray, numberToSearch));
	}

}
