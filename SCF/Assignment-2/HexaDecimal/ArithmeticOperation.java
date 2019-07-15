import java.io.IOException;

/**
 * This Interface provide generic method for arithmetic operation
 */
public interface ArithmeticOperation {
	/**
	 * @param firstOperand and secondOperand operands for addition
	 * @return addition of the two operands
	 * @throws IOException if parameter not contain legal value
	 */
	public String addOperation(String firstOperand, String secondOperand)
			throws IOException;

	/**
	 * @param firstOperand and secondOperand operands for subtraction
	 * @return subtraction of the two operands
	 * @throws IOException if parameter not contain legal value
	 */
	public String subtractOperation(String firstOperand, String secondOperand)
			throws IOException;

	/**
	 * @param firstOperand and secondOperand operands for multiplication
	 * @return multiplication of two operand
	 * @throws IOException if parameter not contain legal value
	 */
	public String multiplicationOperation(String firstOperand,
			String secondOperand) throws IOException;

	/**
	 * @param firstOperand and secondOperand operands for division
	 * @return division of the two operands
	 * @throws IOException if parameter not contain legal value
	 */
	public String divisonOperation(String firstOperand, String secondOperand)
			throws IOException, ArithmeticException;

}