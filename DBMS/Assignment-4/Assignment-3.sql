
USE ShopFront;
SHOW TABLES;

# 1. Orders
ALTER TABLE usersOrder ADD INDEX user_id_index(userId);


# 2. Product
ALTER TABLE product ADD INDEX product_name_index(name);


# 3. Category
ALTER TABLE subCategory ADD INDEX parent_id_index(categoryId);