package com.example.EmployeeManagement.Service;

import com.example.EmployeeManagement.Entity.Employee;
import com.example.EmployeeManagement.vos.EmployeeVos;

import java.util.List;

public interface EmployeeManagementService {

    EmployeeVos saveUser(Employee employee);

    String authenticateUser(String userId , String password);

    List<Employee> getAllUser();

    List<Employee> getUserById(String userId , String emailId,String mobileNumber);

    String deleteUserById(String userId);

    EmployeeVos updateUser(String id, String firstName, String lastName, String emailId);

}
