package com.cloud3.web.service;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author: LiuHeYong
 * @create: 2019-06-20
 * @description:
 **/
public interface CacheKeyGenerator {

    /**
     * 获取AOP参数,生成指定缓存Key
     *
     * @param pjp PJP
     * @return 缓存KEY
     */
    String getLockKey(ProceedingJoinPoint pjp);

}
