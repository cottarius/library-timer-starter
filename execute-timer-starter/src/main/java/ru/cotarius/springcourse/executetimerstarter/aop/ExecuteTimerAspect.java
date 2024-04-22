package ru.cotarius.springcourse.executetimerstarter.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class ExecuteTimerAspect {

    @Pointcut("within(@ru.cotarius.springcourse.executetimerstarter.annotations.ExecuteTimer *)")
    public void logWithMethod() {}

    @Pointcut("@annotation(ru.cotarius.springcourse.executetimerstarter.annotations.ExecuteTimer)")
    public void logWithAnnotation() {}

    @Around("logWithMethod() || logWithAnnotation()")
    public Object logMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();

        log.info("Method {} has been executed in {} ms",
                joinPoint.getSignature().getName(),
                endTime - startTime);

        return result;
    }
}
