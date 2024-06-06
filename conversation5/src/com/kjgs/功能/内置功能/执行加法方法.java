package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import org.bson.Document;

public class 执行加法方法 extends 功能抽象 {
    public static final String 被加数 = "被加数";
    public static final String 加数 ="加数";
    public static final String 相加的结果 ="相加的结果";

    @Override
    public void 功能() {
        double 被加数 = Double.parseDouble(获取最近的属性值(所有逻辑对象, this.被加数));
        double 加数 = Double.parseDouble(获取最近的属性值(所有逻辑对象, this.加数));
        Document 相加的结果的对象 = new Document();
        相加的结果的对象.put(this.相加的结果, 被加数 + 加数);
        所有逻辑对象.add(相加的结果的对象);
    }
}
