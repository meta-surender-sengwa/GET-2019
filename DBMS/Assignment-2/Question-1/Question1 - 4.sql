
CREATE TABLE product(
productId int,
productName varchar(25) NOT NULL,
productQunatity int NOT NULL,
PRIMARY KEY(productId)
);

ALTER TABLE images ADD FOREIGN KEY(productId) REFERENCES product(productId);
