package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.枚举.Cons;
import com.kjgs.逻辑流程.执行逻辑;
import org.bson.Document;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class 执行查询集合指定下标方法 extends 功能抽象 {
    public static final String 查询的集合 = "查询的集合";
    public static final String 查询的下标 = "查询的下标";
    public static final String 查询的结果= "查询的结果";

    @Autowired
    private 执行逻辑 执行逻辑;
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(查询的集合).set参数名2(查询的下标)
                .set结果名(查询的结果);
        异步初始化类.初始化记录内置功能属性(obj);
    }

    @Override
    public void 功能() {
        List 查询的集合 = (List) 获取最近的属性值(所有逻辑对象, this.查询的集合,List.class);
        Integer 查询的下标 = (int)Double.parseDouble(获取最近的属性值(所有逻辑对象, this.查询的下标));
        Object 查询的结果=null;
        if(查询的集合.size()>查询的下标){
            查询的结果 = 查询的集合.get(查询的下标);
        }

        动作结果=查询的结果;
    }

    @Test
    public void test(){
    }
}
