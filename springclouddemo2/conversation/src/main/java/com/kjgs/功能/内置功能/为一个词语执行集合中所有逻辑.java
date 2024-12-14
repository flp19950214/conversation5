package com.kjgs.功能.内置功能;

import com.alibaba.fastjson.JSON;
import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.实体.逻辑实体;
import com.kjgs.枚举.Cons;
import com.kjgs.逻辑流程.执行逻辑;
import com.kjgs.逻辑流程2.新处理逻辑;
import com.kjgs.静态变量;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class 为一个词语执行集合中所有逻辑 extends 功能抽象 {
    public static final String 待执行的逻辑集合 = "待执行的逻辑集合";
    public static final String 待处理的词语 = "待处理的词语";

    @Autowired
    private 新处理逻辑 新处理逻辑Impl;

    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(待执行的逻辑集合)
                .set参数名2(待处理的词语);
        异步初始化类.初始化记录内置功能属性(obj);
    }

    @Override
    public void 功能() {
        List<逻辑实体> 待执行的逻辑集合 = (List) 获取最近的属性值(所有逻辑对象, this.待执行的逻辑集合, List.class);
        String 待处理的词语 = 获取最近的属性值(所有逻辑对象, this.待处理的词语);
        静态变量.添加执行层级集合(String.format("%s %s", level, " 待执行的逻辑集合："+ JSON.toJSONString(待执行的逻辑集合)));
        静态变量.添加执行层级集合(String.format("%s %s", level, " 待处理的词语："+ 待处理的词语));
        for(逻辑实体 逻辑: 待执行的逻辑集合){
            Document 获取最近的对象 = 获取最近的对象(所有逻辑对象, Cons.是否执行判断结果);
            获取最近的对象.put(Cons.是否执行判断结果, true);
            逻辑实体 逻辑Obj = new 逻辑实体();
            if(逻辑.toString().equals("[]")){
                continue;
            }
            逻辑Obj.set逻辑(逻辑.逻辑);
            逻辑Obj.set逻辑名(待处理的词语);
            新处理逻辑Impl.执行逻辑(逻辑, UUID.randomUUID().toString(),level);
        }

    }
}
