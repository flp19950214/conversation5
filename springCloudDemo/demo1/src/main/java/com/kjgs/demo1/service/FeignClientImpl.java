package com.kjgs.demo1.service;

import config.FeginClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient(value = "demo2",fallback = FallbackService.class,configuration = FeginClientConfig.class)
public interface FeignClientImpl {

    @RequestMapping("/getHealth")
    public Map getHealth();
}
