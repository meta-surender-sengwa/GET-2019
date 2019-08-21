
USE ShopFront;


# Assignment-1

#(1). Create a function to calculate number of orders in a month. Month and year will be input parameter to function.

DROP FUNCTION IF EXISTS get_no_of_orders;

DELIMITER $$
CREATE FUNCTION get_no_of_orders(input_month INT,input_year INT)
RETURNS INT
DETERMINISTIC 
BEGIN
    DECLARE no_of_orders INT;
    SELECT COUNT(ID) 
    INTO no_of_orders 
    FROM orders 
    WHERE EXTRACT(MONTH FROM date) = INPUT_month 
    AND EXTRACT(YEAR FROM date) = input_year;
    RETURN no_of_orders;
END $$


SELECT YEAR(STR_TO_DATE("2019", "%Y")) AS "Year",
    MONTHNAME(STR_TO_DATE("AUGUST", "%M")) AS "Month",
    get_no_of_orders(08,2019) AS "Total Orders";
    

#(2). Create a function to return month in a year having maximum orders. Year will be input parameter.

DROP FUNCTION IF EXISTS get_month_with_maximum_orderss;

DELIMITER $$
CREATE FUNCTION get_month_with_maximum_orderss(input_year INT)
RETURNS VARCHAR(10)
DETERMINISTIC 
BEGIN
    DECLARE result_month VARCHAR(10);
    
    SELECT MONTHNAME(date)
    INTO result_month
    FROM orders
    WHERE YEAR(date) = 2019
    GROUP BY MONTH(date)
    ORDER BY COUNT(*)
    LIMIT 1;
    
    RETURN result_month;
END $$

SELECT get_month_with_maximum_orderss(2018) AS "month with max orders in 2018";




