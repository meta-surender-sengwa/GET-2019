import java.io.IOException;


public class Grade {

	public Grade() {
	}
	
	public boolean inputValidation(int noOfSTudents, int grade[]){
		if( noOfSTudents > 0 ){
			return true;
		}
		return false;
	}
	
	public double calculateAgerage(int noOfStudents, int gradeSheet[]) throws IOException{
		boolean valid= inputValidation(noOfStudents, gradeSheet);
		if(valid == false){
			throw new IOException("Invalid Inputs !!!!!");
		}
		
		double average = 0;
		for(int index = 0; index < noOfStudents; index++){
			average += gradeSheet[index];
		}
		average = average / noOfStudents;
		return average;
	}
	
	public int calculateMaximum(int noOfStudents, int gradeSheet[]) throws IOException{
		boolean valid= inputValidation(noOfStudents, gradeSheet);
		if(valid == false){
			throw new IOException("Invalid Inputs !!!!!");
		}

		int maximum = gradeSheet[0];
		for(int index = 1; index < noOfStudents; index++){
			if(maximum < gradeSheet[index]){
				maximum = gradeSheet[index];
			}
		}
		return maximum;
	}

	public int calculateMinimum(int noOfStudents, int gradeSheet[]) throws IOException{
		boolean valid= inputValidation(noOfStudents, gradeSheet);
		if(valid == false){
			throw new IOException("Invalid Inputs !!!!!");
		}

		int minimum = gradeSheet[0];
		for(int index = 1; index < noOfStudents; index++){
			if(minimum > gradeSheet[index]){
				minimum = gradeSheet[index];
			}
		}
		return minimum;
	}
	
	public double calculatePercentagePassed(int noOfStudents, int gradeSheet[]) throws IOException{
		boolean valid= inputValidation(noOfStudents, gradeSheet);
		if(valid == false){
			throw new IOException("Invalid Inputs !!!!!");
		}
		
		int count = 0;
		for(int index = 0; index < noOfStudents; index++){
			if(gradeSheet[index] >= 40){
				count += 1 ;
			}
		}
		double percent = ((double)count / noOfStudents) * 100;
		
		return percent;
	}



}
