use avisoft;
CREATE TABLE Person (
    PersonId INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(255),
    LastName VARCHAR(255)
);
select* from person;
create table address(
AdderssId INT PRIMARY KEY AUTO_INCREMENT,
PersonId INT,
FOREIGN KEY (PersonId) REFERENCES Person(PersonId),
City varchar(255),
State varchar(255)
);
select* from address;
INSERT INTO Person (FirstName, LastName) VALUES
('John', 'Doe'),
('Jane', 'Smith'),
('Michael', 'Johnson');
select* from person;

INSERT INTO Address (PersonId, City, State) VALUES
(1, 'New York', 'NY'),
(2, 'Los Angeles', 'CA');
select* from address;

select p.FirstName,p.LastName,a.City,a.State from Person p LEFT JOIN address a on p.PersonId = a.PersonId;