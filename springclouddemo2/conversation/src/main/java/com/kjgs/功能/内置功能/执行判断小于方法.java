package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 执行判断小于方法 extends 功能抽象 {
    public static final String 被判断的对象 = "被判断的对象";
    public static final String 判断的对象 ="判断的对象";
    public static final String 判断的结果 ="判断的结果";
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(被判断的对象).set参数名2(判断的对象).set结果名(判断的结果);
        异步初始化类.初始化记录内置功能属性(obj);
    }
    @Override
    public void 功能() {
        String 被判断的对象 = 获取最近的属性值(所有逻辑对象, this.被判断的对象);
        String 判断的对象 = 获取最近的属性值(所有逻辑对象, this.判断的对象);
        boolean 判断的结果 = 被判断的对象.compareTo(判断的对象)<0;
        Document 判断的结果的对象 = new Document();
        判断的结果的对象.put(this.判断的结果, 判断的结果);
        判断的结果的对象.put(Cons.level,level);
        所有逻辑对象.add(判断的结果的对象);

        动作结果=判断的结果;
    }
}
