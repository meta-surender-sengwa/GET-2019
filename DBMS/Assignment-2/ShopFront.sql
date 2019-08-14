-- Assignment-1

/*
 * (1). Create all tables of eCommerce Application: StoreFront covered in Session 1 Assignments.
 *      (Write all CREATE commands in a SQL file and run that SQL File).
 */

CREATE DATABASE shopFront;
USE shopFront;

SHOW TABLES;

CREATE TABLE user(
userId int,
userName varchar(25) NOT NULL,
userEmail VARCHAR(30) NOT NULL,
userPhone VARCHAR(10) NOT NULL,
userType VARCHAR(7) NOT NULL,
PRIMARY KEY(userId)
);

CREATE TABLE shopper(
shopperId int,
PRIMARY KEY(shopperId),
FOREIGN KEY(shopperId) REFERENCES user(userId)
);

CREATE TABLE admin(
adminId int,
PRIMARY KEY(adminId),
FOREIGN KEY(adminId) REFERENCES user(userId)
);

CREATE TABLE address(
addressId int,
shopperId int,
address VARCHAR(30) NOT NULL,
PRIMARY KEY(addressId),
FOREIGN KEY(shopperId) REFERENCES shopper(shopperId)
);

CREATE TABLE product(
productId int,
productName varchar(25) NOT NULL,
subCategoryId int,
price int NOT NULL,
productQuantity int NOT NULL,
description VARCHAR(50) NOT NULL,
PRIMARY KEY(productId),
FOREIGN KEY(subCategoryId) REFERENCES subCategory(subCategoryId)
);

CREATE TABLE category(
categoryId int,
categoryName VARCHAR(20),
PRIMARY KEY(categoryId)
);

CREATE TABLE subCategory(
subCategoryId int,
subCategoryName VARCHAR(20),
categoryId int,
PRIMARY KEY(subCategoryId),
FOREIGN KEY(categoryId) REFERENCES category(categoryId)
);

CREATE TABLE images(
imageName VARCHAR(20),
productId int,
PRIMARY KEY(imageName),
FOREIGN KEY(productId) REFERENCES product(productId)
);

CREATE TABLE orders(
orderId int,
shopperId int,
productId int,
addressId int,
orderDate Date NOT NULL,
totalAmount int NOT NULL,
PRIMARY KEY(orderId),
FOREIGN KEY(shopperId) REFERENCES shopper(shopperId),
FOREIGN KEY(productId) REFERENCES product(productId),
FOREIGN KEY(addressId) REFERENCES address(addressId)
);


/*
 * (2). Write a command to display all the table names present in StoreFront.
 */
 
 SHOW TABLES;


/*
 * (3). Write a command to remove Product table of the StoreFront database.
 */

-- ALTER TABLE images SET FOREIGN KEY CHECKS = 0;
-- ALTER TABLE images DROP FOREIGN KEY productID;
ALTER TABLE images DROP INDEX productID;
DROP TABLE product;

SHOW TABLES;


/*
 * (4). Create the Product table again.
 */
 
 CREATE TABLE product(
productId int,
productName varchar(25) NOT NULL,
productQunatity int NOT NULL,
PRIMARY KEY(productId)
);

ALTER TABLE images ADD FOREIGN KEY(productId) REFERENCES product(productId);

SHOW TABLES;


/*
    Assignment-2
    
    (1).   Insert sample data in StoreFront tables by using SQL files.
*/

INSERT INTO user VALUES(101, "Ronit", "ronit@gmail.com", 9999999999, "admin");
INSERT INTO user VALUES(102, "Aakash", "aakash@gmail.com", 9999999998, "admin");
INSERT INTO user VALUES(201, "Raj", "raj@gmail.com", 9999999989, "shopper");
INSERT INTO user VALUES(202, "Sonu", "sonu@gmail.com", 9999999899, "shopper");
INSERT INTO user VALUES(203, "Ballu", "ballu@gmail.com", 9999998999, "shopper");

INSERT INTO admin values(101);
INSERT INTO admin values(102);

INSERT INTO shopper VALUES(201);
INSERT INTO shopper VALUES(202);
INSERT INTO shopper VALUES(203);

INSERT INTO address VALUES(301, 201, "jaipur");
INSERT INTO address VALUES(302, 202, "ajmer");
INSERT INTO address VALUES(303, 203, "kota");

INSERT INTO product VALUES(501, "dell inspiron 5559", 702, 50000, 10 ,"best dell laptop");
INSERT INTO product VALUES(502, "redmi note 5 pro", 701, 13000, 20 , "redmi is good");
INSERT INTO product VALUES(503, "acer predator", 702, 60000, 7, "gaming beast");
INSERT INTO product VALUES(504, "nokia 1200", 701, 1100, 50, "old is gold");
INSERT INTO product VALUES(505, "samsung galaxy 10x", 701, 14000, 11, "samsung is nice");
INSERT INTO product VALUES(506, "hitachi ac", 704, 25000, 5, "icy cool");

INSERT INTO category VALUES(601, "electronics");
INSERT INTO category VALUES(602, "electrical");

INSERT INTO subCategory VALUES(701, "mobiles", 601);
INSERT INTO subCategory VALUES(702, "laptops", 601);
INSERT INTO subCategory VALUES(703, "accessories", 601);
INSERT INTO subCategory VALUES(704, "heavy machinery", 602);

INSERT INTO images VALUES("predator.jpg", 503);
INSERT INTO images VALUES("nokia1200.jpg", 504);
INSERT INTO images VALUES("inspiron5559.jpg", 501);

INSERT INTO orders VALUES(1001, 201, 503, 301);
INSERT INTO orders VALUES(1002, 202, 506, 302);
INSERT INTO orders VALUES(1003, 201, 502, 301);


/*
(2). Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top.
*/

SELECT  p.productId, p.productName, c.categoryId, p.price 
FROM product AS p, subCategory AS c 
WHERE p.subCategoryId = c.subCategoryId;

/*
 (3). Display the list of products which don't have any images.
*/

SELECT DISTINCT productName FROM product 
WHERE productId NOT IN(SELECT productId FROM images);


/*
 (4). Display all Id, Title and Parent Category Title for all the Categories listed, sorted by Parent Category 
      Title and then Category Title. 
      (If Category is top category then Parent Category Title column should display “Top Category” as value.)
*/

SELECT sc.subCategoryId AS CategoryId, sc.subCategoryName AS CategoryName, c.categoryName AS ParentCategory 
FROM subCategory AS sc, category AS c 
WHERE sc.categoryId = c.CategoryId;


/*
 (5). Display Id, Title, Parent Category Title of all the leaf Categories (categories which are not parent of any other category)
 */
 
 SELECT sc.subCategoryId AS CategoryId, sc.subCategoryName AS CategoryName, c.categoryName AS ParentCategory 
 FROM subCategory AS sc, category AS c 
 WHERE sc.categoryId = c.CategoryId;

/*
 (6). Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)
*/

SELECT p.productName, p.price, p.description 
FROM product AS p, subCategory AS s
WHERE p.subCategoryId = s.subCategoryId AND s.categoryId = 602;

/*
 (7). Display the list of Products whose Quantity on hand (Inventory) is under 50.
*/

SELECT productName
FROM product
WHERE productQuantity < 49;


/*
    Assignment 3
    
 (1). Display Recent 50 Orders placed (Id, Order Date, Order Total).
*/

SELECT orderId, orderDate, totalAmount 
FROM orders
ORDER BY orderDate DESC LIMIT 50;

/*
 (2). Display 10 most expensive Orders.
*/

SELECT productName
FROM product
ORDER BY price DESC LIMIT 10;


/*
 (3). Display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped.
*/

SELECT orderId
FROM orders
WHERE DATEDIFF(CURDATE(),orderDate) > 10;


/*
 (4). Display list of shoppers which haven't ordered anything since last month.
*/

SELECT userName
FROM user 
WHERE userId NOT IN (
    SELECT shopperId 
    FROM orders 
    WHERE DATEDIFF(CURDATE(), orderDate) < 30
);


/*
 (5). Display list of shopper along with orders placed by them in last 15 days. 
*/

SELECT u.userName, o.orderId
FROM user AS u, orders AS o
WHERE u.userId = o.shopperId AND DATEDIFF(CURDATE(), o.orderDate) < 15;

/*
 (5). Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))
*/


/*
 (6). Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price.
*/

SELECT p.productName, o.orderDate
FROM product AS p, orders AS o
WHERE o.productId = p.productId AND p.price > 20 AND p.price < 50;

