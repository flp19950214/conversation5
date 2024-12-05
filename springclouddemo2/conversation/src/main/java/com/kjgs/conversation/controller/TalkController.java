package com.kjgs.conversation.controller;

import com.alibaba.fastjson.JSONObject;
import com.kjgs.conversation.mysql.逻辑Impl;
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

import java.util.ArrayList;

@RestController()
public class TalkController {

    @Autowired
    private 新处理逻辑 新处理逻辑Impl;

    @Autowired
    private 逻辑Impl 逻辑MapperImpl;

    @Autowired
    private 执行逻辑 执行逻辑Impl;

    @Autowired
    private 功能对象 功能对象impl;

    @PostMapping("/talk")
    public String conversation(@RequestBody JSONObject input) {
        静态变量.执行层级集合 = new ArrayList<>();
        执行逻辑.所有逻辑对象 = new ArrayList<>();
        String 句子 = input.getString("input");
        int 处理位置 = 0;
        int 处理结束位置 = 1;
        while (处理结束位置 <= 句子.length()) {
            System.out.println("本次处理结束位置:"+处理结束位置);
            String 词语 = 句子.substring(处理位置,处理结束位置);
            新处理逻辑Impl.init(句子, 处理位置, 处理结束位置, 词语);
            新处理逻辑Impl.process(词语);

            //开启下一轮
            处理结束位置 =(int) Double.parseDouble(功能对象impl.获取最近的属性值NoLevel(执行逻辑.所有逻辑对象, Cons.当前处理的词语结束位置).toString());
            处理位置 = 处理结束位置;
            处理结束位置++;
        }
        //todo 多次执行 添加逻辑 如果句子的成分对象不再有变化就终止执行
        System.out.println("成分划分完毕，再次执行句子中的逻辑");
        新处理逻辑Impl.二次执行成分逻辑(句子);
        return 静态变量.输出的内容;
    }


    @PostMapping("/testLogic")
    public Object testLogic(@RequestBody JSONObject input) {
        新处理逻辑Impl.init("123", 0,1,"1");
        Document 是否执行判断结果 = new Document();
        是否执行判断结果.put(Cons.是否执行判断结果, "true");
        执行逻辑Impl.所有逻辑对象.add(是否执行判断结果);
        String 逻辑名 = input.getString("逻辑名");
        逻辑实体 逻辑Obj = 逻辑MapperImpl.queryForObject(逻辑名);
        Object result = 新处理逻辑Impl.执行逻辑(逻辑Obj);

        Document 当前处理逻辑 = new Document();
        是否执行判断结果.put(Cons.当前处理逻辑, 逻辑Obj.逻辑);
        执行逻辑Impl.所有逻辑对象.add(当前处理逻辑);
        return result;
    }
}
