package com.kjgs.常用语句.抽象;

import com.kjgs.线程池.异步_初始化记录常用逻辑;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public abstract class 逻辑抽象 {
    public abstract void test();
    public abstract void 初始化记录常用逻辑();

    @Autowired
    public 异步_初始化记录常用逻辑  异步初始化类;

    @PostConstruct
    public void 初始化(){
        初始化记录常用逻辑();
    }
}
