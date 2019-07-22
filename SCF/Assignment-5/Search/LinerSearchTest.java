import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LinerSearchTest {
	private int[] inputArray;
	private int numberToSearch;
	private int expectedResult;

	private Search searchNumber;
	
	@Before
	public void initialize() {
		searchNumber = new Search();
	}
	
	public LinerSearchTest(int expectedResult, int[] inputArray, int numberToSearch) {
		this.expectedResult = expectedResult;
		this.inputArray = inputArray;
		this.numberToSearch = numberToSearch;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
		{ -1, new int[] {1},5},
		{ 1, new int[] {10,4,3}, 4},
		{ 3, new int[] {3,6,9,7,2}, 7},
		{ 4, new int[] {8,5,11,9,15,6}, 15},
		{ -1, new int[] {8,5,11,9,15,6}, 100},
		});
	}
	
	@Test
	public void test() {
		assertEquals(expectedResult, searchNumber.linearSearch(inputArray, numberToSearch));
	}

}
