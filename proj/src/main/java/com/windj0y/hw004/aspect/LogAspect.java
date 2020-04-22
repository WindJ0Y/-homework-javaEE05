package com.windj0y.hw004.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* com.windj0y.hw004.service.*.*(..))")
    public void service() {}

    @Before("service()")
    public void beforeServices(){

    }

    @Around("service()")
    public Object aroundService(ProceedingJoinPoint jp){
        Object rtn = null;
        String logText = "";
        Signature signature = jp.getSignature();
        MethodSignature methodSignature = (MethodSignature)signature;
        String methodName = methodSignature.getName();
        logText = "Calling " + methodName + "(";
        Object[] args = jp.getArgs();
        for(int i=0;i<args.length;i++){
            logText += args[i].toString();
            if(i != args.length - 1) logText += ", ";
        }
        logText += ")";

        System.out.println(logText);
        try {
            rtn = jp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return rtn;
    }

}
