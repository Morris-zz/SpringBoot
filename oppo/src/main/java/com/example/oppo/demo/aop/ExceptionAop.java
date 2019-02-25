package com.example.oppo.demo.aop;

import com.example.oppo.demo.enums.ResponseStatus;
import com.example.oppo.demo.util.Response;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author zhaozheng
 * @create 2019/2/25
 **/
@Aspect
@Component
public class ExceptionAop {
    @Around("execution(* com.example.oppo.demo.controller.HrmController.*(..))")
    public Response ecAop(ProceedingJoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Response response = new Response();
        for (int i = 0; i < args.length ; i++) {
            System.out.println(args[i]);
        }
        try {

            Object proceed = joinPoint.proceed(args);
            response.setData(proceed);
            response.setMsgAndCode(ResponseStatus.SUSSESSED);
        }catch (Exception e){
            response.setMsgAndCode(ResponseStatus.FAILED);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            response.setMsgAndCode(ResponseStatus.FAILED);
        }finally {
            return response;
        }
    }
}
