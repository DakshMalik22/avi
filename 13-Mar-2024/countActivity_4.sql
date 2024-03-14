
-- Create Friends table
CREATE TABLE Friends (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    activity VARCHAR(50)
);

-- Insert data into Friends table
INSERT INTO Friends (id, name, activity)
VALUES
    (1, 'Jonathan D.', 'Eating'),
    (2, 'Jade W.', 'Singing'),
    (3, 'Victor J.', 'Singing'),
    (4, 'Elvis Q.', 'Eating'),
    (5, 'Daniel A.', 'Eating'),
    (6, 'Bob B.', 'Horse Riding');
    
    
    -- Create Activities table
CREATE TABLE Activities (
    id INT PRIMARY KEY,
    name VARCHAR(50)
);

-- Insert data into Activities table
INSERT INTO Activities (id, name)
VALUES
    (1, 'Eating'),
    (2, 'Singing'),
    (3, 'Horse Riding');
    

   


SELECT activity
FROM Friends
GROUP BY activity
HAVING COUNT(activity) <> (
    SELECT COUNT(activity) FROM Friends GROUP BY activity ORDER BY COUNT(activity) DESC LIMIT 1
) AND COUNT(activity) <> (
    SELECT COUNT(activity) FROM Friends GROUP BY activity ORDER BY COUNT(activity) ASC LIMIT 1
);

-- using with
WITH ActivityCounts AS (
    SELECT activity, COUNT(*) AS count_activity
    FROM Friends
    GROUP BY activity
)
SELECT activity
FROM ActivityCounts
WHERE count_activity <> (
    SELECT MAX(count_activity) FROM ActivityCounts
) AND count_activity <> (
    SELECT MIN(count_activity) FROM ActivityCounts
);

WITH ActivityCounts AS (
    SELECT activity, COUNT(*) AS count_activity
    FROM Friends
    GROUP BY activity
)
SELECT activity
FROM ActivityCounts
WHERE count_activity not in (select max(count_activity) from ActivityCounts union select min(count_activity) from ActivityCounts);
   




    
    
    
