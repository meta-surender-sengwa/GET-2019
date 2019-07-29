import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class HeighestCommonFactorTest {
	private int number1;
	private int number2;
	private int expectedResult;
	private PrimeFactorization heighteshCommonFactor;
	
	@Before
	public void initialize() {
		heighteshCommonFactor = new PrimeFactorization();
	}
	
	public HeighestCommonFactorTest(int expectedResult, int number1, int number2) {
		this.expectedResult = expectedResult;
		this.number1 = number1;
		this.number2 = number2;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
		{ 2, 10, 12},
		{ 1, 5, 6},
		{ 4, 8, 12},
		{ 7, 14, 21}
		});
	}
	
	@Test
	public void test() {
		assertEquals(expectedResult, heighteshCommonFactor.getHeighestCommonFactor(number1, number2));
	}

}
