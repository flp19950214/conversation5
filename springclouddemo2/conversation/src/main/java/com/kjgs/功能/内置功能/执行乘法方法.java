package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.枚举.Cons;
import com.kjgs.线程池.异步_初始化记录内置功能属性;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class 执行乘法方法 extends 功能抽象 {
    public static final String 被乘数 = "被乘数";
    public static final String 乘数 ="乘数";
    public static final String 相乘的结果 ="相乘的结果";

    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(被乘数).set参数名2(乘数).set结果名(相乘的结果);
        异步初始化类.初始化记录内置功能属性(obj);
    }

    @Override
    public void 功能() {
        double 被乘数 = Double.parseDouble(获取最近的属性值(所有逻辑对象, this.被乘数));
        double 乘数 = Double.parseDouble(获取最近的属性值(所有逻辑对象, this.乘数));
        double result = 被乘数 * 乘数;
//        Document 相乘的结果的对象 = new Document();
//        相乘的结果的对象.put(this.相乘的结果,result);
//        相乘的结果的对象.put(Cons.level,level);
//        所有逻辑对象.add(相乘的结果的对象);

        动作结果=result;
    }
}
