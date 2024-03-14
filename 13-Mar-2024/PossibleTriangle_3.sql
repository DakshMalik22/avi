-- Create the table
CREATE TABLE example_table (
    x INT,
    y INT,
    z INT
);

-- Insert data into the table
INSERT INTO example_table (x, y, z)
VALUES
    (13, 15, 30),
    (10, 20, 15),
    (15,18,19);
    
    select x,y,z,
    case when x+y>z and x+z>y and y+z>x then 'Yes'
    else 'NO'
    end as Triangle
    from example_table;
