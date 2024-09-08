package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import org.bson.Document;

public class 执行除法方法 extends 功能抽象 {
    public static final String 被除数 = "被除数";
    public static final String 除数 ="除数";
    public static final String 相除的结果 ="相除的结果";

    @Override
    public void 功能() {
        double 被除数 = Double.parseDouble(获取最近的属性值(所有逻辑对象, this.被除数));
        double 除数 = Double.parseDouble(获取最近的属性值(所有逻辑对象, this.除数));
        Document 相除的结果的对象 = new Document();
        相除的结果的对象.put(this.相除的结果, 被除数 / 除数);
        所有逻辑对象.add(相除的结果的对象);
    }
}
