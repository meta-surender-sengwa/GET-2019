import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SizeOfLargestMirrorSectionTest {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ 2, new int[] { 1,2,4,5,2,1 } },
				{ 2, new int[] { 7, 1, 4, 9, 7, 4, 1 } },
				{ 3, new int[] { 1, 2, 3, 8, 9, 3, 2, 1 } },
				{ 7, new int[] { 1, 4, 5, 3, 5, 4, 1 } },
				{ 3, new int[] { 1, 2, 1, 2, 3, 5, 4, 3, 2, 1 } } });
	}

	ArrOperation arrOperationObj = new ArrOperation();
	private int fInput[];

	private int fExpected;

	public SizeOfLargestMirrorSectionTest( int expected, int[] input) {
		this.fInput = input;
		this.fExpected = expected;
	}

	@Test
	public void test() {
		assertEquals(fExpected, arrOperationObj.getSizeOfLargestMirrorSection(fInput));
	}
}