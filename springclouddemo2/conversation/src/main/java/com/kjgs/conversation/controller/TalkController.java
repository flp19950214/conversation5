package com.kjgs.conversation.controller;

import com.alibaba.fastjson.JSONObject;
import com.kjgs.逻辑流程2.新处理逻辑;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("talk")
public class TalkController {

    @Autowired
    新处理逻辑 新处理逻辑;

    @PostMapping()
    public String conversation(@RequestBody JSONObject input){
         新处理逻辑.process(input.getString("input"));
         return "success";
    }
}
