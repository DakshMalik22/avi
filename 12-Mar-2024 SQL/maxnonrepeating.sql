-- Create the table
CREATE TABLE Numbers (
    num INT
);

-- Insert data into the table
INSERT INTO Numbers (num) VALUES
(8),
(8),
(3),
(3),
(1),
(4),
(5),
(6);

select * from numbers;

SELECT MAX(num) as maxnonrepating
from (
    SELECT num
    FROM Numbers
    GROUP BY num
    HAVING COUNT(num) = 1
) as result
