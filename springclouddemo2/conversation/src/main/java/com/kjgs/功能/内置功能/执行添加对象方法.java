package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.逻辑流程.执行逻辑;
import org.bson.Document;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class 执行添加对象方法 extends 功能抽象 {
    public static String 添加的属性 = "添加的属性";
    public static String 添加的属性值 = "添加的属性值";
    @Autowired
    private 执行逻辑 执行逻辑;
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(添加的属性).set参数名2(添加的属性值);
        异步初始化类.初始化记录内置功能属性(obj);
    }
    public void 功能(){
        String 添加的属性 = 获取最近的属性值(所有逻辑对象, this.添加的属性);
        String 添加的属性值 = 获取最近的属性值(所有逻辑对象, this.添加的属性值);
        Document document = new Document();
        document.put(添加的属性, 添加的属性值);
        所有逻辑对象.add(document);
    }

    @Test
    public void test(){
        String 执行添加对象方法= "添加的属性《是》待处理的对象\n添加的属性值《是》如果\n《执行添加对象方法》";
        System.out.println(执行逻辑.所有逻辑对象.size());
    }
}
