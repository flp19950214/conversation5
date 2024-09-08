package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

// 只查内存对象 区别于  执行查询方法
public class 执行查询集合对象指定属性值方法 extends 功能抽象 {
    public static final String 查询的对象 = "查询的对象";
    public static final String 查询的属性 = "查询的属性";
    public static final String 查询的结果= "查询的结果";
    @Override
    public void 功能() {
        List<Document> 查询的对象 = (List<Document>)获取最近的属性值(所有逻辑对象, this.查询的对象, List.class);
        String 查询的属性 = 获取最近的属性值(所有逻辑对象, this.查询的属性);
        List 查询的结果 = new ArrayList<>();
        for (int i = 0; i <查询的对象.size() ; i++) {
            Document document = 查询的对象.get(i);
            Object 属性值 = document.get(查询的属性);
            if(属性值 !=null){
                查询的结果.add(属性值);
            }
        }
        Document  查询的结果对象 =  new Document();
        查询的结果对象.put(this.查询的结果, 查询的结果);
        所有逻辑对象.add(查询的结果对象);
    }
}
