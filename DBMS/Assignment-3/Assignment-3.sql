CREATE DATABASE ShopFront;

USE ShopFront;


CREATE TABLE users(
id int,
name varchar(25) NOT NULL,
email VARCHAR(30) NOT NULL,
phone VARCHAR(10) NOT NULL,
type VARCHAR(7) NOT NULL,
PRIMARY KEY(id)
);


CREATE TABLE address(
id int,
address VARCHAR(30) NOT NULL,
userId int,
PRIMARY KEY(id),
FOREIGN KEY(userId) REFERENCES users(id)
);


CREATE TABLE category(
id int,
name VARCHAR(20),
PRIMARY KEY(id)
);


CREATE TABLE subCategory(
id int,
name VARCHAR(20),
categoryId int,
PRIMARY KEY(id),
FOREIGN KEY(categoryId) REFERENCES category(id)
);

CREATE TABLE product(
id int,
name varchar(25) NOT NULL,
price int NOT NULL,
description VARCHAR(50) NOT NULL,
PRIMARY KEY(id)
);

CREATE TABLE productSubCategory(
productId int,
subCategoryId int,
FOREIGN KEY(productId) REFERENCES product(id),
FOREIGN KEY(subCategoryId) REFERENCES subCategory(id)
);


CREATE TABLE images(
id int NOT NULL,
name VARCHAR(20),
link VARCHAR(50) NOT NULL,
PRIMARY KEY(id)
);



CREATE TABLE productImage(
imageId int unique,
productId int,
FOREIGN KEY(imageId) REFERENCES images(id),
FOREIGN KEY(productId) REFERENCES product(id)
);



CREATE TABLE stock(
id INT,
quantity INT,
PRIMARY KEY(id),
FOREIGN KEY(id) REFERENCES product(id)
);


CREATE TABLE orders(
id int,
productId int,
quantity int,
date DATETIME NOT NULL,
totalAmount int NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY(productId) REFERENCES product(id)
);


CREATE TABLE usersOrder(
orderId int UNIQUE,
userId int,
FOREIGN KEY(orderId) REFERENCES orders(id),
FOREIGN KEY(userId) REFERENCES users(id)
);

CREATE TABLE orderStatus(
id INT UNIQUE,
status VARCHAR(20),
FOREIGN KEY(id) REFERENCES orders(id)
);


INSERT INTO users VALUES(101, "Ronit", "ronit@gmail.com", 9999999999, "admin");
INSERT INTO users VALUES(102, "Aakash", "aakash@gmail.com", 9999999998, "admin");
INSERT INTO users VALUES(201, "Raj", "raj@gmail.com", 9999999989, "shopper");
INSERT INTO users VALUES(202, "Sonu", "sonu@gmail.com", 9999999899, "shopper");
INSERT INTO users VALUES(203, "Ballu", "ballu@gmail.com", 9999998999, "shopper");


INSERT INTO address VALUES(301, "jaipur", 201);
INSERT INTO address VALUES(302, "ajmer", 202);
INSERT INTO address VALUES(303, "kota", 203);
INSERT INTO address VALUES(304, "nagaur", 201);


INSERT INTO category VALUES(601, "mobile");
INSERT INTO category VALUES(602, "laptop");
INSERT INTO category VALUES(603, "motor cycle");
INSERT INTO category VALUES(604, "four wheeler");


INSERT INTO subCategory VALUES(701, "android", 601);
INSERT INTO subCategory VALUES(702, "ios", 601);
INSERT INTO subCategory VALUES(703, "gaming laptop", 602);
INSERT INTO subCategory VALUES(704, "sports bike", 603);
INSERT INTO subCategory VALUES(705, "utility mobile", 601);


INSERT INTO product VALUES(501, "redmi note 5 pro", 13000 , "latest redmi smart phone");
INSERT INTO product VALUES(502, "mi one plus", 55000, "superb camera features");
INSERT INTO product VALUES(503, "iPHONE x", 70000, "superb quality ios");
INSERT INTO product VALUES(504, "acer predator", 60000, "gaming beast");
INSERT INTO product VALUES(505, "nokia 1200", 1100, "old is gold");


INSERT INTO productSubCategory VALUES(501,701);
INSERT INTO productSubCategory VALUES(501,705);
INSERT INTO productSubCategory VALUES(502,701);
INSERT INTO productSubCategory VALUES(503,702);
INSERT INTO productSubCategory VALUES(504,703);
INSERT INTO productSubCategory VALUES(505,705);


INSERT INTO images VALUES(901, "1.jpg", "C:/xyz");
INSERT INTO images VALUES(902, "2.jpg", "D:/abc");
INSERT INTO images VALUES(903, "3.jpg", "D:/bcd");
INSERT INTO images VALUES(904, "4.jpg", "D:/cde");
INSERT INTO images VALUES(905, "5.jpg", "D:/def");
INSERT INTO images VALUES(906, "6.jpg", "D:/efg");
INSERT INTO images VALUES(907, "7.jpg", "E:/abc");
INSERT INTO images VALUES(908, "8.jpg", "E:/cde");
INSERT INTO images VALUES(909, "9.jpg", "E:/bcd");


INSERT INTO stock VALUES(501, 92);
INSERT INTO stock VALUES(502, 51);
INSERT INTO stock VALUES(503, 22);
INSERT INTO stock VALUES(504, 11);
INSERT INTO stock VALUES(505, 201);


INSERT INTO orders VALUES(1001, 501, 2, CURRENT_TIMESTAMP, 26000);
INSERT INTO orders VALUES(1002, 504, 1, CURRENT_TIMESTAMP, 60000);


INSERT INTO usersOrder VALUES(1001, 203);
INSERT INTO usersOrder VALUES(1002, 203);


INSERT INTO orderStatus VALUES(1001, "delivered");
INSERT INTO orderStatus VALUES(1002, "shipped");


ALTER TABLE address DROP address;
ALTER TABLE address ADD house VARCHAR(5);
ALTER TABLE address ADD street VARCHAR(15);
ALTER TABLE address ADD city VARCHAR(15);
ALTER TABLE address ADD state VARCHAR(15);
ALTER TABLE address ADD zipCode int;


UPDATE address SET house = "a51", street = "pratap nagar", city = "jaipur", state = "raj", zipCode = "302022" WHERE ID = 301;
UPDATE address SET house = "c57", street = "gandhi nagar", city = "ajmer", state = "raj", zipCode = "305001" WHERE ID = 302;
UPDATE address SET house = "a55", street = "madar", city = "ajmer", state = "raj", zipCode = "305002" WHERE ID = 303;
UPDATE address SET house = "a59", street = "jhotwara", city = "jaipur", state = "raj", zipCode = "302013" WHERE ID = 304;



-- Assignment-3

#(1).Display Shopper’s information along with number of orders he/she placed during last 30 days.

SELECT u.name AS shopper, COUNT(*) AS orders
FROM users AS u, orders AS o, usersOrder AS uo
WHERE o.id = uo.orderId AND uo.userId = u.id
GROUP BY shopper;


#(2).Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.

SELECT u.name AS shopper, SUM(o.totalAmount) AS revenue
FROM users AS u, orders AS o, usersOrder AS uo
WHERE o.id = uo.orderId AND uo.userId = u.id AND DATEDIFF(CURDATE(), o.date) < 30
GROUP BY shopper
ORDER BY revenue DESC
LIMIT 10;


#(3).Display top 20 Products which are ordered most in last 60 days along with numbers.

SELECT p.name 
FROM product AS p, orders AS o
WHERE o.productId = p.id AND DATEDIFF(CURDATE(), o.date) < 30
GROUP BY p.name
ORDER BY COUNT(*) DESC
LIMIT 20;


#(4).Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.

SELECT MONTHName(date) AS Month, SUM(totalAmount) AS "Total Monthly revenue"
FROM orders
GROUP BY MONTH(date), YEAR(date)
ORDER BY date DESC
LIMIT 6;



#(5).Mark the products as Inactive which are not ordered in last 90 days.

SELECT name 
FROM product
WHERE id NOT IN
    (SELECT DISTINCT productId 
     FROM orders
     WHERE  DATEDIFF(CURDATE(), date) < 90
    );


#(6).Given a category search keyword, display all the Products present in this category/categories. 

SELECT DISTINCT product.name
FROM product, category, subCategory, productSubCategory
WHERE product.id = productSubCategory.productId
AND productSubCategory.SubCategoryId = SubCategory.id
AND SubCategory.categoryId = category.id
AND category.name = "mobile";


#(7).Display top 10 Items which were cancelled most.

SELECT product.name
FROM product, orders, orderStatus
WHERE product.id = orders.productId 
AND orders.id = orderStatus.id
AND orderStatus.status = "Cancelled"
GROUP BY product.name
ORDER BY COUNT(*)
LIMIT 10;

