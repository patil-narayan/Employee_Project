package com.example.EmployeeManagement.util;

import com.example.EmployeeManagement.Entity.Employee;
import com.example.EmployeeManagement.vos.EmployeeVos;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class ConvertVotoDO {

   private final ModelMapper modelMapper;

   public EmployeeVos convertToVo(Employee employee){
     return  modelMapper.map(employee, EmployeeVos.class);
   }
    public EmployeeVos convertToVo(List<Employee> employee){
        return  modelMapper.map(employee, EmployeeVos.class);
    }
    public EmployeeVos convertToVo(Optional<Employee> employee){
        return  modelMapper.map(employee, EmployeeVos.class);
    }

    public EmployeeVos convertToVos(List<Employee> employee){
        EmployeeVos employeeVos =null;
      for(Employee employee1 :employee){
          employeeVos = modelMapper.map(employee, EmployeeVos.class);
       }
        return employeeVos;
    }
}
