import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



@RunWith(Parameterized.class)
public class TestSizeOfSet{
	
	private int expectedResult;
	private IntSet set;
	
	@Before
	public void initialize() {
		set = new IntSet(new int[]{1,2,3,4,5,6,7,8,9});
	}

	public TestSizeOfSet(int expectedResult) {
	this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data1() {
		return Arrays.asList(new Object[][] {{8}});
	}
	
	@Test
	public void testIntSet1() {
		assertEquals(expectedResult, set.sizeOfSet());
	}
	
	
}

