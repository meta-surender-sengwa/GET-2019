import java.io.IOException;
import java.util.Scanner;

/**
 * This class interact with user provide option to perform operation on
 * hexadecimal number
 */
public class Calculator {
	public static void main(String[] args) {
		HexCalc hexaDecimal = new HexCalc();
		String firstOperand;
		String secondOperand;

		Scanner userInput = new Scanner(System.in);

		HexCalc.initializeHexTables();
		while (true) {
			System.out.println("Please Select Option...." + "\n1. Addition"
					+ "\n2. Multiplication" + "\n3. Division"
					+ "\n4. Subtraction");
			System.out.print("\n5. Equal Opration"
					+ "\n6. GreaterThan Operation" + "\n7. LessThan Operation"
					+ "\n8.HexaDecimal to Decimal"
					+ "\n9.Decimal to HexaDecimal" + "\n10.Exit");
			System.out.print("\nSelect Option:-");

			int option = userInput.nextInt();

			if (option == 10) {
				System.out.println("Thank You");
				break;
			}

			switch (option) {
			case 1: {
				System.out.print("Please Enter First HexaDecimal Number:-");
				firstOperand = userInput.next();

				System.out.print("Please Enter Second HexaDecimal Number:-");
				secondOperand = userInput.next();

				try {
					String addResult = hexaDecimal.addOperation(firstOperand, secondOperand);
					System.out.println(firstOperand + " + " + secondOperand + " = " + addResult);
				} catch (IOException io) {
					System.out.println(io);
				}
				break;
			}

			case 2: {
				System.out.print("Please Enter First HexaDecimal Number:-");
				firstOperand = userInput.next();
				System.out.print("Please Enter Second HexaDecimal Number:-");
				secondOperand = userInput.next();

				try {
					String subResult = hexaDecimal.subtractOperation(firstOperand, secondOperand);
					System.out.println(firstOperand + " - " + secondOperand + " = " + subResult);
				} catch (IOException io) {
					System.out.println(io);
				}

				break;
			}

			case 3: {
				System.out.print("Please Enter First HexaDecimal Number:-");
				firstOperand = userInput.next();
				System.out.print("Please Enter Second HexaDecimal Number:-");
				secondOperand = userInput.next();

				try {
					String divResult = hexaDecimal.divisonOperation(firstOperand, secondOperand);
					System.out.println(firstOperand + " / " + secondOperand + " = " + divResult);
				} catch (IOException io) {
					System.out.println(io);
				}

				break;
			}

			case 4: {
				System.out.print("Please Enter First HexaDecimal Number:-");
				firstOperand = userInput.next();
				System.out.print("Please Enter Second HexaDecimal Number:-");
				secondOperand = userInput.next();

				try {
					String mulResult = hexaDecimal.multiplicationOperation(firstOperand, secondOperand);
					System.out.println(firstOperand + " * " + secondOperand + " = " + mulResult);
				} catch (IOException io) {
					System.out.println(io);
				}
				break;
			}

			case 5: {
				System.out.print("Please Enter First HexaDecimal Number:-");
				firstOperand = userInput.next();
				System.out.print("Please Enter Second HexaDecimal Number:-");
				secondOperand = userInput.next();

				try {
					boolean eqResult = hexaDecimal.equalsOperation(firstOperand, secondOperand);
					if (eqResult) {
						System.out.println(firstOperand + " == " + secondOperand);
					} else {
						System.out.println(firstOperand + " != " + secondOperand);
					}
				} catch (IOException io) {
					System.out.println(io);
				}
				break;
			}

			case 6: {
				System.out.print("Please Enter First HexaDecimal Number:-");
				firstOperand = userInput.next();
				System.out.print("Please Enter Second HexaDecimal Number:-");
				secondOperand = userInput.next();

				try {
					boolean geResult = hexaDecimal.greaterThanOperation( firstOperand, secondOperand);
					if (geResult) {
						System.out.println(firstOperand + " is greater than " + secondOperand);
					} else {
						System.out.println(firstOperand + " is not greater than " + secondOperand);
					}
				} catch (IOException io) {
					System.out.println(io);
				}
				break;
			}

			case 7: {

				System.out.print("Please Enter First HexaDecimal Number:-");
				firstOperand = userInput.next();
				System.out.print("Please Enter Second HexaDecimal Number:-");
				secondOperand = userInput.next();

				try {
					boolean geResult = hexaDecimal.lessThanOperation(firstOperand, secondOperand);
					if (geResult) {
						System.out.println(firstOperand + " is less than " + secondOperand);
					} else {
						System.out.println(firstOperand + " is not less than "
								+ secondOperand);
					}
				} catch (IOException io) {
					System.out.println(io);
				}
				break;
			}

			case 8: {
				System.out.print("Please Enter HexaDecimal Number:-");
				firstOperand = userInput.next();

				try {
					long geResult = hexaDecimal.hexToDecimal(firstOperand);
					System.out.println(firstOperand + " Decimal Representation is :- " + geResult);
				} catch (IOException io) {
					System.out.println(io);
				}
				break;
			}

			case 9: {
				System.out.print("Please Enter Decimal Number:-");
				String decimal = userInput.next();

				try {
					String geResult = hexaDecimal.decimalToHex(decimal);
					System.out.println(decimal + " Decimal Representation is :- " + geResult);
				} catch (IOException io) {
					System.out.println(io);
				}
				break;
			}

			default: {
				System.out.println("Invalid Input!!!!");
			}
			}
			;
		}
	}
}