package com.kjgs.conversation.controller;

import com.alibaba.fastjson.JSONObject;
import com.kjgs.枚举.Cons;
import com.kjgs.逻辑流程.执行逻辑;
import com.kjgs.逻辑流程2.新处理逻辑;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("talk")
public class TalkController {

    @Autowired
    新处理逻辑 新处理逻辑;


    @Autowired
    private 执行逻辑 执行逻辑Impl;

    @PostMapping()
    public String conversation(@RequestBody JSONObject input) {
        String 句子 = input.getString("input");
        Document 待处理对象所在的句子 = new Document();
        待处理对象所在的句子.put(Cons.待处理对象所在句子, 句子);
        执行逻辑Impl.所有逻辑对象.add(待处理对象所在的句子);
        新处理逻辑.process();
        return "success";
    }
}
