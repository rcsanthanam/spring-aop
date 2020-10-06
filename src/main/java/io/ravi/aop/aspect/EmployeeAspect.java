package io.ravi.aop.aspect;

import io.ravi.aop.dto.EmployeeDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class EmployeeAspect {

    @Before("execution(* io.ravi.aop.service.EmployeeManager.getEmployeeById(..))")
    public void logBeforeV1(JoinPoint joinPoint){
        System.out.printf("Log before V1 : %s\n",joinPoint.getSignature().getName());
    }

    @After("execution(* io.ravi.aop.service.EmployeeManager.getEmployeeById(..))")
    public void logAfterV1(JoinPoint joinPoint){
        System.out.printf("Log after V1 : %s\n",joinPoint.getSignature().getName());
    }

    @Around("execution(* io.ravi.aop.service.EmployeeManager.getEmployeeById(..))")
    public void logAroundV1(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.printf("Around : before method execution : %s\n",joinPoint.getSignature().getName());
        try{
            joinPoint.proceed();
        }catch (Exception e){

        }finally {
            System.out.println("Finally block..");
        }
        System.out.printf("Around : after method execution : %s\n",joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* io.ravi.aop.service.EmployeeManager.getEmployeeById(..))")
    public void logAfterReturning(){
        System.out.println("After returning");
    }

    @AfterReturning(pointcut = "execution(* io.ravi.aop.service.EmployeeManager.getEmployeeById(..))",returning = "value")
    public void logAfterReturning(Object value){
        if(value instanceof EmployeeDto){
            System.out.println("Returned value is employee dto");
        }
        System.out.println("After returning with return type");
    }

    @AfterThrowing(pointcut = "execution(* io.ravi.aop.service.EmployeeManager.getEmployeeById(..))",throwing = "ex")
    public void logAfterThrowing(Exception ex){
        System.out.println("After throwing exception :: "+ex.getMessage());
    }
}
