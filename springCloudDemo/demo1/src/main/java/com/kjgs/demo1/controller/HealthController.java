package com.kjgs.demo1.controller;

import com.kjgs.demo1.service.FallbackService;
import com.kjgs.demo1.service.FeignClientImpl;
import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthController {

    @Autowired
    FallbackService feignClientImpl;

    @RequestMapping("/getHealth")
    @HystrixCommand(commandKey = "test", fallbackMethod = "hystrixReturn")
    public Map getHealth(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map map = new HashMap();
        map.put("123","2sdf");
        return map;
    }

    @HystrixCommand(fallbackMethod = "hystrixReturn")
    @RequestMapping("/getHealth2")
    public Map getHealth2(){
        return feignClientImpl.getHealth();
    }

    public Map hystrixReturn(){
        HystrixCircuitBreaker circuitBreaker = HystrixCircuitBreaker.Factory.getInstance(HystrixCommandKey.Factory.asKey("test"));
        System.out.println(circuitBreaker.isOpen());
        Map map = new HashMap();
        map.put("exception","服务异常，请等待");
        return map;
    }
}
