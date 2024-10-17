package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.枚举.Cons;
import com.kjgs.静态变量;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 执行加法方法 extends 功能抽象 {
    public static final String 被加数 = "被加数";
    public static final String 加数 ="加数";
    public static final String 相加的结果 ="相加的结果";
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(被加数).set参数名2(加数).set结果名(相加的结果);
        异步初始化类.初始化记录内置功能属性(obj);
    }
    @Override
    public void 功能() {
        double 被加数 = Double.parseDouble(获取最近的属性值(所有逻辑对象, this.被加数));
        double 加数 = Double.parseDouble(获取最近的属性值(所有逻辑对象, this.加数));
        double result = 被加数 + 加数;

//        Document 相加的结果的对象 = new Document();
//        相加的结果的对象.put(this.相加的结果, result);
//        相加的结果的对象.put(Cons.level,level);
//        所有逻辑对象.add(相加的结果的对象);

        动作结果=result;
    }
}
