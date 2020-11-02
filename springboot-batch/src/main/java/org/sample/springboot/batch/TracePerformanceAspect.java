package org.sample.springboot.batch;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TracePerformanceAspect {

    private final Logger logger = LoggerFactory.getLogger(TracePerformanceAspect.class);

    @Around("execution(* com.sample..*.*(..)))")
    public Object logTracePerformanceAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();

        logger.info("Execution time of " + className + "." + methodName + " :: " + (end - start) + " ms");
        return result;
    }
}
