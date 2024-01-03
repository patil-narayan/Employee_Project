package com.example.EmployeeManagement.DAO;

import com.example.EmployeeManagement.Entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee,String> {

     List<Employee> findByUserIdOrEmailIdOrMobile(String userId, String emailId, String mobileNumber);
     Optional<Employee> findByUserId(String userId);
}
