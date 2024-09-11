package com.kjgs.启动执行包;

import com.kjgs.逻辑流程2.新处理逻辑;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class 启动执行类 implements ApplicationRunner {
    @Autowired
    新处理逻辑 新处理逻辑;

    /**
     * start
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        String input = "被加数是2";
//        新处理逻辑.process(input);
    }
}
