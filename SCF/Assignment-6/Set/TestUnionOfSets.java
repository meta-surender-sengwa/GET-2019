import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



@RunWith(Parameterized.class)
public class TestUnionOfSets{
	
	private int expectedResult[];
	private int set1[];
	private int set2[];
	private IntSet set;
	@Before
	public void initialize() {
		set = new IntSet(new int[]{1,2,3,4,5,6,7,8,9});
	}

	public TestUnionOfSets(int expectedResult[], int set1[], int set2[]) {
	this.expectedResult = expectedResult;
	this.set1 = set1;
	this.set2 = set2;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data1() {
		return Arrays.asList(new Object[][] {
				{new int[]{1,2,3,4,5}, new int[]{1,2,3}, new int[]{2,3,4,5}},
				{new int[]{1,2,3,7,8}, new int[]{1,2,3}, new int[]{7,8}}
	});
	}
	
	@Test
	public void testIntSet1() {
		assertArrayEquals(expectedResult, set.unionOfSets(set1, set2));
	}
	
	
}

