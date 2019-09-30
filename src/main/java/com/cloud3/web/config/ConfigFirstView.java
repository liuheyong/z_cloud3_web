package com.cloud3.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author: liuheyong
 * @create: 2019-08-31
 * @description: 设置访问欢迎页
 */
@Configuration
public class ConfigFirstView extends WebMvcConfigurerAdapter {

    //@Override
    //public void addViewControllers(ViewControllerRegistry viewControllerRegistry){
    //    viewControllerRegistry.addViewController("/").setViewName("index");
    //    //设置ViewController的优先级,将此处的优先级设为最高,当存在相同映射时依然优先执行
    //    viewControllerRegistry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    //    super.addViewControllers(viewControllerRegistry);
    //}

}
