

public class Product {

	// variables
	public int ProductQuantity;
	public double ProductPrice;
	public String ProductName;
	public int ProductId;

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

	public Product() {

	}

	public Product(int ProductId, String ProductName, double ProductPrice) {
		this.ProductId = ProductId;
		this.ProductName = ProductName;
		this.ProductPrice = ProductPrice;
	}

	public int getProductQuantity() {
		return ProductQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		ProductQuantity = productQuantity;
	}

	public double getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(double productPrice) {
		ProductPrice = productPrice;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

}