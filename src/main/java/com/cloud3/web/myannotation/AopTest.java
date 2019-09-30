package com.cloud3.web.myannotation;

import java.lang.annotation.*;

/**
 * @author: LiuHeYong
 * @create: 2019-06-20
 * @description: AopTest
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface AopTest {

    String name() default "";

}
