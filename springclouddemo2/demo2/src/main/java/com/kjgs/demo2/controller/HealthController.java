package com.kjgs.demo2.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthController {

    @Value("${server.port}")
    String port;


    @RequestMapping("/testCircuitBreaker/{num}")
    public String testCircuitBreaker(@PathVariable int num){
        System.out.println("testCircuitBreaker demo2");
        if(num%2 == 0){
            return "访问正常";
        }else{
            int a=1/0;
        }
        return null;
    }

    @RequestMapping("/testFeignCircuitBreaker/{num}")
    public String testFeignCircuitBreaker(@PathVariable int num) throws InterruptedException {
        System.out.println("testFeignCircuitBreaker demo2");
        Thread.sleep(7000);
        return "success";
    }

    @RequestMapping("/getHealth")
    public Map getHealth(){
        Map map = new HashMap();
        map.put("123","demo2");
        map.put("port",port);
        return map;
    }

    public String circuitBreakerReturn(int num){
        return "请求失败过多，服务熔断2";
    }
}
