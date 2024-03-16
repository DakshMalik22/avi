-- table employee is already created

select first_name ,last_name ,Hire_date
from
(
  select * 
  from employees 
  where hire_date > (select hire_date from employees where last_name ='jones')
  )as reuslt;
