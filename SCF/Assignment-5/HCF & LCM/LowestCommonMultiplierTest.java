import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LowestCommonMultiplierTest {
	private int number1;
	private int number2;
	private int expectedResult;
	private PrimeFactorization lowestCommonMultiplier;
	
	@Before
	public void initialize() {
		lowestCommonMultiplier = new PrimeFactorization();
	}
	
	public LowestCommonMultiplierTest(int expectedResult, int number1, int number2) {
		this.expectedResult = expectedResult;
		this.number1 = number1;
		this.number2 = number2;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
		{ 60, 10, 12},
		{ 30, 5, 6},
		{ 12, 12, 3},
		{ 550 ,50, 55},
		{ 88, 11, 8}
		});
	}
	
	@Test
	public void test() {
		assertEquals(expectedResult, lowestCommonMultiplier.getLowestCommonMultiplier(number1, number2));
	}

}
