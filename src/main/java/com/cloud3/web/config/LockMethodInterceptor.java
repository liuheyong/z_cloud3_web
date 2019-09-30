package com.cloud3.web.config;

import com.cloud3.web.myannotation.LocalLock;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @author: LiuHeYong
 * @create: 2019-06-19
 * @description:
 **/
@Aspect
@Component
public class LockMethodInterceptor {

    public static final Logger logger = LoggerFactory.getLogger(LockMethodInterceptor.class);

    /**
     * 通过 CacheBuilder.newBuilder() 构建出缓存对象，设置好过期时间；
     * 其目的就是为了防止因程序崩溃锁得不到释放（当然如果单机这种方式程序都炸了，
     * 锁早没了；但这不妨碍我们写好点）
     */
    private static final Cache<String, Object> caches = CacheBuilder.newBuilder()
            // 最大缓存 100个
            .maximumSize(100)
            // 设置写缓存后5秒钟过期
            .expireAfterWrite(5, TimeUnit.SECONDS)
            .build();

    @Around("execution(public * *(..)) && @annotation(com.cloud3.web.myannotation.LocalLock)")
    public Object interceptor(ProceedingJoinPoint pjp) {
        logger.info("==========执行LocalLock拦截器==========");
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        LocalLock localLock = method.getAnnotation(LocalLock.class);
        String key = getKey(localLock.key(), pjp.getArgs());
        if (StringUtils.isNotEmpty(key)) {
            if (StringUtils.isNotBlank((String) caches.getIfPresent(key))) {
                throw new RuntimeException("请勿重复请求");
            }
            // 如果是第一次请求,就将key当前对象压入缓存中
            caches.put(key, key);
        }
        try {
            return pjp.proceed();
        } catch (Throwable throwable) {
            throw new RuntimeException("服务器异常");
        } finally {
            //caches.invalidate(key);
        }
    }

    /** 
    * @Description: key 的生成策略,如果想灵活可以写成接口与实现类的方式
    */
    private String getKey(String keyExpress, Object[] args) {
        for (int i = 0; i < args.length; i++) {
            keyExpress = keyExpress.replace("arg[" + i + "]", args[i].toString());
        }
        return keyExpress;

    }

}
