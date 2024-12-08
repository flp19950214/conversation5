package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.实体.逻辑实体;
import com.kjgs.枚举.Cons;
import com.kjgs.逻辑流程2.新处理逻辑;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List 数据的集合 = (List) 获取最近的属性值(所有逻辑对象, this.数据的集合, List.class);
        String 执行的逻辑 = 获取最近的属性值(所有逻辑对象, this.执行的逻辑);
        String 功能的参数 = 获取最近的属性值(所有逻辑对象, this.功能的参数);
        List 动作结果 = new ArrayList();
        for(int i=0;i<数据的集合.size();i++){
            if(功能的参数 != null){
                Document document = 生成当前层级对象();
                document.put(功能的参数, 数据的集合.get(i));
                所有逻辑对象.add(document);
            }
            逻辑实体 逻辑Obj = new 逻辑实体();
            逻辑Obj.set逻辑(String.format("《%s》", 执行的逻辑));
            逻辑Obj.set逻辑名( 数据的集合.get(i).toString());

            新处理逻辑Impl.执行逻辑(逻辑Obj, uuidLevel,level);

            Object 获取最近的属性值 = 获取最近的属性值(所有逻辑对象, Cons.动作结果, List.class);
            动作结果.add(获取最近的属性值);
        }
        this.动作结果=动作结果;
    }
}
