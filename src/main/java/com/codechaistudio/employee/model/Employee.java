package com.codechaistudio.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties("department")
public class Employee {

    private String employeeId;

    private String firstName;

    private String lastName;
    private String department;

    private String emailId;


}
