package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

// 只查内存对象 区别于  执行查询方法
public class 执行查询对象指定属性值方法 extends 功能抽象 {
    public static final String 查询的对象 = "查询的对象";
    public static final String 查询的属性 = "查询的属性";
    public static final String 查询的结果= "查询的结果";
    @Override
    public void 功能() {
        Document 过滤的对象 = (Document) 获取最近的属性值(所有逻辑对象, this.查询的对象, Document.class);
        String 查询的属性 = 获取最近的属性值(所有逻辑对象, this.查询的属性);
        Object 查询的结果 = 过滤的对象.get(查询的属性);
        Document  过滤的结果对象 =  new Document();
        过滤的结果对象.put(this.查询的结果, 查询的结果);
        所有逻辑对象.add(过滤的结果对象);
    }
}
