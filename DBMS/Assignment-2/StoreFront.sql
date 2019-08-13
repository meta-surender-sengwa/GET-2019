CREATE DATABASE storefront;


USE storefront;
CREATE TABLE user (
  
			
			userId int NOT NULL AUTO_INCREMENT,
  
			
			name varchar(255) NOT NULL,

			
			email varchar(40) NOT NULL,
  
			
			phone VARCHAR(10) NOT NULL,
  
			
			type varchar(7) NOT NULL,
  
			
			PRIMARY KEY (userId)

			
			);


CREATE TABLE shopper (
			
ShopperId int NOT NULL,

  
			PRIMARY KEY (ShopperId),
  
			FOREIGN KEY (ShopperId) REFERENCES user (userId)

			);




CREATE TABLE address(
			
addressId int NOT NULL AUTO_INCREMENT,


  			
ShopperId int NOT NULL,
			Address VARCHAR(255) NOT NULL,
			KEY (addressId),
			PRIMARY KEY (ShopperId,AddressId),
  
			FOREIGN KEY (ShopperId) REFERENCES shopper (shopperId)

			);

CREATE TABLE admin (
  
			adminId int NOT NULL,
  
			adminKey int(5),
  
			PRIMARY KEY (adminId),
  
			FOREIGN KEY (adminId) REFERENCES user (userId)
			
);



CREATE TABLE category (
  
			categoryId int NOT NULL AUTO_INCREMENT,
  
			categoryname varchar(50) NOT NULL,
  
			PRIMARY KEY (categoryId)
			
);
	


CREATE TABLE subcategory (

			subcategoryid int NOT NULL AUTO_INCREMENT,
  
			subcategoryname varchar(50) NOT NULL,
  
			categoryId int NOT NULL,
  
			PRIMARY KEY (subcategoryid),
  
			FOREIGN KEY (categoryId) REFERENCES category (categoryId)
			
);



CREATE TABLE product (
			productid int NOT NULL AUTO_INCREMENT,
  
			productname varchar(50) NOT NULL,
  
			stock int NOT NULL,
  
			PRIMARY KEY (productid)

			);



CREATE TABLE images (
  
			imageid int NOT NULL AUTO_INCREMENT,
  
			productid int,
  
			PRIMARY KEY (imageid),
  
			FOREIGN KEY (productid) REFERENCES product (productid)
			
);


CREATE TABLE subcategoryid (
  
			subcategoryid int NOT NULL,
  
			productId int NOT NULL,
  
			PRIMARY KEY (subcategoryid,productid),
  
			FOREIGN KEY (subcategoryId) REFERENCES subcategory (subcategoryId)
			
);

CREATE TABLE Orders (

  
			orderid int NOT NULL AUTO_INCREMENT,
  
			
			shopperid int NOT NULL,

  
			shippingaddress VARCHAR(255) NOT NULL,

	
		addressId int NOT NULL,

			PRIMARY KEY (orderid),

			FOREIGN KEY (shopperid) REFERENCES shopper (ShopperId),

			FOREIGN KEY (addressId) REFERENCES address (addressId)
			
			);


