package com.epam.springrestservice.service;

import com.epam.springrestservice.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

    public List<Employee> listEmployees();

    public Employee getEmployeeById(Integer empId);

    public Employee deleteEmployeeById(Integer empId);

    public Employee addEmployee(String name);

    public Employee updateEmployee(Integer empId, String name);
}
