package com.epam.springrestservice.controllers;


import com.epam.springrestservice.dto.EmployeeDTO;
import com.epam.springrestservice.model.Employee;
import com.epam.springrestservice.service.EmployeeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value ="/employee")
public class EmployeeController {

    private static final Logger logger = Logger.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value ="/allemployees", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Employee> getAllEmployees(){
        logger.info("EmployeeController.getAllEmployees called");
        List<Employee> employees = employeeService.listEmployees();
        return employees;
    }

    @RequestMapping(value="/getemployeebyid/{empId}", method = RequestMethod.GET)
    @ResponseBody
    public Employee getEmployeeById(@PathVariable Integer empId) {
        logger.info("EmployeeController.getEmployeeById called");
        return employeeService.getEmployeeById(empId);
    }

    @RequestMapping(value="/deleteemployeebyid/{empId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Employee deleteEmployeeById(@PathVariable Integer empId) {
        logger.info("EmployeeController.deleteEmployeeById called");
        return employeeService.deleteEmployeeById(empId);
    }

    @RequestMapping(value="/addemployee", method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Employee addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        logger.info("EmployeeController.addEmployee called");
        String empName = employeeDTO.getEmpName();
        return employeeService.addEmployee(empName);
    }

    @RequestMapping(value="/updateemployee/{empId}", method = RequestMethod.PUT, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Employee updateEmployee(@PathVariable Integer empId, @RequestBody EmployeeDTO employeeDTO) {
        logger.info("EmployeeController.addEmployee called");
        String empName = employeeDTO.getEmpName();
        return employeeService.updateEmployee(empId, empName);
    }
}
