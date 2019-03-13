package com.example.common.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import java.net.InetAddress;



/**
 * Created by chenqi on 2017/9/15.
 */
@Aspect
@Configuration
public class TimeAspect {

    private Logger logger = LoggerFactory.getLogger(TimeAspect.class);
    /**
     * 环绕通知：打印方法耗时
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("@annotation(com.example.common.annotation.TimeAnn)")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        // 从（连接点对象）中提取注解
        MethodSignature sign = (MethodSignature) point.getSignature();
        // 获取注解对象
        Object result = null;
        Long startTime = System.nanoTime();
        Long startMemory = Runtime.getRuntime().freeMemory();
        result = point.proceed();
        Long useTime = (System.nanoTime() - startTime) / 1000000L;
        String ip = null;
        InetAddress address = InetAddress.getLocalHost();
        if(address != null){
            ip = address.getHostAddress();
        }
        String className = null;
        Object obj = point.getTarget();
        if(obj != null){
            className = obj.getClass().getName();
        }
        try{

            logger.info(point + "总耗时==============>：" + useTime);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }

        return result;
    }

}
