package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 执行减法方法 extends 功能抽象 {
    public static final String 被减数 = "被减数";
    public static final String 减数 ="减数";
    public static final String 相减的结果 ="相减的结果";

    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(被减数).set参数名2(减数).set结果名(相减的结果);
        异步初始化类.初始化记录内置功能属性(obj);
    }

    @Override
    public void 功能() {
        double 被减数 = Double.parseDouble(获取最近的属性值(所有逻辑对象, this.被减数));
        double 减数 = Double.parseDouble(获取最近的属性值(所有逻辑对象, this.减数));
        Document 相减的结果的对象 = new Document();
        double result = 被减数 - 减数;
        相减的结果的对象.put(this.相减的结果, result);
        所有逻辑对象.add(相减的结果的对象);

        动作结果.setLength(0);
        动作结果.append(result);
    }
}
