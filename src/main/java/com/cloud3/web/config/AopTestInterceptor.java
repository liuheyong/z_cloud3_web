package com.cloud3.web.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @author: LiuHeYong
 * @create: 2019-06-20
 * @description: SpringAOP
 **/
@Aspect
@Configuration
public class AopTestInterceptor {

    public static final Logger logger = LoggerFactory.getLogger(AopTestInterceptor.class);

    @Before("execution(public * *(..)) && @annotation(com.cloud3.web.myannotation.AopTest)")
    public void interceptor(JoinPoint jp) {
        logger.info("方法签名：" + jp.getSignature());
        Signature signature = jp.getSignature();
        Class<Signature> clazz = (Class<Signature>) signature.getClass();
        logger.info(clazz.getSimpleName());
        logger.info(clazz.getName());
        logger.info(String.valueOf(clazz.getDeclaredFields()));
        logger.info(String.valueOf(clazz.getAnnotations()));
    }

}
