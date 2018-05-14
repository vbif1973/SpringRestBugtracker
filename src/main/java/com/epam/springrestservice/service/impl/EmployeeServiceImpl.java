package com.epam.springrestservice.service.impl;

import com.epam.springrestservice.dao.EmployeeDAO;
import com.epam.springrestservice.model.Employee;
import com.epam.springrestservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Transactional
    public List<Employee> listEmployees() {
        return  employeeDAO.listEmployees();
    }

    @Transactional
    public Employee getEmployeeById(Integer empId) {
        return employeeDAO.getEmployeeById(empId);
    }

    @Transactional
    public Employee deleteEmployeeById(Integer empId) {
        return employeeDAO.deleteEmployeeById(empId);
    }

    @Transactional
    public Employee addEmployee(String name) {
        return employeeDAO.addEmployee(name);
    }

    @Transactional
    public Employee updateEmployee(Integer empId, String name) {
        return employeeDAO.updateEmployee(empId, name);
    }
}
