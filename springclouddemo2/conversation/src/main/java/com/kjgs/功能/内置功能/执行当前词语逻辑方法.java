package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.实体.逻辑实体;
import com.kjgs.枚举.Cons;
import com.kjgs.逻辑流程.执行逻辑;
import com.kjgs.逻辑流程2.新处理逻辑;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 执行当前词语逻辑方法 extends 功能抽象 {

    @Autowired
    private 新处理逻辑 新处理逻辑Impl;

    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName());
        异步初始化类.初始化记录内置功能属性(obj);
    }

    @Override
    public void 功能() {
        String 词语 =(String) 获取最近的属性值NoLevel(执行逻辑.所有逻辑对象, Cons.当前处理的词语);
        String 句子 =(String) 获取最近的属性值NoLevel(执行逻辑.所有逻辑对象, Cons.当前处理的句子);
        int 处理位置 =(int)Double.parseDouble(获取最近的属性值NoLevel(执行逻辑.所有逻辑对象, Cons.当前处理的词语位置).toString());
        新处理逻辑Impl.init(句子, 处理位置, 词语);
        //查询最新的逻辑
        新处理逻辑Impl.process(词语);
    }
}
