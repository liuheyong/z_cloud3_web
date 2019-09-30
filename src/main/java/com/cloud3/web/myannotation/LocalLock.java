package com.cloud3.web.myannotation;

import java.lang.annotation.*;

/**
 * @author: LiuHeYong
 * @create: 2019-06-19
 * @description: LocalLock(防止重复提交)
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface LocalLock {

    String key() default "";

}
