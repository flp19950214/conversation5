package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;

import java.util.Arrays;
import java.util.List;

public class 执行分割方法 extends 功能抽象 {

    public static final String 被分割的对象 = "被分割的对象";
    public static final String 分割词 = "分割词";
    public static final String 分割的结果 = "分割的结果";
    @Override
    public void 功能() {
        String 被分割的对象 = 获取最近的属性值(所有逻辑对象, this.被分割的对象);
        String 分割词 = 获取最近的属性值(所有逻辑对象, this.分割词);
        List<String> 分割的结果 = Arrays.asList(StringUtils.split(被分割的对象, 分割词));
        Document 分割的结果的对象 = new Document();
        分割的结果的对象.put(this.分割的结果, 分割的结果);
        所有逻辑对象.add(分割的结果的对象);
    }

}
