import java.util.List;
import java.util.ArrayList;

/**
 * @author Surender
 *	class polynomial is an immutable class which implements functions on an array representing a polynomial
 *	this class implements the evaluate(int) method which evaluates the polynomial by putting the value of base, 
 *	degree() method which returns the degree of the polynomial,
 *	addPoly(Poly1, Poly2) method which returns the addition of two polynomials and 
 *	multiplyPoly(Poly1, Poly2) method which returns the multiplication of two polynomials
 *	
 */
public class Polynomial {
	private int[] polynomialExpression;
	
	/**
	 * constructor for initialization
	 * @param array is the polynomial array
	 */
	Polynomial(int[] array) {
		polynomialExpression = new int[array.length];
		this.polynomialExpression = array;
	}
	
	/**
	 * getter
	 * @return the polynomial array
	 */
	public int[] gePoly() {
		return this.polynomialExpression;
	}
	
	/**
	 * method to evaluates the polynomial by putting the value of base
	 * @param valueOfBase is the value of base of the polynomial 
	 * @return the evaluated double value
	 */
	public int evaluate(int valueOfBase) {
		int evaluateExpression = 0; 
		for(int index = 0; index < polynomialExpression.length; index ++) {
			evaluateExpression += polynomialExpression[index] * (int)Math.pow(valueOfBase, index);
		}
		return evaluateExpression;
	}
	
	/**
	 * method to returns the degree of the polynomial
	 * @return the degree of the polynomial
	 */
	public int degree() {
		return polynomialExpression.length-1;
	}
	
	/**
	 * method to returns the addition of two polynomials
	 * @param firstPolynomial is the first polynomial array
	 * @param secondPolynomial is the second polynomial array
	 * @return the resulting polynomial sum
	 */
	public int[] addPoly(int[] firstPolynomial, int[] secondPolynomial) {
		int[] sumOfPolynomials;
		int sizeOfSumOfPolynomials = java.lang.Math.max(firstPolynomial.length, secondPolynomial.length);
		sumOfPolynomials = new int[sizeOfSumOfPolynomials];
		
		for(int index = 0; index < firstPolynomial.length; index ++) {
			sumOfPolynomials[index] = firstPolynomial[index];
		}
		for(int index = 0; index < secondPolynomial.length; index ++) {
			sumOfPolynomials[index] += secondPolynomial[index];
		}
		return sumOfPolynomials;
	}
	
	/**
	 * method to returns the multiplication of two polynomials
	 * @param firstPolynomial is the first polynomial array
	 * @param secondPolynomial is the second polynomial array
	 * @return the resulting polynomial multiplication
	 */
	public int[] multiplyPoly(int[] firstPolynomial, int[] secondPolynomial) {
		int[] multiplicationOfPolynomials;
		int size = (firstPolynomial.length - 1) + (secondPolynomial.length - 1) + 1;
		multiplicationOfPolynomials = new int[size];	
		for (int index = 0; index < size; index++) {
			multiplicationOfPolynomials[index] = 0;
		}
		
		for (int counterForPoly1 = 0; counterForPoly1 < firstPolynomial.length; counterForPoly1++) {
			for (int counterForPoly2 = 0; counterForPoly2 < secondPolynomial.length; counterForPoly2++) {
				multiplicationOfPolynomials[(counterForPoly1 + counterForPoly2)] += 
						(firstPolynomial[counterForPoly1] * secondPolynomial[counterForPoly2]);
			}
		}
		return multiplicationOfPolynomials;
	}

}
