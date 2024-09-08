package com.kjgs.demo1.config;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FeginClientConfig {
//    static byte[] mysqsssss2=new byte[1024*1024*10];
    @Bean
    public Request.Options options() {
        return new Request.Options(5000, 10000);
    }
}
