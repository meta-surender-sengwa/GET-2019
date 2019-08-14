
SELECT p.productName, o.orderDate
FROM product AS p, orders AS o
WHERE o.productId = p.productId AND p.price > 20 AND p.price < 50;

