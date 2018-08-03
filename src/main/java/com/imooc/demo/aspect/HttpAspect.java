package com.imooc.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    public final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.imooc.demo.controller.GirlController.girlList(..))")
    public void log(){
    }
    /**
     * 获取http请求的内容
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
         ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
         HttpServletRequest request = attributes.getRequest();
         //url
         logger.info("url>>>{}",request.getRequestURL());
         //method
         logger.info("method>>>{}",request.getMethod());
         //ip
         logger.info("IP>>>{}",request.getRemoteAddr());
         //类方法
         logger.info("class_method>>>{}", joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
         //参数
         logger.info("args>>>{}",joinPoint.getArgs());
    }
    @After("log()")
    public void doAfter() {
        System.out.println("我是程序执行完之后打印出来的");
    }
    //返回内容
    @AfterReturning(returning = "object",pointcut = "log()")
    public void getAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }
}
