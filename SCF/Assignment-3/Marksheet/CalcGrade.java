import java.util.Scanner;
import java.util.Scanner;

public class CalcGrade {

	public static void main(String[] args) {
		Grade grade = new Grade();
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Enter number of students : ");
		int noOfStudents = userInput.nextInt(); 
		
		int gradeSheet[] = new int[noOfStudents];
		System.out.print("Enter grades of students : \n");
		for(int index=0; index < noOfStudents; index++){
			System.out.print("Student "+ (index+1) + " : "); 
			gradeSheet[index] = userInput.nextInt();
		}
		
		do{
			System.out.println("\nMENU : ");
			System.out.println("1. Calculate Average of all grades");
			System.out.println("2. Calculate Maximum of all grades");
			System.out.println("3. Calculate Minimum of all grades");
			System.out.println("4. Calculate percentage of students passed");
			System.out.println("5. Exit");
			System.out.println();
			
			int option = userInput.nextInt();
			
			if (option == 5) {
				System.out.println("Thank You !!!!!");
				break;
			}
			
			switch (option) {
			case 1: {
				try{
					double average = grade.calculateAgerage(noOfStudents, gradeSheet);
					System.out.println("Average of all grade is : " + average);
				}
				catch(Exception Ex){
					System.out.println(Ex);
				}
				break;
			}
			
			case 2:{
				try{
					int maximum = grade.calculateMaximum(noOfStudents, gradeSheet);
					System.out.println("Maximum of all grade is : " + maximum);				}
				catch(Exception Ex){
					System.out.println(Ex);
				}
				break;
			}
			
			case 3:{
				try{
					int minimum= grade.calculateMinimum(noOfStudents, gradeSheet);
					System.out.println("Minimum of all grade is : " + minimum);
				}
				catch(Exception Ex){
					System.out.println(Ex);
				}
				break;
			}
			
			case 4:{
				try{
					double percentagePassed = grade.calculatePercentagePassed(noOfStudents, gradeSheet);
					System.out.println("Percentage of Students passed is : " + percentagePassed +" %");
				}
				catch(Exception Ex){
					System.out.println(Ex);
				}
				break;
			}
			
			default :{
				System.out.println("Wrong input !!!!!");
			}
			}
		}while(true);

	}
}