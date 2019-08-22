package assignment;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ShopFront {

	private SqlConnector sqlObj;

	ShopFront() {
		this.sqlObj = new SqlConnector("com.mysql.jdbc.Driver", "shopFront");
	}

	public SqlConnector getSqlObj() {
		return sqlObj;
	}

	void callAllMethod() {
		// this.getUserOrderDetails();
	}

	public void getOrders(int id) throws SQLException {
		
		int flag = 0;
		
		String query = "SELECT usersOrder.orderId, orders.date, orders.totalAmount"
						+ " FROM orders, usersOrder"
						+ " WHERE usersOrder.userId =" + id
						+ " AND usersOrder.orderId = orders.id"
						+ " ORDER BY date;";
		
		ResultSet rs;
		rs = this.getSqlObj().executeQuery(query);
		
		while (rs.next()) {
			
			flag = 1;
			
			int orderId = rs.getInt("orderId");
			Date orderDate= rs.getDate("date");
			int totalAmount = rs.getInt("totalAmount");
			
			System.out.println();
			System.out.println("Order ID : " + orderId );
			System.out.println("Order Date : " + orderDate);
			System.out.println("Total Amount : " + totalAmount);
			System.out.println();
		}
		
		if (flag != 1) {
			System.out.println("No Order Found");
		}
	}

	public int insertImage(int[] imageId, int[] productId) throws SQLException {
		
		String[] query = new String[imageId.length];
		
		for (int index = 0; index < productId.length; index++) {
			query[index] = "INSERT INTO productImage VALUES("+imageId[index]+", "+productId[index]+");";
		}
		
		int result = sqlObj.insertBatch(query);
		sqlObj.connect().close();
		return result;
	}

	public void deleteProduct() throws SQLException {
		
		String query = "DELETE  FROM product WHERE ID NOT IN ("
				+ "SELECT productId FROM orders WHERE DATEDIFF(CURDATE(), date) < 30);";
		
		int result = sqlObj.executeUpdate(query);
		
		System.out.println("Total Row Deleted is : " + result);
		sqlObj.connect().close();
	}
	
	public void calculateChildCategories() throws SQLException {
		
		String query = "SELECT category.name, COUNT(*) AS childCategories FROM category, subCategory"
				+ " WHERE category.id = subCategory.categoryId"
				+ " GROUP BY category.name"
				+ " ORDER BY category.name;";
		
		ResultSet rs;
		rs = this.getSqlObj().executeQuery(query);
		
		int flag = 0;
		while (rs.next()) {
			
			flag = 1;
			
			String Category = rs.getString("name");
			int noOfChildCategories = rs.getInt("childCategories");
			
			System.out.println();
			System.out.println("Parent Category : " + Category);
			System.out.println("No of childs : " + noOfChildCategories);
			System.out.println();
		}
		
		if (flag != 1) {
			System.out.println("No result found !!");
		}
	}

}
