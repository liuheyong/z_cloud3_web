package com.cloud3.web.config;

import com.cloud3.web.myannotation.CacheLock;
import com.cloud3.web.service.CacheKeyGenerator;
import com.cloud3.web.utils.RedisLockHelperUtil;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.UUID;

/**
 * @author: LiuHeYong
 * @create: 2019-06-20
 * @description:
 **/
@Aspect
@Configuration
public class LockMethodClusterInterceptor {

    public static final Logger logger = LoggerFactory.getLogger(LockMethodClusterInterceptor.class);

    @Autowired
    public LockMethodClusterInterceptor(RedisLockHelperUtil redisLockHelper, CacheKeyGenerator cacheKeyGenerator) {
        this.redisLockHelper = redisLockHelper;
        this.cacheKeyGenerator = cacheKeyGenerator;
    }

    private final RedisLockHelperUtil redisLockHelper;
    private final CacheKeyGenerator cacheKeyGenerator;

    @Around("execution(public * *(..)) && @annotation(com.cloud3.web.myannotation.CacheLock)")
    public Object interceptor(ProceedingJoinPoint pjp) {
        logger.info("==========进入aop拦截==========");
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        CacheLock lock = method.getAnnotation(CacheLock.class);
        if (StringUtils.isEmpty(lock.prefix())) {
            throw new RuntimeException("lock key don't null...");
        }
        final String lockKey = cacheKeyGenerator.getLockKey(pjp);
        String value = UUID.randomUUID().toString();
        try {
            // 假设上锁成功，但是设置过期时间失效，以后拿到的都是 false
            final boolean success = redisLockHelper.lock(lockKey, value, lock.expire(), lock.timeUnit());
            if (!success) {
                throw new RuntimeException("重复提交");
            }
            try {
                return pjp.proceed();
            } catch (Throwable throwable) {
                throw new RuntimeException("系统异常");
            }
        } finally {
            // TODO 如果演示的话需要注释该代码;实际应该放开
            //redisLockHelper.unlock(lockKey, value);
        }
    }

}
