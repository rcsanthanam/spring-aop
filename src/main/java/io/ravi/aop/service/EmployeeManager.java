package io.ravi.aop.service;

import io.ravi.aop.dto.EmployeeDto;
import org.springframework.stereotype.Component;

@Component
public class EmployeeManager {

    public EmployeeDto getEmployeeById(int employeeId){
        System.out.println("Employee Manager : employee method called..");
        return new EmployeeDto();
    }
}
