package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;

import java.util.Arrays;
import java.util.List;

public class 执行获取指定下标值方法 extends 功能抽象 {

    public static final String 查询的对象 = "查询的对象";
    public static final String 查询的下标 = "查询的下标";
    public static final String 查询的结果 = "查询的结果";
    @Override
    public void 功能() {
        String 查询的对象 = 获取最近的属性值(所有逻辑对象, this.查询的对象);
        int 查询的下标 = (int)Double.parseDouble(获取最近的属性值(所有逻辑对象, this.查询的下标));
        Document 分割的结果的对象 = new Document();
        分割的结果的对象.put(this.查询的结果, StringUtils.substring(查询的对象,查询的下标,查询的下标+1));
        所有逻辑对象.add(分割的结果的对象);
    }

}
