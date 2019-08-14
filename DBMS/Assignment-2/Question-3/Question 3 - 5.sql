
SELECT u.userName, o.orderId
FROM user AS u, orders AS o
WHERE u.userId = o.shopperId AND DATEDIFF(CURDATE(), o.orderDate) < 15;
