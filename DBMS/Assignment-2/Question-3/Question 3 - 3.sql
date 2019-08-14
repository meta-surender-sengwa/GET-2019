
SELECT orderId
FROM orders
WHERE DATEDIFF(CURDATE(),orderDate) > 10;
