package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.实体.逻辑实体;
import com.kjgs.逻辑流程2.新处理逻辑;
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
        List 待执行的逻辑集合 = 获取所有的属性值(所有逻辑对象, this.待执行的逻辑集合);
        String 待处理的词语 = 获取最近的属性值(所有逻辑对象, this.待处理的词语);
        for(Object 逻辑: 待执行的逻辑集合){
            逻辑实体 逻辑Obj = new 逻辑实体();
            if(逻辑.toString().equals("[]")){
                continue;
            }
            逻辑Obj.set逻辑(逻辑.toString());
            逻辑Obj.set逻辑名(待处理的词语);
            新处理逻辑Impl.执行逻辑(逻辑Obj, UUID.randomUUID().toString(),level);
        }

    }
}
