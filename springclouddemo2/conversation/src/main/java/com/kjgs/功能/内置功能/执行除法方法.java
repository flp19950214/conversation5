package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 执行除法方法 extends 功能抽象 {
    public static final String 被除数 = "被除数";
    public static final String 除数 ="除数";
    public static final String 相除的结果 ="相除的结果";
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(被除数).set参数名2(除数)
                .set结果名(相除的结果);
        异步初始化类.初始化记录内置功能属性(obj);
    }
    @Override
    public void 功能() {
        double 被除数 = Double.parseDouble(获取最近的属性值(所有逻辑对象, this.被除数));
        double 除数 = Double.parseDouble(获取最近的属性值(所有逻辑对象, this.除数));
        Document 相除的结果的对象 = new Document();
        Object result =被除数 / 除数;
        相除的结果的对象.put(this.相除的结果, result);
        相除的结果的对象.put(Cons.level,level);
        所有逻辑对象.add(相除的结果的对象);

        动作结果=result;
    }
}
