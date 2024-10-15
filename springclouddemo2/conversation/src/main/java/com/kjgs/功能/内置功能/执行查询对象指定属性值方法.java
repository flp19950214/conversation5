package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import org.bson.Document;
import org.springframework.stereotype.Service;

// 只查内存对象 区别于  执行查询方法
@Service
public class 执行查询对象指定属性值方法 extends 功能抽象 {
    public static final String 查询的对象 = "查询的对象";
    public static final String 查询的属性 = "查询的属性";
    public static final String 查询的结果= "查询的结果";
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(查询的对象).set参数名2(查询的属性)
                .set结果名(查询的结果);
        异步初始化类.初始化记录内置功能属性(obj);
    }
    @Override
    public void 功能() {
        String 查询的对象 = 获取最近的属性值(所有逻辑对象, this.查询的对象);
        String 查询的属性 = 获取最近的属性值(所有逻辑对象, this.查询的属性);
        Document 查询的对象Doc = 获取最近的对象(所有逻辑对象, 查询的对象);
        Object 查询的结果 = 查询的对象Doc.get(查询的属性);
        Document  查询的结果对象 =  new Document();
        查询的结果对象.put(this.查询的结果, 查询的结果);
        所有逻辑对象.add(查询的结果对象);

        动作结果=查询的结果;
    }
}
