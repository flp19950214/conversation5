package com.kjgs.conversation2;

import com.kjgs.conversation.mysql.Impl逻辑;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class 启动执行初始化数据 {
    @Autowired
    private Impl逻辑 逻辑impl;
    public void init (){
//        逻辑impl.保存逻辑("如果句子包含如果，那就把如果添加为句子的成分");
        逻辑impl.保存逻辑("如果遇到如，并且后面1个字是果，那就把当前词和后面1个字合并为1个词");
        逻辑impl.保存逻辑("如果句子以如果开头，那就把句子记录成处理逻辑");
        //如果句子是求两数相加，那就可以输出相加的结果
        //把相加的对象
    }
}
