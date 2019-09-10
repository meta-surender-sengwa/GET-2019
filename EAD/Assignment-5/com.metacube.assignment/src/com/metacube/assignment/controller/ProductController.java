package com.metacube.assignment.controller;

import java.util.List;

import com.metacube.assignment.enums.Status;
import com.metacube.assignment.facade.ProductFacade;
import com.metacube.assignment.model.Product;
import com.metacube.assignment.model.ShoppingCart;

/**
 * This class represents a controller layer
 * @author Surender
 */
public class ProductController {
	
	ProductFacade facade = new ProductFacade();
	
	/**
     * Method to return the list of Product and  available stock
     * @return {List<Product>} products
     */
    public List<Product> getProducts(){
        return facade.getProducts();
    }

    /**
     * Method to add product to the cart
     * @param userId is the user Id
     * @param productID is the id of the product to be updated
     * @param productQuantity is the quantity of the product 
     * @return {Status}
     */
    public Status addProductToCart(int userID, int productID,int productQuantity){
        return facade.addProductToTheCart(userID, productID, productQuantity);
    }
    
    /**
     * Method to get cart items with quantity
     * @return  {List<ShoppingCart>} the cart items
     */
    public List<ShoppingCart> getCartItems(int userId){
        return facade.getProductsCart(userId);
    }
    
    /**
     * Method to update cart items
     * @param userId is the user Id
     * @param productID is the id of the product to be updated
     * @param productQuantity is the quantity of the product 
     * @return {Status}
     */
    public Status updateCartItems(int userId, int productID,int productQuantity){
        return facade.updateCartItems(userId, productID, productQuantity);
    }
    
    /**
     * Method to find product Id by product name
     * @param productName is the name of the product
     * @return {int} product Id
     */
    public int findProductIdByName(String productName)
    {
    	return facade.findProductIdByName(productName);
    }

    /**
     * Method to find product Name by product Id
     * @param productName is the name of the product
     * @return {String} product Name
     */
	public String getProductNameById(int productId) {
		return facade.getProductNameById(productId);
	}

	/**
     * Method to delete product from cart
     * @param userId is the user id
     * @param productId is the product id
     * @return {Status}
     */
	public Status deleteProductFromCart(int userId, int productId) {
		return facade.deleteProductFromCart(userId, productId);
	}

	/**
     * Method to find user Id by user email
     * @param emailId is the email id of the user
     * @return {int} user Id
     */
	public int findUserIdByEmailId(String emailId) {
		return facade.findUserIdByEmailId(emailId);
	}

	/**
	 * Method to authenticate the user
	 * @param userId is the user id
	 * @param password is the user password
	 * @return {boolean}
	 */
	public boolean authenticateUser(int userId, String password) {
		return facade.authenticateUser(userId, password);
	}
}
