import java.io.IOException;
import java.util.HashMap;

/**
 * HexCalc class contain methods to perform arithmetic and logical operation on
 * HexaDecimal numbers this implements ArithmaticOperation and LogicalOperation
 * interfaces which contain respective methods
 */
public class HexCalc implements ArithmeticOperation, LogicalOperation {
	public static final int base = 16;

	static HashMap<Character, Integer> hexToDecTable = new HashMap<Character, Integer>();
	static HashMap<Integer, Character> decToHexTable = new HashMap<Integer, Character>();

	public HexCalc() {
	}

	public static void initializeHexTables() {
		HexCalc.hexToDecTable.put('A', 10);
		HexCalc.hexToDecTable.put('B', 11);
		HexCalc.hexToDecTable.put('C', 12);
		HexCalc.hexToDecTable.put('D', 13);
		HexCalc.hexToDecTable.put('E', 14);
		HexCalc.hexToDecTable.put('F', 15);

		HexCalc.decToHexTable.put(10, 'A');
		HexCalc.decToHexTable.put(11, 'B');
		HexCalc.decToHexTable.put(12, 'C');
		HexCalc.decToHexTable.put(13, 'D');
		HexCalc.decToHexTable.put(14, 'E');
		HexCalc.decToHexTable.put(15, 'F');
	}

	/**
	 * @param operand
	 *            it contain hexadecimal string that need to validate
	 * @return return true if operand contain legal hexadecimal else false
	 */
	public boolean inputValidation(String operand) {
		if (operand.matches("[0-9A-F]+")) {
			return true;
		} else {
			return false;
		}
	}

	public static String removeInitialZeros(String firstOperand) {
		for (int indexNumber = 0; indexNumber < firstOperand.length(); indexNumber++) {
			char ch1 = firstOperand.charAt(indexNumber);
			if ((ch1 == '0') && (indexNumber != (firstOperand.length() - 1))) {
				firstOperand = firstOperand.substring(indexNumber + 1);
			} else {
				break;
			}
		}
		return firstOperand;
	}

	/**
	 * @param firstOperand
	 *            will be converted to decimal
	 * @return decimal representation of the firstOperand parameter
	 */
	public long hexToDecimal(String firstOperand) throws IOException {
		if (!(inputValidation(firstOperand))) {
			throw new IOException("Invalid Input!!!");
		}

		long decimal = 0;
		int power = 0;
		int asciiOfCharA = 65;
		int asciiOfCharF = 70;

		int firstOperandLength;
		for (firstOperandLength = firstOperand.length() - 1; firstOperandLength >= 0; firstOperandLength--) {
			char hexChar = firstOperand.charAt(firstOperandLength);

			if ((int) hexChar >= asciiOfCharA && (int) hexChar <= asciiOfCharF) {
				int decimalOfHex = HexCalc.hexToDecTable.get(hexChar).intValue();
				decimal += decimalOfHex * (java.lang.Math.pow(base, power));
				power++;
			} else {
				decimal += Character.getNumericValue(hexChar) * (java.lang.Math.pow(base, power));
				power++;
			}
		}
		return decimal;
	}

	/**
	 * @param firstOperand
	 *            will be converted to hexadecimal
	 * @return hexadecimal representation of the parameter
	 */
	public String decimalToHex(String firstOperand) throws IOException {
		if (!(firstOperand.matches("[-0-9]+"))) {
			throw new IOException("Invalid Input!!!");
		}

		if (firstOperand.equals("0")) {
			return "0";
		}
		int remainder;
		StringBuilder hexString = new StringBuilder();
		long decimal = Long.parseLong(firstOperand);

		while (decimal != 0) {
			remainder = (int) decimal % base;
			decimal = decimal / base;
			if (remainder >= 10 && remainder <= 15) {
				hexString.append(HexCalc.decToHexTable.get(remainder));
			} else {
				hexString.append(remainder);
			}
		}
		return hexString.reverse().toString();
	}

	/**
	 * @param firstOperand
	 *            and secondOperand operands for addition
	 * @return addition of the two operands
	 * @throws IOException
	 *             if parameter not contain legal value
	 */
	public String addOperation(String firstOperand, String secondOperand)
			throws IOException {
		if (!(inputValidation(firstOperand) && inputValidation(secondOperand))) {
			throw new IOException("Invalid Input!!!");
		}

		long firstOperandDecimal = hexToDecimal(firstOperand);
		long secondOperandDecimal = hexToDecimal(secondOperand);
		long addResult = firstOperandDecimal + secondOperandDecimal;
		return decimalToHex(Long.toString(addResult));
	}

	/**
	 * @param firstOperand
	 *            and secondOperand operands for subtraction
	 * @return subtraction of the two operands
	 * @throws IOException
	 *             if parameter not contain legal value
	 */
	public String subtractOperation(String firstOperand, String secondOperand)
			throws IOException {
		if (!(inputValidation(firstOperand) && inputValidation(secondOperand))) {
			throw new IOException("Invalid Input!!!");
		}

		if (lessThanOperation(firstOperand, secondOperand)) {
			throw new IOException(
					"Invalid Input : First Number Should Be Larger");
		}
		long firstOperandDecimal = hexToDecimal(firstOperand);
		long secondOperandDecimal = hexToDecimal(secondOperand);
		long subResult = firstOperandDecimal - secondOperandDecimal;
		return decimalToHex(Long.toString(subResult));
	}

	/**
	 * @param firstOperand
	 *            and secondOperand operands for multiplication
	 * @return multiplication of two operand
	 * @throws IOException
	 *             if parameter not contain legal value
	 */
	public String multiplicationOperation(String firstOperand,
			String secondOperand) throws IOException {
		if (!(inputValidation(firstOperand) && inputValidation(secondOperand))) {
			throw new IOException("Invalid Input!!!");
		}

		long firstOperandDecimal = hexToDecimal(firstOperand);
		long secondOperandDecimal = hexToDecimal(secondOperand);
		long mulResult = firstOperandDecimal * secondOperandDecimal;
		return decimalToHex(Long.toString(mulResult));
	}

	/**
	 * @param firstOperand
	 *            and secondOperand operands for division
	 * @return division of the two operands
	 * @throws IOException
	 *             if parameter not contain legal value
	 */
	public String divisonOperation(String firstOperand, String secondOperand)
			throws ArithmeticException, IOException {
		if (!(inputValidation(firstOperand) && inputValidation(secondOperand))) {
			throw new IOException("Invalid Input!!!");
		}
		if (secondOperand.equals("0")) {
			throw new ArithmeticException("Cannot Divide by zero");
		}

		long firstOperandDecimal = hexToDecimal(firstOperand);
		long secondOperandDecimal = hexToDecimal(secondOperand);
		long divResult = firstOperandDecimal / secondOperandDecimal;
		return decimalToHex(Long.toString(divResult));
	}

	/**
	 * @param firstOperand
	 *            and secondOperand operands for equal operation
	 * @return boolean containing true if equal or false
	 * @throws IOException
	 *             if parameter not contain legal value
	 */
	public boolean equalsOperation(String firstOperand, String secondOperand)
			throws IOException {
		if (!(inputValidation(firstOperand) && inputValidation(secondOperand))) {
			throw new IOException("Invalid Input!!!");
		}

		firstOperand = removeInitialZeros(firstOperand);
		secondOperand = removeInitialZeros(secondOperand);

		if (firstOperand.length() == secondOperand.length()) {
			for (int firstOperandLength = 0; firstOperandLength < firstOperand
					.length(); firstOperandLength++) {
				char firstOperandExtractedChar = firstOperand.charAt(0);
				char secondOperandExtractedChar = secondOperand.charAt(0);
				if (Character.getNumericValue(firstOperandExtractedChar) != Character
						.getNumericValue(secondOperandExtractedChar)) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * assuming first operand is greater
	 * 
	 * @param firstOperand
	 *            and secondOperand operands for greater than operation
	 * @return true if firstOperand is greater
	 * @throws IOException
	 *             if parameter not contain legal value
	 */
	public boolean greaterThanOperation(String firstOperand,
			String secondOperand) throws IOException {
		if (!(inputValidation(firstOperand) && inputValidation(secondOperand))) {
			throw new IOException("Invalid Input!!!");
		}

		firstOperand = removeInitialZeros(firstOperand);
		secondOperand = removeInitialZeros(secondOperand);

		if (firstOperand.length() > secondOperand.length()) {
			return true;
		}

		if (firstOperand.length() == secondOperand.length()) {
			for (int firstOperandLength = 0; firstOperandLength < firstOperand
					.length(); firstOperandLength++) {
				char firstOperandExtractedChar = firstOperand.charAt(0);
				char secondOperandExtractedChar = secondOperand.charAt(0);

				if (Character.getNumericValue(firstOperandExtractedChar) > Character
						.getNumericValue(secondOperandExtractedChar)) {
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}

	/**
	 * assuming first operand is lesser
	 * 
	 * @param firstOperand
	 *            and secondOperand operand for less than operation
	 * @return true if firstOperand is lesser
	 * @throws IOException
	 *             if parameter not contain legal value
	 */
	public boolean lessThanOperation(String firstOperand, String secondOperand)
			throws IOException {
		if (!(inputValidation(firstOperand) && inputValidation(secondOperand))) {
			throw new IOException("Invalid Input!!!");
		}

		firstOperand = removeInitialZeros(firstOperand);
		secondOperand = removeInitialZeros(secondOperand);

		if (firstOperand.length() < secondOperand.length()) {
			return true;
		}

		if (firstOperand.length() == secondOperand.length()) {
			for (int firstOperandLength = 0; firstOperandLength < firstOperand
					.length(); firstOperandLength++) {
				char firstOperandExtractedChar = firstOperand.charAt(0);
				char secondOperandExtractedChar = secondOperand.charAt(0);

				if (Character.getNumericValue(firstOperandExtractedChar) < Character
						.getNumericValue(secondOperandExtractedChar)) {
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}
}