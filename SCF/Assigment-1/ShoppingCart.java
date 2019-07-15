

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ShoppingCart {

	/**
	 * AllProductList store product available to purchase
	 */
	private ArrayList<Product> AllProductList = new ArrayList<Product>();

	/**
	 * Cart store product in user shopping cart
	 */
	private HashMap<String, Product> Cart = new HashMap<String, Product>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShoppingCart shcart = new ShoppingCart();

		Scanner UserInput = new Scanner(System.in);
		shcart.createProductList();

		/**
		 * To Control Program Execution
		 */
		while (true) {
			Product product = new Product();
			System.out.println("\n1.Add Product " + "\n2.Update Product" + "\n3.Remove Product" + "\n4.Show Cart"
					+ "\n5.Genrate Bill" + "\n6.Exit");
			System.out.println("Please Select Valid Option:- ");
			int option = UserInput.nextInt();
			if (option == 6) {
				System.out.println("\nTHANK YOU");
				break;
			}
			switch (option) {
			case (1): {
				shcart.showAllProduct();
				System.out.println("Select Product Id :-");
				int pid = UserInput.nextInt();
				if (pid > 0 && pid <= 5) {
					System.out.println("Enter Quantity :- ");
					product.setProductQuantity(UserInput.nextInt());
					if (product.getProductQuantity() > 0) {

						product.setProductId(pid);
						product.setProductName(shcart.AllProductList.get(pid - 1).ProductName);
						product.setProductPrice(shcart.AllProductList.get(pid - 1).ProductPrice);
						shcart.addProduct(product);
					} else {
						System.out.println("Invalid Quantity!!!!");
					}
				}
				break;
			}
			case (2): {
				shcart.showCart();
				System.out.println("Select product id :-");
				int pid = UserInput.nextInt();
				if (pid > 0 && pid <= 5) {
					System.out.println("Enter Quantity :- ");
					product.setProductQuantity(UserInput.nextInt());
					if (product.getProductQuantity() > 0) {
						// product.ProductId = shcart.AllProductList.get(pid - 1).ProductId;
						product.setProductId(pid);
						shcart.updateProduct(product);
					} else {
						System.out.println("Invalid Quantity!!!!");
					}
				}

				break;
			}
			case (3): {
				shcart.showCart();
				System.out.println("Select product id :-");
				int pid = UserInput.nextInt();
				if (pid > 0 && pid <= shcart.AllProductList.size()) {
					product.setProductId(pid);
					shcart.removeProduct(product);
				}

				break;
			}
			case (4): {
				shcart.showCart();
				break;
			}
			case (5): {
				shcart.genrateBill();
				break;
			}
			default: {
				System.out.println("Invalid Option Selected!!!!");
			}
			}
			;
		}
	}

	/**
	 * 
	 * @param product
	 *            this contain detail about product
	 * 
	 */

	private void addProduct(Product product) {

		if (Cart.containsKey(Integer.toString(product.getProductId()))) {
			product.setProductQuantity(
					product.getProductQuantity() + Cart.get(Integer.toString(product.getProductId())).ProductQuantity);
			Cart.put(Integer.toString(product.getProductId()), product);
			System.out.println("Product Added Succesfull");
		} else {
			Cart.put(Integer.toString(product.getProductId()), product);
			System.out.println("Product Added Succesfull");
		}

	}

	/**
	 * 
	 * @param product
	 *            this contain detail about product Product Id and Quantity needed
	 */
	private void updateProduct(Product product) {
		if (Cart.containsKey(Integer.toString(product.getProductId()))) {
			Product tempProduct = Cart.get(Integer.toString(product.getProductId()));
			tempProduct.setProductQuantity(product.getProductQuantity());
			Cart.put(Integer.toString(product.getProductId()), tempProduct);
			System.out.println("Product Updated Succesfull");
		} else {
			System.out.println("Product Not Found!!!!");
		}
	}

	/**
	 * This used to genrate product list for purchase
	 */
	private void createProductList() {
		AllProductList.add(new Product(1, "Mobile", 300.0));
		AllProductList.add(new Product(2, "Laptop", 3000.0));
		AllProductList.add(new Product(3, "Speker", 200.0));
		AllProductList.add(new Product(4, "Pencil", 10.0));
		AllProductList.add(new Product(5, "Rubber", 2.0));
	}

	/**
	 * This show all available product for purchase
	 */
	public void showAllProduct() {

		int serial_num = 1;
		System.out.println("   Available Product For Purchase");
		System.out.println("--------------------------------------");
		System.out.println("Pid" + "  Name  " + "  Price");
		System.out.println("--------------------------------------");
		for (Product DisplayProduct : AllProductList) {
			System.out.println(" " + serial_num + "  " + DisplayProduct.getProductName() + "   "
					+ DisplayProduct.getProductPrice());
			serial_num++;
		}
		System.out.println("--------------------------------------");
	}

	private void removeProduct(Product product) {
		if (Cart.containsKey(Integer.toString(product.getProductId()))) {
			Cart.remove(Integer.toString(product.getProductId()));
			System.out.println("Product Removed Successfully");
		} else {
			System.out.println("Product Not Found!!!!");
		}
	}

	/**
	 * Show Product in User Cart
	 */
	private void showCart() {

		System.out.println("        Product In Your Cart");
		System.out.println("--------------------------------------");
		System.out.println("pid" + "  Name  " + " Quantity" + " Price");
		System.out.println("--------------------------------------");
		for (Product product : Cart.values()) {
			System.out.println(" " + product.getProductId() + "   " + product.getProductName() + "     "
					+ product.getProductQuantity() + "     " + product.getProductPrice());

		}
	}

	/**
	 * Calculate Price according to quantity and display Bill
	 */
	private void genrateBill() {
		if (Cart.isEmpty()) {
			System.out.println("Cart is empty!!!!");
		} else {
			int serial_num = 1;
			double total_price = 0;

			System.out.println("              Bill                    ");
			System.out.println("--------------------------------------");
			System.out.println("Sr. " + "pid" + "  Name  " + "Quantity" + "  Price");
			System.out.println("--------------------------------------");
			for (Product product : Cart.values()) {
				System.out.println(serial_num + "    " + product.getProductId() + "  " + product.getProductName()
						+ "    " + product.getProductQuantity() + "      "
						+ product.getProductPrice() * product.getProductQuantity());
				serial_num++;
				total_price += product.getProductPrice() * product.getProductQuantity();
			}
			System.out.println("--------------------------------------");
			System.out.println("                 Total Price = " + total_price);
			System.out.println("--------------------------------------");
		}
	}

}