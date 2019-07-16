import java.util.Scanner;

public class CalcArea {

	public static void main(String[] args) {
		Area area = new Area();
		
		Scanner userInput = new Scanner(System.in);
		double areaOfBoundary = 0.0;
		
		do{
			System.out.println("MENU : ");
			System.out.println("1. Calculate area of a Triangle");
			System.out.println("2. Calculate area of a Rectangle");
			System.out.println("3. Calculate area of a Square");
			System.out.println("4. Calculate area of a Circle");
			System.out.println("5. Exit");
			System.out.println();
			
			int option = userInput.nextInt();
			double parameter1 = 0;
			double parameter2 = 0;
			if (option == 5) {
				System.out.println("Thank You !!!!!");
				break;
			}
			
			switch (option) {
			case 1: {
				try{
					System.out.println("Enter base of triangle : ");
					parameter1 = userInput.nextDouble();
					System.out.println("Enter height of triangle : ");
					parameter2 = userInput.nextDouble();
					
					areaOfBoundary = area.calculateAreaOfTriangle(parameter1, parameter2);
					System.out.println("Area of Triangle is : " + areaOfBoundary);
				}
				catch(Exception Ex){
					System.out.println(Ex);
				}
				break;
			}
			
			case 2:{
				try{
					System.out.println("Enter width of rectangle : ");
					parameter1 = userInput.nextDouble();
					System.out.println("Enter height of rectangle : ");
					parameter2 = userInput.nextDouble();
					
					areaOfBoundary = area.calculateAreaOfRectangle(parameter1, parameter2);
					System.out.println("Area of Rectangle is : " + areaOfBoundary);
				}
				catch(Exception Ex){
					System.out.println(Ex);
				}
				break;
			}
			
			case 3:{
				try{
					System.out.println("Enter side of the square : ");
					parameter1 = userInput.nextDouble();
					
					areaOfBoundary = area.calculateAreaOfSquare(parameter1);
					System.out.println("Area of Square is : " + areaOfBoundary);
				}
				catch(Exception Ex){
					System.out.println(Ex);
				}
				break;
			}
			
			case 4:{
				try{
					System.out.println("Enter radius of the circle : ");
					parameter1 = userInput.nextDouble();
					
					areaOfBoundary = area.calculateAreaOfCircle(parameter1);
					System.out.println("Area of Circle is : " + areaOfBoundary);
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
			
			System.out.println("\n");
		}while(true);

	}
}
