package assignment;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		ShopFront shopFrontObject= new ShopFront();
		
		Scanner input = new Scanner(System.in);
		
		while (true) {

			System.out.println("----------------------");
			System.out.println("1. Assignment-1 : get order placed by a partcular user. ");
			System.out.println("2. Assignment-2 : insert 5 images of products using batch insert. "); 
			System.out.println("3. Assignment-3 : delete products which are not ordered in last 1 year. ");
			System.out.println("4. Assignment-4 : display the no of child categories of all present categories. ");
			System.out.println("5. Exit. \n");
					
			System.out.println("-----------------");
			System.out.println("Select one Option");
			int option = input.nextInt();
			 
			if(option == 5) {
				 break;
			}
			 
			switch(option) {
			
				case 1 : System.out.println("Enter the user Id : "); 
					 int id = input.nextInt(); 
					 shopFrontObject.getOrders(id);
				break;
					 
				case 2 : int imageId[] = new int[] { 901, 902, 905, 907, 908 };
					 int productId[] = new int[] { 501, 501, 502, 501, 503 }; int
					 result = shopFrontObject.insertImage(imageId, productId);
					 
					 if (result == 1) { 
					 System.out.println("Images inserted");
						 
					 } else { 
						 System.out.println("Images not inserted"); 
					 }
				break;
					 
				case 3 : shopFrontObject.deleteProduct();
				break;
					 
				case 4 : shopFrontObject.calculateChildCategories();
				break;
					 
				default : System.out.println("Wrong input");
				break;
			}
		}
	}
}
