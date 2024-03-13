CREATE TABLE Customers (
    customer_id INT,
    name VARCHAR(255)
);

INSERT INTO Customers (customer_id, name) VALUES
(1, 'Alice'),
(2, 'Bob'),
(3, 'Tom'),
(4, 'Jerry'),
(5, 'John');

select * from customers;


CREATE TABLE Orders (
    order_id INT,
    order_date DATE,
    customer_id INT,
    product_id INT
);

INSERT INTO Orders (order_id, order_date, customer_id, product_id) VALUES
(1, '2020-07-31', 1, 1),
(2, '2020-07-30', 2, 2),
(3, '2020-08-29', 3, 3),
(4, '2020-07-29', 4, 1),
(5, '2020-06-10', 1, 2),
(6, '2020-08-01', 2, 1),
(7, '2020-08-01', 3, 3),
(8, '2020-08-03', 1, 2),
(9, '2020-08-07', 2, 3),
(10, '2020-07-15', 1, 2);

select * from orders;

CREATE TABLE Products (
    product_id INT,
    product_name VARCHAR(255),
    price INT
);


INSERT INTO Products (product_id, product_name, price) VALUES
(1, 'keyboard', 120),
(2, 'mouse', 80),
(3, 'screen', 600),
(4, 'hard disk', 450);

select * from products;

WITH RankedOrders AS (
    SELECT 
        customer_id,
        product_id,
      -- count(product_id) as product_count,
        RANK() OVER (PARTITION BY customer_id ORDER BY COUNT(product_id) DESC) AS ranking
    FROM 
        Orders
    GROUP BY 
        customer_id, product_id
)
SELECT 
    r.customer_id,
    r.product_id,
    p.product_name
   -- r.product_count
FROM 
    RankedOrders r
JOIN 
    Products p ON r.product_id = p.product_id
WHERE 
    ranking = 1
    
order by  customer_id;
