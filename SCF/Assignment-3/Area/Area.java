import java.io.IOException;


public class Area {

	public boolean inputValidation(double param){
		if( param > 0 ){
			return true;
		}
		return false;
	}
	
	public boolean inputValidation(double param1, double param2){
		if( param1 > 0 && param2 >0){
			return true;
		}
		return false;
	}
	
	//	method to calculate area of triangle
	public double calculateAreaOfTriangle(double base, double height) throws IOException{
		boolean valid= inputValidation(base, height);
		if(valid == false){
			throw new IOException("Invalid Inputs !!!!!");
		}
		
		double area = (base * height) / 2 ;
		return area;
	}
	
	//	method to calculate area of rectangle
	public double calculateAreaOfRectangle(double width, double height) throws IOException{
		boolean valid= inputValidation(width, height);
		if(valid == false){
			throw new IOException("Invalid Inputs !!!!!");
		}

		double area = width * height ;
		return area;
	}

	//	method to calculate area of square
	public double calculateAreaOfSquare(double side) throws IOException{
		boolean valid= inputValidation(side);
		if(valid == false){
			throw new IOException("Invalid Inputs !!!!!");
		}

		double area = side * side ;
		return area;
	}
	
	//	method to calculate area of circle
	public double calculateAreaOfCircle(double radius) throws IOException{
		boolean valid= inputValidation(radius);
		if(valid == false){
			throw new IOException("Invalid Inputs !!!!!");
		}

		double area = 3.14 * (radius * radius) ;
		return area;
	}



}
