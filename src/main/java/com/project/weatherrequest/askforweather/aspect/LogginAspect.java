package com.project.weatherrequest.askforweather.aspect;

import com.project.weatherrequest.askforweather.AskforweatherApplication;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LogginAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.project.weatherrequest.askforweather.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.project.weatherrequest.askforweather.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("execution(* com.project.weatherrequest.askforweather.restclient.*.*(..))")
    private void forClientRest() {}

//    @Pointcut("execution(* com.project.weatherrequest.askforweather.AskforweatherApplication.getWeatherImport())")
//    private void forGettingData() {}


    @Pointcut("forControllerPackage() || forDaoPackage() || forClientRest() ")
    private void forAppFlow() {}



    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint) {

        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("===> in @Before: calling method: "+theMethod);

        Object[] args = theJoinPoint.getArgs();
        for (Object tmpArg : args) {
            myLogger.info("===>> argument: "+tmpArg);
        }
    }

//    @AfterReturning(
//            pointcut ="forGettingData()",
//            returning="theResult"
//    )
//    public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
//
//        // display method we are returning from
//        String theMethod = theJoinPoint.getSignature().toShortString();
//        myLogger.info("===> in @AfterReturning: from method: "+theMethod);
//
//        //display data returned
//        myLogger.info("===>> result: "+theResult);
//
//    }

}
