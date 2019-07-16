import java.util.Scanner;

public class TestStringCheck {

	public static void main(String[] args) {
		
		StringCheck string = new StringCheck();
		Scanner userInput = new Scanner(System.in);
		
		String string1 =""; 
		String string2 = ""; 
		
		do{

			System.out.println("MENU : ");
			System.out.println("1. Check if the two strings are equal");
			System.out.println("2. find reverse of a string");
			System.out.println("3. Change case of letters of a string");
			System.out.println("4. Find largest word in a string");
			System.out.println("5. Exit");
			System.out.print("Please select a valid option : ");
			
			int option = userInput.nextInt();
			
			if (option == 5) {
				System.out.println("Thank You !!!!!");
				break;
			}
			
			switch (option) {
			case 1: {
				try {
					System.out.print("Enter first string : ");
					string1 = userInput.next(); 
					System.out.print("Enter sencond string : ");
					string2 = userInput.next(); 
					
					int check = string.checkEquality(string1, string2);
					if(check == 1) {
						System.out.print("The two input strings are EQUAL \n");
					}else{
						System.out.print("The two input strings are NOT Equal \n");
					}
				}
				catch(Exception Ex) {
					System.out.println(Ex);
				}
				break;
			}
			
			case 2: {
				try {
					System.out.print("Enter first string : ");
					string1 = userInput.next(); 
					
					String reverse = string.findReverse(string1);
					System.out.print("Reverse of the string is " + reverse +"\n");
				}
				catch(Exception Ex) {
					System.out.println(Ex);
				}
				break;
			}
			
			case 3: {
				try {
					System.out.print("Enter first string : ");
					string1 = userInput.next(); 
					
					String newString = string.changeCase(string1);
					System.out.print("String after changing case of each letter is " + newString + "\n");
				}
				catch(Exception Ex) {
					System.out.println(Ex);
				}
				break;
			}
			
			case 4: {
				try {
					System.out.print("Enter first string : ");
					string1 = userInput.nextLine(); 
					
					String largestWord = string.findLargestWord(string1);
					System.out.print("Largest word of the input string is " + largestWord + "\n");
				}
				catch(Exception Ex) {
					System.out.println(Ex);
				}
				break;
			}
			
			default : {
				System.out.println("Wrong input !!!!!");
			}
			}
		} while(true);

	}
}