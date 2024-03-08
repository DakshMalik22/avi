Use avisoft;


create table World(
name varchar(255),
continent varchar(255),
area int,
population int,
gdp int
);

SELECT * FROM world;

SELECT * FROM avisoft.world;
INSERT INTO world (name, continent, area, population, gdp)
VALUES 
    ('Afghanistan', 'Asia', 652230, 25500100, 20343000),
    ('Albania', 'Europe', 28748, 2831741, 12960000),
    ('Algeria', 'Africa', 2381741, 37100000, 188681000),
    ('Andorra', 'Europe', 468, 78115, 3712000),
    ('Angola', 'Africa', 1246700, 20609294, 100990000);
    select* from world;
    
    SELECT name,population,area from world where area>3000000 OR population>25000000;