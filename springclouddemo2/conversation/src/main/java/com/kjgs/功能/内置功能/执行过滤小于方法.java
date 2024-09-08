package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;


public class 执行过滤小于方法 extends 功能抽象 {
    public static final String 过滤的对象 = "过滤的对象";
    public static final String 过滤的属性 = "过滤的属性";
    public static final String 过滤的属性值 = "过滤的属性值";
    public static final String 过滤的结果 = "过滤的结果";
    @Override
    public void 功能() {
        List<Document> 过滤的对象 = (List<Document>)获取最近的属性值(所有逻辑对象, this.过滤的对象, List.class);
        String 过滤的属性 = 获取最近的属性值(所有逻辑对象, this.过滤的属性);
        double 过滤的属性值 = Double.parseDouble(获取最近的属性值(所有逻辑对象, this.过滤的属性值));

        List<Document> 过滤的结果 = new ArrayList<>();
        for (int i = 0; i <过滤的对象.size() ; i++) {
            Document document = 过滤的对象.get(i);
            double 属性值 = Double.parseDouble(document.getString(过滤的属性));
            if(属性值 < 过滤的属性值){
                过滤的结果.add(document);
            }
        }
        Document  过滤的结果对象 =  new Document();
        过滤的结果对象.put(this.过滤的结果, 过滤的结果);
        所有逻辑对象.add(过滤的结果对象);
    }
}
