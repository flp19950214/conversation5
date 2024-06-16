package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;

import java.util.List;

public class 执行判断集合是否为空方法 extends 功能抽象 {
    public static final String 被判断的对象 = "被判断的对象";
    public static final String 判断的结果 ="判断的结果";

    @Override
    public void 功能() {
        List 被判断的对象 =  (List)获取最近的属性值(所有逻辑对象, this.被判断的对象, List.class);
        boolean 判断的结果 = CollectionUtils.isEmpty(被判断的对象);
        Document 判断的结果的对象 = new Document();
        判断的结果的对象.put(this.判断的结果, 判断的结果);
        所有逻辑对象.add(判断的结果的对象);
    }
}
