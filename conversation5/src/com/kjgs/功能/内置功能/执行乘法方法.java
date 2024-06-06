package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import org.bson.Document;

public class 执行乘法方法 extends 功能抽象 {
    public static final String 被乘数 = "被乘数";
    public static final String 乘数 ="乘数";
    public static final String 相乘的结果 ="相乘的结果";

    @Override
    public void 功能() {
        double 被乘数 = Double.parseDouble(获取最近的属性值(所有逻辑对象, this.被乘数));
        double 乘数 = Double.parseDouble(获取最近的属性值(所有逻辑对象, this.乘数));
        Document 相乘的结果的对象 = new Document();
        相乘的结果的对象.put(this.相乘的结果, 被乘数 * 乘数);
        所有逻辑对象.add(相乘的结果的对象);
    }
}
