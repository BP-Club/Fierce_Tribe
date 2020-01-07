package com.nr.fierce_tribe.aspect;

import com.nr.fierce_tribe.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ServiceAspect {

    @Pointcut("execution(* com.nr.fierce_tribe.service..*(..))")
    public void servicePoint() {}

    @Around("servicePoint()")
    public Object handleExceptionAndTime(ProceedingJoinPoint point) {
        try {
            long start = System.currentTimeMillis();
            Object result = point.proceed();
            long end = System.currentTimeMillis();
            long duration = end - start;
            if (duration > 50) {
                log.warn("{}.{} consume {}ms", point.getTarget(), point.getSignature().getName(), duration);
            } else if (duration > 10) {
                log.info("{}.{} consume {}ms", point.getTarget(), point.getSignature().getName(), duration);
            } else {
                log.debug("{}.{} consume {}ms", point.getTarget(), point.getSignature().getName(), duration);
            }
            return result;
        } catch (Throwable throwable) {
            log.error("error at {}.{}, cause : {}", point.getTarget(), point.getSignature().getName(), throwable.getMessage());
            throw new ServiceException(throwable.getMessage());
        }
    }

}
