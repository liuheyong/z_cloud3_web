package com.cloud3.web;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.cloud3.web.service.CacheKeyGenerator;
import com.cloud3.web.service.impl.LockKeyGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@EnableDubbo
@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class ZCloud3WebApplication implements CommandLineRunner {

    public static final Logger logger = LoggerFactory.getLogger(ZCloud3WebApplication.class);

    public static void main(String[] args) throws InterruptedException {
        SpringApplication springApplication = new SpringApplication(ZCloud3WebApplication.class);
        //禁止命令行设置环境参数
        springApplication.setAddCommandLineProperties(false);
        ApplicationContext context = springApplication.run(args);
        //赋值ApplicationContext,以便随时手动获取bean
        SpringBeanUtil.setApplicationContext(context);
        logger.info("==========获取到ApplicationContext==========" + SpringBeanUtil.getApplicationContext());
        //keepRunning();
    }

    ///*private CorsConfiguration buildConfig() {
    //    CorsConfiguration corsConfiguration = new CorsConfiguration();
    //    corsConfiguration.addAllowedOrigin("*");
    //    corsConfiguration.addAllowedHeader("*");
    //    corsConfiguration.addAllowedMethod("*");
    //    //corsConfiguration.addExposedHeader(HttpHeaderConStant.X_TOTAL_COUNT);
    //    return corsConfiguration;
    //}
    //
    //*//**
    // * 跨域过滤器
    // *
    // * @return
    // *//*
    //@Bean
    //public CorsFilter corsFilter() {
    //    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    //    source.registerCorsConfiguration("/**", buildConfig());
    //    return new CorsFilter(source);
    //}*/

    @Bean
    public CacheKeyGenerator cacheKeyGenerator() {
        return (CacheKeyGenerator) new LockKeyGenerator();
    }

    /*@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            logger.info("==========SpringBoot默认为我们提供的Bean==========");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            Arrays.stream(beanNames).forEach(System.out::println);
        };
    }*/

    /**
     * @date: 2019/6/18
     * @description: 阻塞main方法
     */
    private static void keepRunning() throws InterruptedException {
        logger.info("==========keepRunning==========");
        Thread currentThread = Thread.currentThread();
        synchronized (currentThread) {
            currentThread.wait();
        }
    }

    /**
     * @date: 2019/5/28
     * @param: [strings]
     * @return: void
     * @description: 这个方法不需要手动调用，启动以后这个方法会被自动执行并存在于Spring容器中
     */
    @Override
    public void run(String... strings) {
        try {
            logger.info("==========随cloud启动而执行==========");
        } catch (Exception e) {
            logger.error("启动异常", e);
            e.printStackTrace();
        }
    }

}
