use avisoft;

CREATE TABLE GameScore (
    id INT ,
    score float
);

INSERT INTO GameScore
VALUES 
    (1, 3.50),
    (2, 3.65),
    (3, 4.00),
    (4, 3.85),
    (5, 4.00),
    (6, 3.65);
    select *  from gamescore;
 
    SELECT s1.score ,
       (SELECT COUNT(DISTINCT s2.score ) 
        FROM GameScore s2 
        WHERE s2.score  >= s1.score ) AS 'Rank'
FROM GameScore s1
ORDER BY score  DESC;
