import java.io.IOException;


public class StringCheck {
	
	public boolean inputValidation(String firstString) {
		if(true ) {
			return true;
		}
		return false;
	}
	public boolean inputValidation(String firstString, String secondString) {
		if(true ) {
			return true;
		}
		return false;
	}
	
	/*
	int findStringLength(String firstString) {
		int length = 0;
		for(char ch : firstString.toCharArray()) {
			length ++;
		}
		return length;
	}
	*/
	
	public int checkEquality(String firstString, String secondString) throws IOException {
		boolean valid= inputValidation(firstString, secondString);
		if(valid == false){
			throw new IOException("Invalid Inputs !!!!!");
		}
		
		if(firstString.length() == secondString.length()) {
			int index = 0; 
			while(index < firstString.length()) {
				if(firstString.charAt(index) != secondString.charAt(index)) {
					return 0;
				}
				index ++;
				if(index == firstString.length()) {
					return 1;
				}
			}
		} 
		return 0;
	}
	
	public String findReverse(String firstString) throws IOException {
		boolean valid= inputValidation(firstString);
		if(valid == false){
			throw new IOException("Invalid Inputs !!!!!");
		}
		
		String reverse = "";
		for(int index = 0; index < firstString.length(); index++) {
			reverse = reverse + firstString.charAt(firstString.length() - (index + 1));
		}
		
		return reverse;
	}

	public String changeCase(String firstString) throws IOException{
		boolean valid= inputValidation(firstString);
		if(valid == false){
			throw new IOException("Invalid Inputs !!!!!");
		}
		
		String newString = "";
		for(int index = 0; index < firstString.length(); index++) {
			if(firstString.charAt(index) >= 65 && firstString.charAt(index) <= 90) {
				newString = newString + (char)(firstString.charAt(index) + 32);
			} else if(firstString.charAt(index) >= 97 && firstString.charAt(index) <= 122) {
				newString = newString + (char)(firstString.charAt(index) - 32);
			}
		}
		return newString;
	}
	
	public String findLargestWord(String firstString) throws IOException{
		boolean valid= inputValidation(firstString);
		if(valid == false){
			throw new IOException("Invalid Inputs !!!!!");
		}
		
		int count = 0;
		int maxLength = 0;
		int index = 0;
		int position = 0;
		for(index = 0; index < firstString.length(); index++) {
			while((firstString.charAt(index) != ' ') || (firstString.charAt(index) != '\0')) {
				count++;
			}
			if(maxLength < count) {
				maxLength = count;
				position = index;
			}
			count = 0;
		}
		
		String largestWord = "";
		
		while(index < (position + maxLength)) {
			largestWord = largestWord + (firstString.charAt(index));
		}
		return "";
	}



}
