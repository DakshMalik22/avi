use practise;
-- Create the Accounts table
CREATE TABLE Accounts (
    account_id INT PRIMARY KEY,
    income INT
);

-- Insert data into the Accounts table
INSERT INTO Accounts (account_id, income) VALUES
(3, 108939),
(2, 12747),
(8, 87709),
(6, 91796);

-- check weather data is inserted into the table
select * from accounts;


-- querry
SELECT 
    CASE 
        WHEN income < 20000 THEN 'Low Salary'
        WHEN income BETWEEN 20000 AND 50000 THEN 'Average Salary'
        ELSE 'High Salary'
    END AS category,
    COUNT(account_id)  as accounts_count
FROM 
    Accounts
GROUP BY 
    CASE 
        WHEN income < 20000 THEN 'Low Salary'
        WHEN income BETWEEN 20000 AND 50000 THEN 'Average Salary'
        ELSE 'High Salary'
    END;
    
    
