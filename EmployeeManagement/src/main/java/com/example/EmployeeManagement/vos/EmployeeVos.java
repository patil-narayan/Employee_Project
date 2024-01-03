package com.example.EmployeeManagement.vos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeVos {

    private String id;

    private  String userId;

    private  String password;

    private  String firstName;

    private String lastName;

    private String emailId;

    private String mobile;

}
