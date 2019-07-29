/**
 * @author Surender
 *  	class PrimeFactorization implements two operations - highest common factor(HCF) and 
 *  	lowest common multiplier (LCM) of two inputs given by the user
 */
public class PrimeFactorization {
	
	/**
	 * @param number1 is the first operand of the HCF operation
	 * @param number2 is the second operand of the HCF operation
	 * @return the HCF of the two numbers number1 and number1 
	 */
	int getHeighestCommonFactor(int number1, int number2) {
		if (number2 > number1) {
			if (number1 == 0) {
				return number2;
			}
			return getHeighestCommonFactor(number2 % number1, number1);
		} else {
			if (number2 == 0) {
				return number2;
			}
			return getHeighestCommonFactor((number1 % number2), number2);
		}
	}

	/**
	 * @param number1 is the first operand of the LCM operation
	 * @param number2 is the second operand of the LCM operation
	 * @return the LCM of the two numbers number1 and number1 
	 */
	int getLowestCommonMultiplier(int number1, int number2) {
		return (number1 * number2) / getHeighestCommonFactor(number1, number2);
	}
}
