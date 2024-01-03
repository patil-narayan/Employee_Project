package com.example.EmployeeManagement.Entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.NumberFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Employee {

    @Id
    private String id;

    @NotEmpty(message = "User Id Cannot be Empty")
    private  String userId;

    @NotEmpty(message = "User Id Cannot be Empty")
    private  String password;

    private  String firstName;
    private String lastName;

    @NotEmpty(message = "Email Id can not be null")
    @Email(message = "Invalid Email format ")
    private String emailId;

    @Size(min = 10, max = 10, message = "Mobile number must be 10 characters")
    private String mobile;
}
