
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
