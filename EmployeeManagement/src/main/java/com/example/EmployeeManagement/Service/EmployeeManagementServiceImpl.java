package com.example.EmployeeManagement.Service;

import com.example.EmployeeManagement.DAO.EmployeeRepository;
import com.example.EmployeeManagement.Entity.Employee;
import com.example.EmployeeManagement.util.ConvertVotoDO;
import com.example.EmployeeManagement.vos.EmployeeVos;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeManagementServiceImpl implements EmployeeManagementService{

   private final EmployeeRepository employeeRepository;

  //  private final PasswordEncoder passwordEncoder;

   private final ConvertVotoDO convertVotoDO;

    @Override
    public EmployeeVos saveUser(Employee employee) {
        EmployeeVos employeeVos =null;
       try {
           Employee emp = employeeRepository.save(employee);
           /*if(emp != null && !emp.getPassword().isEmpty()){
               emp.setPassword(passwordEncoder.encode(emp.getPassword()));

           }*/

           employeeVos = convertVotoDO.convertToVo(emp);
       }catch (Exception e){
           log.info("Error While Adding Data", e);
       }
        return employeeVos;
    }

    @Override
    public String authenticateUser(String userId, String password) {

         Optional<Employee> emp  = employeeRepository.findByUserId(userId);
        String str = null;
         try {
            /* if (emp != null && !emp.get().getUserId().isEmpty() && !emp.get().getPassword().isEmpty()) {

                 String decryptedPassword = decryptPassword(emp.get().getPassword());*/
                 if (userId.equals(emp.get().getUserId()) && password.equals(emp.get().getPassword())) {
                     str = "User Logged in SuccessFully";
                 }else {
                     str = "In-Valid UserId OR Password";
                 }
                 //passwordEncoder.matches(password, decryptedPassword);
            // }
         }catch (Exception e){
             log.error("Error while logging IN");
         }
        return str;
    }

   /* private String decryptPassword(String encryptedPassword) {
        // Note: Decryption is generally not recommended for password storage
        // This is a simple example and should not be used in production

        byte[] decodedBytes = Base64.getDecoder().decode(encryptedPassword);
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }*/

    @Override
    public List<Employee> getAllUser() {
     //EmpolyeeVos empolyeeVos =null;
     List<Employee> employee =  employeeRepository.findAll();

        return employee;
    }

    @Override
    public List<Employee> getUserById(String userId , String emailId,String mobileNumber) {

      List<Employee> employee = employeeRepository.findByUserIdOrEmailIdOrMobile(userId,emailId,mobileNumber);
      Employee employee1 = new Employee();
      /*for(Employee emp : employee){
          employee1 = emp;
      }*/
     // EmpolyeeVos empolyeeVos = convertVotoDO.convertToVo(employee);

        return employee;
    }

    @Override
    public String deleteUserById(String userId) {
        try {
            employeeRepository.findByUserId(userId);
            return "User Deleted Successfully";
        } catch (EmptyResultDataAccessException ex) {
            log.error("User with ID {} not found for deletion", userId);
            return "User Not Found";
        } catch (Exception ex) {
            log.error("Error while deleting user with ID {}", userId, ex);
            return "Error Deleting User";
        }
    }

    @Override
    public EmployeeVos updateUser(String userId, String firstName, String lastName, String emailId) {
         Optional<Employee> emp = employeeRepository.findByUserId(userId);
        Employee emp1 = new Employee();

         if(!emp.isEmpty() && emp !=null && userId.equals(emp.get().getUserId())) {
             emp1.setUserId(userId);
             if(firstName!= null && !firstName.isEmpty()) {
                 emp1.setFirstName(firstName);
             }
             if(lastName != null && !lastName.isEmpty()) {
                 emp1.setLastName(lastName);
             }
             if(emailId!= null && !emailId.isEmpty()) {
                 emp1.setEmailId(emailId);
             }
         }else {
             log.info("User Not found for Provided Id");
         }
        Employee employee = employeeRepository.save(emp1);

       EmployeeVos employeeVos = convertVotoDO.convertToVo(employee);

        return employeeVos;
    }
}
