import java.io.IOException;

/**
 * This Interface provide generic method for logical operation
 */
public interface LogicalOperation {
	/**
	 * @param firstOperand and secondOperand operands for equal operation
	 * @return boolean containing true if equal or false
	 * @throws IOException if parameter not contain legal value
	 */
	public boolean equalsOperation(String firstOperand, String secondOperand)
			throws IOException;

	/**
	 * assuming first operand is greater
	 * @param firstOperand and secondOperand operands for greater than operation
	 * @return true if firstOperand is greater
	 * @throws IOException if parameter not contain legal value
	 */
	public boolean greaterThanOperation(String firstOperand, String secondOperand) 
			throws IOException;

	/**
	 * assuming first operand is lesser
	 * @param firstOperand and secondOperand operand for less than operation
	 * @return true if firstOperand is lesser
	 * @throws IOException if parameter not contain legal value
	 */
	public boolean lessThanOperation(String firstOperand, String secondOperand)
			throws IOException;
}
