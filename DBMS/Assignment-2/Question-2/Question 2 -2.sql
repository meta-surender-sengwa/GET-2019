
SELECT  p.productId, p.productName, c.categoryId, p.price 
FROM product AS p, subCategory AS c 
WHERE p.subCategoryId = c.subCategoryId;
