package com.example.student.aspect;

import com.alibaba.fastjson.JSON;
import com.example.student.api.dto.Student;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Slf4j
@Aspect
@Component
public class LogAspect {
    private final Logger logger = LoggerFactory.getLogger(LogAspect.class);
    @Pointcut("execution(public * com.example.student.controller.*.*(..)) && @annotation(com.example.student.aspect.InsertLog)")
    public void addAdvice(){}
    @Around("addAdvice()")
    public Object Interceptor(ProceedingJoinPoint pjp){
        Object result = null;
        Object[] args = pjp.getArgs();
        if(args != null && args.length >0) {
            Student student  = (Student)args[0];
            if (student != null){
                logger.debug("切面插入操作日志{}", JSON.toJSONString(student));
                System.out.println("切面插入操作日志");
            }
        }
        return result;
    }

}
