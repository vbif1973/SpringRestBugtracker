package com.epam.springrestservice.dao.impl;

import com.epam.springrestservice.dao.AbstractDao;
import com.epam.springrestservice.dao.EmployeeDAO;
import com.epam.springrestservice.model.Employee;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl extends AbstractDao<Integer, Employee> implements EmployeeDAO {

    public List<Employee> listEmployees() {
        Criteria criteria = createEntityCriteria();
        List<Employee> employees = (List<Employee>) criteria.list();
        return employees;
    }

    public Employee getEmployeeById(Integer empId) {
        Employee employee = getByKey(empId);
        return employee;
    }

    public Employee deleteEmployeeById(Integer empId) {
        Employee employee = getByKey(empId);
        delete(employee);
        return employee;
    }

    public Employee addEmployee(String name) {
        Employee employee = new Employee();
        employee.setEmp_name(name);
        save(employee);
        return getByKey(employee.getEmp_id());
    }

    public Employee updateEmployee(Integer empId, String name) {
        Employee employee = getByKey(empId);
        employee.setEmp_name(name);
        save(employee);
        return getByKey(employee.getEmp_id());
    }
}
