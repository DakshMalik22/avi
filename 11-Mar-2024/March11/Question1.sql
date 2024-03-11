use avisoft;
CREATE TABLE Playback (
    session_id INT PRIMARY KEY,
    customer_id INT ,
    start_time INT,
    end_time INT
); 


INSERT INTO Playback (session_id, customer_id, start_time, end_time) 
VALUES 
    (1, 1, 1, 5),
    (2, 1, 15, 23),
    (3, 2, 10, 12),
    (4, 2, 17, 28),
    (5, 2, 2, 8);
    select * from playback;
  CREATE TABLE Ads (
    ad_id INT PRIMARY KEY,
    customer_id INT,
    timestamp INT
);
INSERT INTO Ads (ad_id, customer_id, timestamp) 
VALUES 
    (1, 1, 5),
    (2, 2, 17),
    (3, 2, 20);
    
    select * from Ads;
    
SELECT p.session_id
FROM Playback AS p
LEFT JOIN Ads AS a ON p.customer_id = a.customer_id
                   AND a.timestamp BETWEEN p.start_time AND p.end_time
GROUP BY p.session_id
HAVING COUNT(a.ad_id) = 0;

    

