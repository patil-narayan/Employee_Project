package com.example.EmployeeManagement.Controller;

import com.example.EmployeeManagement.Entity.Employee;
import com.example.EmployeeManagement.Service.EmployeeManagementService;
import com.example.EmployeeManagement.vos.EmployeeVos;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
@Slf4j
public class EmployeeManagementController {

      private final EmployeeManagementService employeeManagementService;

     @PostMapping(value = "/user")
        public EmployeeVos saveUser(@RequestBody Employee employee){
         log.info("Inside Save User API {}",employee);

        EmployeeVos employeeVos = employeeManagementService.saveUser(employee);

         return employeeVos;

        }

        @PostMapping(value = "/login")
        public String authenticateUser(@RequestParam(required = true) String userId, @RequestParam(required = true) String password){
         log.info("Inside Authenticate User");

        String str = employeeManagementService.authenticateUser(userId , password);

         return  str;
        }

       @GetMapping(value = "/users")
      public List<Employee> getAllUser(){

           List<Employee> employeesList = employeeManagementService.getAllUser();

         return employeesList;

       }

       @GetMapping(value = "/user")
      public List<Employee> getUserById(@RequestParam(required = false) String userId, @RequestParam(required = false) String emailId, @RequestParam(required = false) String mobileNumber){
          List<Employee>  employeeVos =null;
         try {
            employeeVos = employeeManagementService.getUserById(userId,emailId,mobileNumber);

         }catch (Exception e){
             log.error("Error While getting {} ",e);
         }
         return employeeVos;

       }

       @DeleteMapping(value = "/user/{id}")
       public String deleteUserById(@PathVariable("id") String id){

         String str= employeeManagementService.deleteUserById(id);

         return str;

       }

       @PutMapping(value = "/user/{id}")
       public EmployeeVos updateUser(@PathVariable("id") String id, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String emailId){

        EmployeeVos employeeVos = employeeManagementService.updateUser(id,firstName,lastName,emailId);

         return employeeVos;

       }

}
