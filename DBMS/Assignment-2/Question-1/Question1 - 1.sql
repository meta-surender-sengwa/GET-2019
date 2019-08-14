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