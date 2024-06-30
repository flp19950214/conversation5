package com.kjgs.demo1.service;

import com.kjgs.demo1.config.FeginClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient(value = "demo2",fallback = FallbackService.class,configuration = FeginClientConfig.class)
public interface FeignClientImpl {

    @RequestMapping("/getHealth")
    public Map getHealth();

    @RequestMapping("/testCircuitBreaker/{num}")
    public String testCircuitBreaker(@PathVariable int num);

    @RequestMapping("/testFeignCircuitBreaker/{num}")
    public String testFeignCircuitBreaker(@PathVariable int num);
}
