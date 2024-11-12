package com.kjgs.conversation.controller;

import com.alibaba.fastjson.JSONObject;
import com.kjgs.功能.功能对象;
import com.kjgs.枚举.Cons;
import com.kjgs.逻辑流程.执行逻辑;
import com.kjgs.静态变量;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
public class ToolController {
    @Autowired
    private 功能对象 功能对象impl;

    //获取指定key的值
    @PostMapping("/getLastestDoc")
    public Document getLastestDoc(@RequestBody JSONObject input){
        String inputStr = input.getString("input");
        return 功能对象impl.获取最近的对象(执行逻辑.所有逻辑对象,inputStr);
    }

    //获取所有成分对象
    @PostMapping("/getChengFenObj")
    public List<Document> getChengFenObj(@RequestBody JSONObject input){
        return 执行逻辑.所有逻辑对象.stream().filter(m -> m.containsValue(Cons.句子成分))
                .collect(Collectors.toList());
    }


    //获取执行层级
    @PostMapping("/getExecLogicList")
    public List<String> getExecLogicList(@RequestBody JSONObject input){
        return 静态变量.执行层级集合;
    }
}
