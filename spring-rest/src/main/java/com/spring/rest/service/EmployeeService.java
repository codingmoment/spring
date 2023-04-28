package com.spring.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.rest.domain.Employee;
import com.spring.rest.repository.EmployeeRepository;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @GetMapping
  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

  public Employee getEmployeeDetails(Long employeeId) {
    Optional<Employee> eOptional = employeeRepository.findById(employeeId);
    if (eOptional.isPresent()) {
      return eOptional.get();
    }
    return null;
  }

  public Employee createEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }

  public Employee updateEmployee(Long employeeId, Employee employee) {
    Optional<Employee> eOptional = employeeRepository.findById(employeeId);
    if (eOptional.isPresent()) {
      Employee dbEmployee = eOptional.get();
      dbEmployee.setFirstName(employee.getFirstName());
      dbEmployee.setLastName(employee.getLastName());
      dbEmployee.setEmail(employee.getEmail());
      return employeeRepository.save(dbEmployee);
    }
    return null;
  }

  public void deleteEmployee(Long employeeId) {
    employeeRepository.deleteById(employeeId);
  }
}
