package com.kjgs.conversation2;

import com.kjgs.conversation.mysql.逻辑Impl;
import com.kjgs.枚举.Cons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class 启动执行初始化数据 {
    @Autowired
    private 逻辑Impl 逻辑impl;
    public void init (){
        逻辑impl.保存逻辑("");
    }
}
