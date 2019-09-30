package com.cloud3.web.myannotation;

import java.lang.annotation.*;

/**
 * @author: LiuHeYong
 * @create: 2019-06-20
 * @description:
 **/
@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CacheParam {

    /**
     * 字段名称
     *
     * @return String
     */
    String name() default "";

}
