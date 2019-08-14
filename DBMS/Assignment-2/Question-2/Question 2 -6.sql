

SELECT p.productName, p.price, p.description 
FROM product AS p, subCategory AS s
WHERE p.subCategoryId = s.subCategoryId AND s.categoryId = 602;

