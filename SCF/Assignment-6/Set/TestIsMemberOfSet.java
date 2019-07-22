import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



@RunWith(Parameterized.class)
public class TestIsMemberOfSet{
	private boolean expectedResult;
	private int numberToSearch;
	private IntSet set;
	
	@Before
	public void initialize() {
		set = new IntSet(new int[]{1,2,3,4,5,6,7,8,9});
	}

	public TestIsMemberOfSet(boolean expectedResult, int numberToSearch) {
	this.expectedResult = expectedResult;
	this.numberToSearch = numberToSearch;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data1() {
		return Arrays.asList(new Object[][] {{true,5}, {false,0}, {true,7}, {false,10}, {true,2}});
	}
	
	@Test
	public void testIntSet1() {
		assertEquals(expectedResult, set.isMemberOfSet(numberToSearch));
	}
	
	
}

