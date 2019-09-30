package com.cloud3.web.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: liuheyong
 * @create: 2019-08-31
 * @description:
 */
@Controller
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @Date: 2019-08-31
     * @Param: []
     * @return: java.lang.String
     * @Description: 设置访问首页
     */
    @RequestMapping("")
    public String test() {
        return "redirect:/cloud3/queryECooperateMerListPage";
    }

    /**
     * @Date: 2019-08-31
     * @Param: []
     * @return: java.lang.String
     * @Description: 跨域测试
     */
    @CrossOrigin("http://localhost:8118")
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @ResponseBody
    @RequestMapping("/json")
    public String json() {
        return "json";
    }

    /**
     * @Date: 2019-08-31
     * @Param: []
     * @return: java.lang.String
     * @Description: redis测试
     */
    @RequestMapping("/testRedis")
    @ResponseBody
    public String testRedis() {
        //redis 设置key
        //RedisSerializer redisSerializer = new StringRedisSerializer();
        //redisTemplate.setKeySerializer(redisSerializer);
        return (String) redisTemplate.opsForValue().get("test");
    }

}
