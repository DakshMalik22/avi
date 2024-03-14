with result as( 
select d.department_id from departments d join locations l on d.location_id = l.location_id where city="London"
)

select e.first_name,e.last_name,e.job_id,e.department_id from employees e join result r on e.department_id = r.department_id;

SELECT e.first_name, e.last_name, e.job_id, e.department_id, d.department_name
FROM employees e
JOIN departments d ON e.department_id = d.department_id
JOIN locations l ON d.location_id = l.location_id
WHERE l.city = 'London';
