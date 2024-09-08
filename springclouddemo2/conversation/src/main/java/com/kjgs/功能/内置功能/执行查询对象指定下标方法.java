package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import org.bson.Document;

public class 执行查询对象指定下标方法 extends 功能抽象 {
    private static final String 查询的对象 = "查询的对象";
    private static final String 查询的开始下标 = "查询的开始下标";
    private static final String 查询的结束下标 = "查询的结束下标";
    private static final String 查询的结果 = "查询的结果";
    @Override
    public void 功能() {
        String 查询的对象 = 获取最近的属性值(所有逻辑对象, this.查询的对象);
        int 查询的开始下标 = Integer.parseInt(获取最近的属性值(所有逻辑对象, this.查询的开始下标));
        int 查询的结束下标 = Integer.parseInt(获取最近的属性值(所有逻辑对象, this.查询的结束下标));
        Document 查询的结果对象 =  new Document();
        查询的结果对象.put(this.查询的结果, 查询的对象.substring(查询的开始下标, 查询的结束下标));
        所有逻辑对象.add(查询的结果对象);
    }
}
