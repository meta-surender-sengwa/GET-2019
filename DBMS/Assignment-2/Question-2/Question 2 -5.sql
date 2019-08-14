
 SELECT sc.subCategoryId AS CategoryId, sc.subCategoryName AS CategoryName, c.categoryName AS ParentCategory 
 FROM subCategory AS sc, category AS c 
 WHERE sc.categoryId = c.CategoryId;
