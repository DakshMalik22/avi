-- table Departments ,employees , location are already created
 
 -- querry
select d.department_name,e.first_name,l.city
from departments d
join employees e
on d.manager_id =e.EMPLOYEE_ID
join locations l
on d.location_id=l.location_id
order by d.department_id;
