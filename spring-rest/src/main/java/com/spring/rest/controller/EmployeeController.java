package com.spring.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.domain.Employee;
import com.spring.rest.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping
  public List<Employee> getAllEmployees() {
    return employeeService.getAllEmployees();
  }

  @GetMapping("/{employeeId}")
  public Employee getEmployeeDetails(@PathVariable("employeeId") Long employeeId) {
    return employeeService.getEmployeeDetails(employeeId);
  }

  @PostMapping
  public Employee createEmployee(@RequestBody Employee employee) {
    return employeeService.createEmployee(employee);
  }

  @PutMapping("/{employeeId}")
  public Employee updateEmployee(@PathVariable("employeeId") Long employeeId, @RequestBody Employee employee) {
    return employeeService.updateEmployee(employeeId, employee);
  }

  @DeleteMapping("/{employeeId}")
  public void deleteEmployee(@PathVariable("employeeId") Long employeeId) {
    employeeService.deleteEmployee(employeeId);
  }

}
