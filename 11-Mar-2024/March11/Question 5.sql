CREATE TABLE Orders (
    order_number INT PRIMARY KEY,
    customer_number INT
);
INSERT INTO Orders (order_number, customer_number)
VALUES 
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 3);

select customer_number from orders group by customer_number  order by count(*) desc limit 1;