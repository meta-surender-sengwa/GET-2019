import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		ShopFront shopFrontObject= new ShopFront();
		
		Scanner input = new Scanner(System.in);
		
		//	Assignment-1
		System.out.println("Enter the user Id : ");
		int id = input.nextInt();
		shopFrontObject.getOrders(id);
		
		
		//	Assignment-2
		/*
		int imageId[] = new int[] { 901, 902, 905, 907, 908 };
		
		int ProductId[] = new int[] { 501, 501, 502, 501, 503 };
		int result = shopFrontObject.insertImage(imageId, ProductId);
		
		if (result == 1) {
			System.out.println("Images inserted");
			
		} else {
			System.out.println("Images not inserted");
		}

		
		//	Assignment-3
		shopFrontObject.deleteProduct();
		
		
		//	Assignment-4
		shopFrontObject.calculateChildCategories();
		*/
	}
}
