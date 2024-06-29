package com.kjgs.demo2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/getHealth")
    public Map getHealth(){
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map map = new HashMap();
        map.put("123","2sdf234234234");
        map.put("1233",port);
        return map;
    }
}
