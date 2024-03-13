CREATE TABLE Employee (
    empId INT PRIMARY KEY,
    name VARCHAR(255),
    supervisor INT,
    salary INT
);

-- Insert data into the Employee table
INSERT INTO Employee (empId, name, supervisor, salary) VALUES
(1, 'John', 3, 1000),
(2, 'Dan', 3, 2000),
(3, 'Brad', NULL, 4000),
(4, 'Thomas', 3, 4000);


select * from employee;

-- Create the Bonus table
CREATE TABLE Bonus (
    empId INT PRIMARY KEY,
    bonus INT
);

-- Insert data into the Bonus table
INSERT INTO Bonus (empId, bonus) VALUES
(2, 500),
(4, 2000);

select * from bonus;

select e.empID,  b.bonus
from Employee e
left join bonus b
on e.empid=b.empid
where coalesce(b.bonus,0) < 1000;
