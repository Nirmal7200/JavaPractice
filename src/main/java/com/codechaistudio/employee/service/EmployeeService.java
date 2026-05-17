package com.codechaistudio.employee.service;

import com.codechaistudio.employee.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(String id);

    String deleteEmployeeById(String id);
}
