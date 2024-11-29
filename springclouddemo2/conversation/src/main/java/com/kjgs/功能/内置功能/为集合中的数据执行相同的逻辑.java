package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.实体.逻辑实体;
import com.kjgs.逻辑流程2.新处理逻辑;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class 为集合中的数据执行相同的逻辑 extends 功能抽象 {
    public static final String 数据的集合 = "数据的集合";
    public static final String 执行的逻辑 = "执行的逻辑";
    public static final String 功能的参数 = "功能的参数";

    @Autowired
    private 新处理逻辑 新处理逻辑Impl;

    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(数据的集合)
                .set参数名2(执行的逻辑);
        异步初始化类.初始化记录内置功能属性(obj);
    }

    @Override
    public void 功能() {
        List 数据的集合 = 获取所有的属性值(所有逻辑对象, this.数据的集合);
        String 执行的逻辑 = 获取最近的属性值(所有逻辑对象, this.执行的逻辑);
        String 功能的参数 = 获取最近的属性值(所有逻辑对象, this.功能的参数);
        for(Object obj:数据的集合){
            Document document = new Document();
            document.put(功能的参数, obj);
            逻辑实体 逻辑Obj = new 逻辑实体();
            逻辑Obj.set逻辑(执行的逻辑);
            逻辑Obj.set逻辑名(obj.toString());
            新处理逻辑Impl.执行逻辑(逻辑Obj, UUID.randomUUID().toString(),level);
        }
    }
}
