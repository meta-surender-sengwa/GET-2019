package com.metacube.assignment.dao;

import java.util.List;
import com.metacube.assignment.enums.Status;
import com.metacube.assignment.model.Product;
import com.metacube.assignment.model.ShoppingCart;

public class InMemoryDao implements BaseDao<Product> {

	@Override
	public List<Product> getAllProduct(String query) {
		return null;
	}

	@Override
	public Status addProductToCart(String query) {
		return Status.ERROR;
	}

	@Override
	public List<ShoppingCart> getCart(String query) {
		return null;
	}

	@Override
	public Status updateProductsInCart(String query) {
		return Status.ERROR;
	}

	@Override
	public int findProductIdByName(String query) {
		return -1;
	}

	@Override
	public String getProductNameById(String query) {
		return null;
	}

	@Override
	public Status deleteProductFromCart(String query) {
		return Status.ERROR;
	}

	@Override
	public int findUserIdByEmailId(String query) {
		return -1;
	}

	@Override
	public boolean authenticateUser(String query) {
		return false;
	}

}
