package com.epam.springrestservice.dao;

import com.epam.springrestservice.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> listEmployees();

    Employee getEmployeeById(Integer empId);

    Employee deleteEmployeeById(Integer empId);

    Employee addEmployee(String name);

    Employee updateEmployee(Integer empId, String name);

}
