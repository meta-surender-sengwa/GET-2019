package com.metacube.assignment.factory;

import java.sql.SQLException;

import com.metacube.assignment.controller.ProductController;
import com.metacube.assignment.dao.BaseDao;
import com.metacube.assignment.dao.InMemoryDao;
import com.metacube.assignment.dao.ProductDao;
import com.metacube.assignment.dao.SQLDao;
import com.metacube.assignment.enums.DBType;
import com.metacube.assignment.facade.ProductFacade;
import com.metacube.assignment.model.Product;
import com.metacube.assignment.model.ShoppingCart;

public class Factory {

	public static ProductController createProductController() {
		
		ProductController productController = new ProductController();
        return productController;
    }
	
	/**
     * This method creates and returns Product type Object
     * @param productCode is the code of the product
     * @param productType is the type of the  of product
     * @param productName is the name of the  of product
     * @param productPrice is the price of the  of product
     * @return Product object
     */
    public static Product createProduct(int productCode, String productType, String productName,double productPrice){
    	
        Product product=new Product (productCode, productType, productName, productPrice);
        return product;        
    }
  
    /**
     * This method creates and returns ShoppingCart type Object
     * @return {ShoppingCart} ShoppingCart Object
     */
    public static ShoppingCart createShoppingCart(){
        ShoppingCart shoppingCart =new ShoppingCart();
        
        return shoppingCart;
    }
    
    /**
     * This method creates and returns ProductFacade type Object
     * @return ProductFacade Object
     */
    public static ProductFacade createProductFacade(){
        return new ProductFacade();
    }
    
    /**
     * This method creates and returns BaseDao<Product> type Object
     * @return ProductDao Object
     */
    public static BaseDao<Product> createBaseDao(DBType dbType){
    	
        try {
        	if(dbType == DBType.IN_MEMORY) {
    			return new InMemoryDao();
    			
    		} else {
    			return new SQLDao();
    		}
        	
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
    }

    /**
     * This method creates and returns ProductDao type Object
     * @return ProductDao Object
     */
	public static ProductDao createProductDao(DBType dbType) {
		return new ProductDao(dbType);
	}
}
