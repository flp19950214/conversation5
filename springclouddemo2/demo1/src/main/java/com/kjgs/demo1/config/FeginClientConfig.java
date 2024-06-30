package com.kjgs.demo1.config;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FeginClientConfig {
    @Bean
    public Request.Options options() {
        return new Request.Options(5000, 10000);
    }
}
