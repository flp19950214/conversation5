package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import org.bson.Document;

public class 执行减法方法 extends 功能抽象 {
    public static final String 被减数 = "被减数";
    public static final String 减数 ="减数";
    public static final String 相减的结果 ="相减的结果";

    @Override
    public void 功能() {
        double 被减数 = Double.parseDouble(获取最近的属性值(所有逻辑对象, this.被减数));
        double 减数 = Double.parseDouble(获取最近的属性值(所有逻辑对象, this.减数));
        Document 相减的结果的对象 = new Document();
        相减的结果的对象.put(this.相减的结果, 被减数 - 减数);
        所有逻辑对象.add(相减的结果的对象);
    }
}
