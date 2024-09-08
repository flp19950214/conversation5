package com.kjgs.线程池;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.*;

@EnableAsync
@Configuration
public class ThreadPoolConfig {

    @Bean(name = "AsyncTaskExecutor")
    public ExecutorService threadPoolTaskExecutor() {
        return  new ThreadPoolExecutor(1,5,10, TimeUnit.SECONDS, new LinkedBlockingDeque(1000));
    }

}

