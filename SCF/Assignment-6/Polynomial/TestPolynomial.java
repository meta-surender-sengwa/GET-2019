import static org.junit.Assert.*;

import org.junit.Test;

public class TestPolynomial {
	int[] polynomialArray = new int[] {2,0,6};
	Polynomial polynomial = new Polynomial(polynomialArray);
	
	@Test
	public void testEvaluatePoynomial() {
		assertEquals(8, polynomial.evaluate(1));
		assertEquals(602, polynomial.evaluate(10));
		assertNotEquals(0, polynomial.evaluate(0));
		assertNotEquals(100, polynomial.evaluate(2));
	}
	
	@Test
	public void testDegreeOfPoynomial() {
		assertEquals(2, polynomial.degree());
		assertNotEquals(3, polynomial.degree());
	}
	
	@Test
	public void testSumOfPoynomial() {
		int[] polynomialArray1 = new int[] {2,0,6};
		int[] polynomialArray2 = new int[] {4,2,0,7};
		
		int[] expectedResult1 = new int[] {6,2,6,7};
		int[] expectedResult2 = new int[] {2,3,1};
		
		assertArrayEquals(expectedResult1, polynomial.addPoly(polynomialArray1, polynomialArray2));
		//	assertArrayNotEquals(expectedResult2, polynomial.addPoly(polynomialArray1, polynomialArray2));
	}
	
	
	@Test
	public void testMultiplicatioOfPoynomial() {
		int[] polynomialArray1 = new int[] {5,2};
		int[] polynomialArray2 = new int[] {2,3,6};
		
		int[] expectedResult1 = new int[] {10,19,36,12};
		int[] expectedResult2 = new int[] {8,4,24,26,0,2};
		
		assertArrayEquals(expectedResult1, polynomial.multiplyPoly(polynomialArray1, polynomialArray2));
		//	assertArrayNotEquals(expectedResult2, polynomial.multiplyPoly(polynomialArray1, polynomialArray2));
	}

}
