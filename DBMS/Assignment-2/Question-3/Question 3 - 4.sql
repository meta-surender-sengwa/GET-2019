
SELECT userName
FROM user 
WHERE userId NOT IN (
    SELECT shopperId 
    FROM orders 
    WHERE DATEDIFF(CURDATE(), orderDate) < 30
);
