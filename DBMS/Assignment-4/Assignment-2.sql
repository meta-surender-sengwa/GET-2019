
USE ShopFront;


# Assignment-2

#(1). Create a Stored procedure to retrieve average sales of each product in a month.
#     Month and year will be input parameter to function.

DROP PROCEDURE IF EXISTS avg_sales_in_month;

DELIMITER $$
CREATE PROCEDURE avg_sales_in_month (IN input_month INT, IN input_year INT )
BEGIN
    SELECT 
        product.id AS ID, 
        product.name, 
        (SUM(orders.quantity) / COUNT(productId)) AS "Average Sales" 
    FROM product, orders
    WHERE YEAR(date) = input_year
    AND MONTH(date) = input_month;
END $$

CALL avg_sales_in_month(8, 2019);


#(2). Create a stored procedure to retrieve table having order detail with status for a given period. 
#     Start date and end date will be input parameter. Put validation on input dates like start date is less than end date.
#     If start date is greater than end date take first date of month as start date.

DROP PROCEDURE IF EXISTS order_details_in_period;

DELIMITER ^^
CREATE PROCEDURE order_details_in_period (
    IN start_date DATE,
    IN end_date DATE )
BEGIN
    SELECT 
        orders.Id AS 'Order ID',
        product.Id AS 'Product ID',
        product.name AS 'Product Name',
        DATE(orders.date) AS 'Order date',
        orderStatus.status AS 'Order status'
    FROM orders
    
    RIGHT JOIN orderStatus
    ON orders.id = orderStatus.id
    
    LEFT JOIN product
    ON orders.productId = product.id
    
    WHERE DATE(orders.date)
        BETWEEN 
            start_date AND end_date
    ORDER BY date;
END ^^


CALL order_details_in_period( STR_TO_DATE("2019-07-08", "%Y-%m-%d"), CURDATE());
