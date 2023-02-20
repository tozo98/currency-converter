package com.epam.training.currencyConverter.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

@Aspect
@Component
public class ConverterControllerInputValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConverterControllerInputValidator.class);


    @Pointcut("execution (* com.epam.training.currencyConverter.controller.ResultPageController.*(..))")
    public void executeMethodsInConverterController() {

    }

    @Before("executeMethodsInConverterController()")
    public void before(JoinPoint joinPoint){
        Object[] parameters = joinPoint.getArgs();
        Optional<Object> nullCheck = Arrays.stream(parameters).filter(this::isNullOrEmpty).findFirst();
        if(nullCheck.isPresent()){
            LOGGER.error("Parameter cannot be null or empty.");
            throw new IllegalArgumentException("Parameter cannot be null or empty.");
        }
    }

    private boolean isNullOrEmpty(Object obj){
        return Objects.isNull(obj) || obj.toString().equals("");
    }

}
