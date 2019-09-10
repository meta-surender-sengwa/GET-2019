package com.metacube.assignment.facade;

import java.util.List;
import com.metacube.assignment.dao.ProductDao;
import com.metacube.assignment.enums.DBType;
import com.metacube.assignment.enums.Status;
import com.metacube.assignment.factory.Factory;
import com.metacube.assignment.model.Product;
import com.metacube.assignment.model.ShoppingCart;

/**
 * This class represents the facade layer of the system
 * @author Surender
 */
public class ProductFacade {

	ProductDao productDao = Factory.createProductDao(DBType.MYSQL);
	
	/**
	 * This method generates a query to display all products
	 * @return List<Product>
	 */
	public List<Product> getProducts() {
		String query = "SELECT * FROM Product;";
		return productDao.getAllProduct(query);
	}
	
	/**
	 * This method generates a query to add product to the cart
	 * @param userId is the user Id
	 * @param productId is the product Id
	 * @param productQuantity is the product quantity
	 * @return Status
	 */
	public Status addProductToTheCart(int userId, int productId, int productQuantity) {
		String query = "INSERT INTO ShoppingCart (user_id, product_id, product_quantity) VALUES (" + 
									userId + ", " + productId + ", " + productQuantity + ");";
		return productDao.addProductToCart(query);
	}
	
	/**
	 * This method generates a query to display the cart
	 * @param userId is the user Id
	 * @return List<ShoppingCart>
	 */
	public List<ShoppingCart> getProductsCart(int userId) {
		String query = "SELECT * FROM ShoppingCart WHERE user_id=" + userId + ";";
		return productDao.getCart(query);
	}
	
	/**
	 * This method generate a query to updates the cart
	 * @param userId is the user Id
	 * @param productId is the product Id
	 * @param productQuantity is the product quantity
	 * @return status
	 */
	public Status updateCartItems(int userId, int productId, int productQuantity) {
		String query = "UPDATE ShoppingCart SET product_quantity=" + productQuantity + " WHERE user_id =" + userId + " AND product_id=" + productId + ";";
		return productDao.updateProductsInCart(query);
	}

	/**
	 * This method generate a query to find product Id by product name
	 * @param productName is the name of the product
	 * @return product id
	 */
	public int findProductIdByName(String productName) {
		String query = "SELECT product_id FROM Product WHERE product_name = '" + productName + "' ;";
		return productDao.findProductIdByName(query);
	}

	/**
     * This method generate a query to find product Name by product Id
     * @param productName is the name of the product
     * @return product Name
     */
	public String getProductNameById(int productId) {
		String query = "SELECT product_name FROM Product WHERE product_id = " + productId + ";";
		return productDao.getProductNameById(query);
	}

	/**
     * This method generate a query to delete product from cart
     * @param userId is the user id
     * @param productId is the product id
     * @return Status
     */
	public Status deleteProductFromCart(int userId, int productId) {
		String query = "DELETE FROM ShoppingCart WHERE user_id=" + userId + " AND product_id=" + productId + ";";
		return productDao.deleteProductFromCart(query);
	}

	/**
     * This method generate a query to find user Id by user email
     * @param emailId is the email id of the user
     * @return user Id
     */
	public int findUserIdByEmailId(String emailId) {
		String query = "SELECT user_id FROM Users WHERE user_email='" + emailId + "';";
		return productDao.findUserIdByEmailId(query);
	}

	/**
	 * This method generate a query to authenticate the user
	 * @param userId is the user id
	 * @param password is the user password
	 * @return boolean value
	 */
	public boolean authenticateUser(int userId, String password) {
		String query = "SELECT user_id FROM Users WHERE user_id=" + userId + " AND user_password='" + password + "';";
		return productDao.authenticateUser(query);
	}
}
