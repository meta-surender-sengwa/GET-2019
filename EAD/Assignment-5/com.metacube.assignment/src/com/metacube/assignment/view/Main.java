package com.metacube.assignment.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.metacube.assignment.controller.ProductController;
import com.metacube.assignment.enums.Status;
import com.metacube.assignment.factory.Factory;
import com.metacube.assignment.model.Product;
import com.metacube.assignment.model.ShoppingCart;

/**
 * This class represents the VIEW layer of the system
 * @author Surender
 */
public class Main {

	static Scanner inputScanner = new Scanner(System.in);
	static ProductController productController = Factory.createProductController();
	
	public static void main(String[] args) {
		
		int userId = showAutenticationPage();
		
		if(userId > 0) {
			String choice;
			Status status = null;
			String productName, productQuantity;
			int productId;
			List<ShoppingCart> cartItems = new ArrayList<>();
			Loop : do {
				showMenu();
				choice = inputScanner.nextLine();
				
				switch(choice) {
					case "1" : 
						showProducts();
						System.out.print("\nEnter product name : ");
						productName = inputScanner.nextLine();
						System.out.print("Enter product quantity : ");
						productQuantity = inputScanner.nextLine();
						
						if(Integer.parseInt(productQuantity) <= 0) {
							System.out.println("Enter quantity greater than 0");
							continue Loop;
						}
						
						productId = productController.findProductIdByName(productName);
						
						try {
							status = productController.addProductToCart(userId, productId, Integer.parseInt(productQuantity));
						} catch (NumberFormatException e) {
							System.out.println("\nEnter the quantity in number only.");
							continue Loop;
						}
						
						if(status == Status.ADDED) {
							System.out.println("Product added to the cart");
							
						} else {
							System.out.println("There was an error while adding the product to the cart");
						}
						break;
						
					case "2" : 
						cartItems = productController.getCartItems(userId);
						
						if(cartItems.size() > 0) {
							int i = 0;
							System.out.println("\nYou have following products in the cart : ");
							
							for(ShoppingCart item : cartItems) {
								System.out.println("Product " + (++i));
								String product = productController.getProductNameById(item.getProductId());
								System.out.println("\tProduct Name : " + product);
								System.out.println("\tProduct Quantity : " + item.getProductQuantity());
							}
							
						} else {
							System.out.println("\nYour cart is Empty");
						}
						break;
						
					case "3" :
						System.out.print("\nEnter product name whose quantity is to be updated : ");
						productName = inputScanner.nextLine();
						System.out.print("Enter the new quantity : ");
						productQuantity = inputScanner.nextLine();
						productId = productController.findProductIdByName(productName);
						
						if(Integer.parseInt(productQuantity) <= 0) {
							System.out.println("Enter quantity greater than 0");
							continue Loop;
						}
						
						if(Integer.parseInt(productQuantity) == 0) {
							status = productController.deleteProductFromCart(userId, productId);
							
						} else {
							try {
								status = productController.updateCartItems(userId, productId, Integer.parseInt(productQuantity));
								
							} catch (NumberFormatException e) {
								System.out.println("\nEnter the quantity in number only.");
								continue Loop;
							}
						}
						
						if(status == Status.UPDATED) {
							System.out.println("Product Updated in the cart");
							
						} else {
							System.out.println("There was an error while updating the product to the cart");
						}
						break;
						
					case "4" :
						System.out.print("\nEnter product name which is to be deleted : ");
						productName = inputScanner.nextLine();
						productId = productController.findProductIdByName(productName);
						status = productController.deleteProductFromCart(userId, productId);
						
						if(status == Status.UPDATED) {
							System.out.println("Product Deleted from the cart");
							
						} else {
							System.out.println("There was an error while updating the product to the cart");
						}
						break;
						
					case "5" :
						break;
						default : 
							System.out.println("Please Enter a valid choice");
				}
			} while(!"5".equals(choice));
			
			System.out.println("\nThank You For Shopping");
			
		} else {
			System.out.println("Incorrect Email Id or Password. Please Enter Again");
			main(args);
		}
	}
	
	/**
	 * This method is used to authenticate the user
	 * @return user id of the authenticated user
	 */
	static int showAutenticationPage() {
		System.out.print("\nEnter Email Id : ");
		String emailId = inputScanner.nextLine();
		System.out.print("Enter Password : ");
		String password = inputScanner.nextLine();
		int userId = productController.findUserIdByEmailId(emailId);
		boolean isUserAuthenticated = productController.authenticateUser(userId, password);
		
		if(isUserAuthenticated) {
			return userId;
		} else {
			return -1;
		}
	}

	/**
	 * This method displays the products in the database
	 */
	static void showProducts() {
		List<Product> productList = new ArrayList<>();
		productList = productController.getProducts();
		int i = 0;
		System.out.println("\nYou can add following products in the cart : ");
		
		for(Product product : productList) {
			System.out.println("Product " + (++i));
			System.out.println("\tProduct Name : " + product.getProductName());
			System.out.println("\tProduct Type : " + product.getProductType());
			System.out.println("\tProduct Price : " + product.getProductPrice());
		}
	}

	/**
	 * This method displays the menu
	 */
	static void showMenu() {
		System.out.println();
		System.out.println("1. Add Product to the cart");
		System.out.println("2. Display the cart.");
		System.out.println("3. Update an Item's quantity in the cart");
		System.out.println("4. Delete Product from Cart");
		System.out.println("5. Logout");
		System.out.println("Enter your choice : ");
	}
}
