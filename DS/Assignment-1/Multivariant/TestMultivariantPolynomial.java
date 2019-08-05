import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;


public class TestMultivariantPolynomial {

	@Test
	public void testPoly1() {
		int[] coff = { 2, 3, 4 };
		int[][] exponent1 = { { 2, 3, 4 }, { 1, 2, 1 }, { 1, 1, 1 } };
		
		MultivariantPolynomial list = new MultivariantPolynomial();
		list.helper(coff, exponent1);
		
		int result = list.findDegree();
		int expectedData = 9;
		
		assertEquals(expectedData, result);
	}

	@Test
	public void testPoly2() {
		int[] coff = { 7, 3, 9 };
		int[][] exponent1 = { { 1, 3, 1 }, { 7, 2, 1 }, { 8, 1, 1 } };
		
		MultivariantPolynomial list = new MultivariantPolynomial();
		list.helper(coff, exponent1);
		
		int result = list.findDegree();
		int expectedData = 10;
		
		assertEquals(expectedData, result);
	}

}
