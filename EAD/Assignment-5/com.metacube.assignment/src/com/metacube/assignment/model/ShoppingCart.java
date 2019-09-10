package com.metacube.assignment.model;

/**
 * This class represents a Shopping Cart
 * @author Surender
 */
public class ShoppingCart extends BaseEntity {
	
	private int userId;
	private int productId;
	private int productQuantity;
	
	public ShoppingCart(int cartId, int userId, int productId, int productQuantity) {
		super(cartId);
		this.productId = productId;
		this.productQuantity = productQuantity;
		this.userId = userId;
	}
	
	public ShoppingCart() {
		super();
	}

	public int getProductId() {
		return productId;
	}
	
	public int getProductQuantity() {
		return productQuantity;
	}
	
	public int getUserId() {
		return userId;
	}
}
