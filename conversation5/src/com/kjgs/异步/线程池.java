package com.kjgs.异步;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class 线程池 {
    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,5,10, TimeUnit.SECONDS, new LinkedBlockingDeque(1000));

    {
        threadPoolExecutor.execute(() -> {
            System.out.println("异步检测----");
        });
    }
}
