package com.kjgs.conversation.controller;

import com.alibaba.fastjson.JSONObject;
import com.kjgs.conversation.mysql.mapper.逻辑Mapper;
import com.kjgs.功能.功能对象;
import com.kjgs.实体.逻辑实体;
import com.kjgs.枚举.Cons;
import com.kjgs.逻辑流程.执行逻辑;
import com.kjgs.逻辑流程2.新处理逻辑;
import com.kjgs.静态变量;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TalkController {

    @Autowired
    private 新处理逻辑 新处理逻辑Impl;

    @Autowired
    private 逻辑Mapper 逻辑MapperImpl;

    @Autowired
    private 执行逻辑 执行逻辑Impl;

    @PostMapping("/talk")
    public String conversation(@RequestBody JSONObject input) {
        String 句子 = input.getString("input");
        Document 待处理对象所在的句子 = new Document();
        待处理对象所在的句子.put(Cons.待处理对象所在句子, 句子);
        执行逻辑Impl.所有逻辑对象.add(待处理对象所在的句子);
        新处理逻辑Impl.process();
        return 静态变量.输出结果;
    }

    @PostMapping("/testLogic")
    public Object testLogic(@RequestBody JSONObject input) {
        String 句子 = input.getString("句子");
        String 逻辑名 = input.getString("逻辑名");
        Document 输入的句子 = new Document();
        输入的句子.put(Cons.输入的句子, 句子);
        执行逻辑Impl.所有逻辑对象.add(输入的句子);
        逻辑实体 逻辑Obj = 逻辑MapperImpl.queryForObject(逻辑名);
        Object result = 新处理逻辑Impl.执行逻辑(逻辑Obj);
        return result;
    }
}
