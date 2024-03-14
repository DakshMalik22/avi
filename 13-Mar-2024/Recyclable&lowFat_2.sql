-- Create Products table
CREATE TABLE Products (
    product_id INT PRIMARY KEY,
    low_fats CHAR(1),
    recyclable CHAR(1)
);

-- Insert data into Products table
INSERT INTO Products (product_id, low_fats, recyclable)
VALUES
    (0, 'Y', 'N'),
    (1, 'Y', 'Y'),
    (2, 'N', 'Y'),
    (3, 'Y', 'Y'),
    (4, 'N', 'N');
    
    -- querry 
    
    select product_id 
    from products 
    where low_fats='y' and recyclable ='y';
    
    
    
