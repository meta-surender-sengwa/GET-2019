package com.metacube.assignment.dao;

import java.util.List;
import com.metacube.assignment.enums.DBType;
import com.metacube.assignment.enums.Status;
import com.metacube.assignment.factory.Factory;
import com.metacube.assignment.model.Product;
import com.metacube.assignment.model.ShoppingCart;

public class ProductDao implements BaseDao<Product> {
	
	BaseDao<Product> baseDao;
	
	public ProductDao(DBType dbType) {
		baseDao = Factory.createBaseDao(dbType);
	}

	@Override
	public List<Product> getAllProduct(String query) {
		return baseDao.getAllProduct(query);
	}

	@Override
	public Status addProductToCart(String query) {
		return baseDao.addProductToCart(query);
	}

	@Override
	public List<ShoppingCart> getCart(String query) {
		return baseDao.getCart(query);
	}

	@Override
	public Status updateProductsInCart(String query) {
		return baseDao.updateProductsInCart(query);
	}

	@Override
	public int findProductIdByName(String query) {
		return baseDao.findProductIdByName(query);
	}

	@Override
	public String getProductNameById(String query) {
		return baseDao.getProductNameById(query);
	}

	@Override
	public Status deleteProductFromCart(String query) {
		return baseDao.deleteProductFromCart(query);
	}

	@Override
	public int findUserIdByEmailId(String query) {
		return baseDao.findUserIdByEmailId(query);
	}

	@Override
	public boolean authenticateUser(String query) {
		return baseDao.authenticateUser(query);
	}

}
