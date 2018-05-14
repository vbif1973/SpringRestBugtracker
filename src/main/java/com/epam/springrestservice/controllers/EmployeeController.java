package com.epam.springrestservice.controllers;


import com.epam.springrestservice.model.Employee;
import com.epam.springrestservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value ="/allemployees", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Employee> getAllEmployees(){
        List<Employee> employees = employeeService.listEmployees();
        return employees;
    }

    @RequestMapping(value="/getemployeebyid/{empId}", method = RequestMethod.GET)
    @ResponseBody
    public Employee getEmployeeById(@PathVariable Integer empId) {
        return employeeService.getEmployeeById(empId);
    }

    @RequestMapping(value="/deleteemployeebybd/{empId}", method = RequestMethod.GET)
    @ResponseBody
    public Employee deleteEmployeeById(@PathVariable Integer empId) {
        return employeeService.deleteEmployeeById(empId);
    }

    @RequestMapping(value="/addemployee/{name}", method = RequestMethod.GET)
    @ResponseBody
    public Employee addEmployee(@PathVariable String name) {
        return employeeService.addEmployee(name);
    }

    @RequestMapping(value="/updateemployee/{empId}/{name}", method = RequestMethod.GET)
    @ResponseBody
    public Employee updateEmployee(@PathVariable Integer empId, @PathVariable String name) {
        return employeeService.updateEmployee(empId, name);
    }
}
