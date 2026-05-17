package com.codechaistudio.employee.service;

import com.codechaistudio.employee.model.Employee;
import com.codechaistudio.employee.error.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    List<Employee> employeeList = new ArrayList<>();


    @Override
    public Employee save(Employee employee) {

        if (employee.getEmployeeId() ==null || employee.getEmailId().isEmpty()){
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employeeList.add(employee);

        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeList.stream()
                           .filter(s -> s.getEmployeeId()
                            .equals(id)).findFirst()
                            .orElseThrow(()-> new EmployeeNotFoundException("Employee not found with id "+ id));
    }

    @Override
    public String deleteEmployeeById(String id) {
        Employee delete = employeeList.stream().filter(emp -> emp.getEmployeeId().equals(id)).findFirst().orElseThrow(()-> new EmployeeNotFoundException("Employee not found with id "+ id));

                employeeList.remove(delete);

                return "Employee deleted successfully";

    }


}
