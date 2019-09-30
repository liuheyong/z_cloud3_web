package com.cloud3.web.fastjson;


import com.alibaba.fastjson.JSON;

/**
 * @author: HeYongLiu
 * @create: 09-23-2019
 * @description:
 **/
public class FastJsonCase {

    public static void main(String[] args) {
        try {
            String DEATH_STRING = "{\"a\":\"\\x";
            String obj = JSON.toJSONString(DEATH_STRING);
            System.out.println(obj);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
