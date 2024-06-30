package com.kjgs.demo1.controller;


import com.kjgs.demo1.service.FallbackService;
import com.kjgs.demo1.service.FeignClientImpl;
import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthController {

    @RequestMapping("/getHealth")
    public Map getHealth(){
        Map map = new HashMap();
        map.put("123","2sdf");
        return map;
    }


    @Autowired
    FallbackService fallbackService;

    @RequestMapping("/getHealth2")
    public Map getHealth2(){
        return fallbackService.getHealth();
    }


    @HystrixCommand(commandKey = "test",fallbackMethod = "circuitBreakerReturn")
    @RequestMapping("/testCircuitBreaker2/{num}")
    public String testCircuitBreaker2(@PathVariable int num){
        System.out.println("testCircuitBreaker2 demo1");
        return "success";
    }


    @HystrixCommand(commandKey = "test",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value ="true"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value
                    = "10"),
            // HystrixCommand的执行和事件悬否打印日志到HystrixRequestLog中
            @HystrixProperty(name = "requestLog.enabled", value = "true"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value =
                    "20000"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "50")
    },fallbackMethod = "circuitBreakerReturn")
    @RequestMapping("/testCircuitBreaker/{num}")
    public String testCircuitBreaker(@PathVariable int num){
        System.out.println("testCircuitBreaker demo1");
        return fallbackService.testCircuitBreaker(num);
    }


    @HystrixCommand(commandKey = "test", fallbackMethod = "circuitBreakerReturn")
    @RequestMapping("/testCircuitBreaker3/{num}")
    public String testCircuitBreaker3(@PathVariable int num){
        System.out.println("testCircuitBreaker3 demo1");
        return fallbackService.testCircuitBreaker(num);
    }

    @RequestMapping("/getHealth3")
    @HystrixCommand(commandKey = "test", fallbackMethod = "hystrixReturn")
    public Map getHealth3(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map map = new HashMap();
        map.put("123","2sdf");
        return map;
    }

    public Map hystrixReturn(){
        HystrixCircuitBreaker circuitBreaker = HystrixCircuitBreaker.Factory.getInstance(HystrixCommandKey.Factory.asKey("test"));
        System.out.println(circuitBreaker.isOpen());
        Map map = new HashMap();
        map.put("exception","服务异常，请等待");
        return map;
    }

    @HystrixCommand(fallbackMethod = "circuitBreakerReturn")
    @RequestMapping("/testFeignCircuitBreaker2/{num}")
    public String testFeignCircuitBreaker2(@PathVariable int num) throws InterruptedException {
        System.out.println("testFeignCircuitBreaker2 demo1");
        Thread.sleep(5000);
        return "feignClientImpl.testFeignCircuitBreaker(num)";
    }


    @RequestMapping("/testFeignCircuitBreaker/{num}")
    public String testFeignCircuitBreaker(@PathVariable int num){
        System.out.println("testFeignCircuitBreaker demo1");
        return fallbackService.testFeignCircuitBreaker(num);
    }

    public String circuitBreakerReturn(int num){
        HystrixCircuitBreaker circuitBreaker = HystrixCircuitBreaker.Factory.getInstance(HystrixCommandKey.Factory.asKey("test"));
        if(circuitBreaker.allowRequest()){
            return "接口异常";
        }else{
            return "请求失败过多，服务熔断1";
        }
    }
}
