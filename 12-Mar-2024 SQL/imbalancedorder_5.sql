-- Create the OrderDetails table
CREATE TABLE OrderDetails (
    order_id INT,
    product_id INT,
    quantity INT
);

-- Insert data into the OrderDetails table
INSERT INTO OrderDetails (order_id, product_id, quantity) VALUES
(1, 1, 12),
(1, 2, 10),
(1, 3, 15),
(2, 1, 8),
(2, 4, 4),
(2, 5, 6),
(3, 3, 5),
(3, 4, 18),
(4, 5, 2),
(4, 6, 8),
(5, 7, 9),
(5, 8, 9),
(3, 9, 20),
(2, 9, 4);

WITH Average AS (
    SELECT 
		 order_id,
        AVG(quantity) AS average_quantity,
        max(quantity) as max_quantity
    FROM 
        OrderDetails
    GROUP BY 
        order_id
)
SELECT 
    order_id
FROM 
    Average a
where max_quantity > All (select average_quantity from average);
