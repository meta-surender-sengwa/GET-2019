import java.io.IOException;

public class StringCheck {
	
	//	method to validate an input string
	public boolean inputValidation(String firstString) {
		for(int i = 0; i < firstString.length(); i++ ) {
			if((firstString.charAt(i) >= 65 && firstString.charAt(i) <= 90) 
					|| (firstString.charAt(i) >= 97 && firstString.charAt(i) <=122) || firstString.charAt(i) == (char)32) {
				return true;
			}
		}
		return false;
	}
	
//	method to validate two input strings
	public boolean inputValidation(String firstString, String secondString) {
		boolean b1 = inputValidation(firstString);
		boolean b2 = inputValidation(secondString);
		
		if(b1 && b2) {
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
	
	//	method to check if two strings are equal
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
	
	//	method to find the reverse of a string
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

	//	method to change the case of all the letters of a string
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
	
	//	method to find the largest word in a string
	public String findLargestWord(String firstString) throws IOException{
		
		boolean valid= inputValidation(firstString);
		if(valid == false){
			throw new IOException("Invalid Inputs !!!!!");
		}
		
		char stringArray[] = firstString.toCharArray();
		int beginIndex = 0, endIndex = 0, maxLength = 0, count = 0;
		
		for (int i = 0; i < firstString.length(); i++) {
        	int j = i;
        	while ((i + count) < firstString.length() && stringArray[j] != ' ') {
            	count++;
            	j++;
            }
            if (maxLength <= count) {
            	maxLength = count;
            	beginIndex = i;
           		endIndex = i + count;
           	}
            i = i + count;
           	count = 0;
      	}
        return firstString.substring(beginIndex, endIndex);
         	
	}
}
