package io.ravi.aop;

import io.ravi.aop.service.EmployeeManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringAopApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringAopApplication.class, args);
		EmployeeManager employeeManager = context.getBean(EmployeeManager.class);
		employeeManager.getEmployeeById(1);
	}

}
