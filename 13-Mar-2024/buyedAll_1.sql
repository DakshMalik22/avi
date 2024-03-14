
create table customer (
customer_id int,
product_key int);
 
INSERT INTO Customer (customer_id, product_key)
VALUES
    (1, 5),
    (2, 6),
    (3, 5),
    (3, 6),
    (1, 6);
    
    create table product (
    product_key int);
    
    insert into product()
    values
    (5),
    (6);
    
 
 -- querry   
SELECT customer_id
FROM Customer
GROUP BY customer_id
HAVING COUNT(DISTINCT product_key) = (SELECT COUNT(*) FROM Product);





    

 
