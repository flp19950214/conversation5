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
//        逻辑impl.保存逻辑("如果句子包含如果，那就把如果添加为句子的成分");
        逻辑impl.保存逻辑("如果遇到如，并且后面一个字是果，那就合并为一个成分");
        逻辑impl.保存逻辑("如果句子包含假设句并且句子包含陈述句，那就把句子记录成处理逻辑");
    }
}
