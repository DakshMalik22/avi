-- tbale Employees, Departments are already created

select  d.department_name as Department_Name , count(e.Employee_id) as "No of Employees"
from employees e
join departments d
on e.department_id=d.department_id
group by e.department_id
order by d.department_name;
