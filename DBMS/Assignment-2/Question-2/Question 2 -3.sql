
SELECT DISTINCT productName FROM product 
WHERE productId NOT IN(SELECT productId FROM images);
