select  *
from    employee emp,
        issue iss
where   emp.emp_id = iss.assigned_to