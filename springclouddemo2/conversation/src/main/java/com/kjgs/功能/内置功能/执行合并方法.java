package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 执行合并方法 extends 功能抽象 {
    public static final String 被合并的对象 = "被合并的对象";
    public static final String 合并的对象 ="合并的对象";
    public static final String 合并的结果 ="合并的结果";
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(被合并的对象).set参数名2(合并的对象)
                .set结果名(合并的结果);
        异步初始化类.初始化记录内置功能属性(obj);
    }
    @Override
    public void 功能() {
        String 被合并的对象 = 获取最近的属性值(所有逻辑对象, this.被合并的对象);
        String 合并的对象 = 获取最近的属性值(所有逻辑对象, this.合并的对象);
        Document 合并的结果对象 = new Document();
        Object result = 被合并的对象+合并的对象;
        合并的结果对象.put(this.合并的结果, result);
        合并的结果对象.put(Cons.level,level);
        所有逻辑对象.add(合并的结果对象);

        动作结果=result;
    }
}
