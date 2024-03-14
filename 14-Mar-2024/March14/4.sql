select a.employee_id as emp_id , a.last_name as employee ,a.manager_id,b.last_name from employees as a join 
employees as b on a.manager_id = b.employee_id order by a.employee_id;  