-- Create the table

CREATE TABLE submissions (
    sub_id INT,
    parent_id INT
);

-- Insert the data
INSERT INTO submissions (sub_id, parent_id) VALUES
    (1, NULL),
    (2, NULL),
    (1, NULL),
    (12, NULL),
    (3, 1),
    (5, 2),
    (3, 1),
    (4, 1),
    (9, 1),
    (10, 2),
    (6, 7);
    
WITH result AS (
    SELECT DISTINCT sub_id AS post
    FROM submissions
    WHERE parent_id IS NULL
)
 
 SELECT r.post AS post_id,
   COUNT(DISTINCT(s.sub_id)) AS number
FROM result r
LEFT JOIN submissions s ON r.post = s.parent_id
group by r.post;
