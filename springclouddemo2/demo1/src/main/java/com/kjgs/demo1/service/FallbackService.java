package com.kjgs.demo1.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FallbackService implements FeignClientImpl {

    @Override
    public Map getHealth() {
        Map map = new HashMap();
        map.put("exception","服务异常，请等待2");
        return map;
    }

    @Override
    public String testCircuitBreaker(int num) {
        return null;
    }

    @Override
    public String testFeignCircuitBreaker(int num) {
        return "请求demo2异常";
    }
}
