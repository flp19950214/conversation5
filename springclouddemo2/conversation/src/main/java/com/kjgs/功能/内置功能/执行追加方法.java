package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 执行追加方法 extends 功能抽象 {
    public static final String 被追加的对象 = "被追加的对象";
    public static final String 追加的对象 ="追加的对象";
    public static final String 追加的结果 ="追加的结果";
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(被追加的对象).set参数名2(追加的对象)
                .set结果名(追加的结果);
        异步初始化类.初始化记录内置功能属性(obj);
    }
    @Override
    public void 功能() {
        String 被追加的对象 = 获取最近的属性值(所有逻辑对象, this.被追加的对象);
        String 追加的对象 = 获取最近的属性值(所有逻辑对象, this.追加的对象);
        Document 追加的结果的对象 = new Document();
        追加的结果的对象.put(this.追加的结果, 被追加的对象+追加的对象);
        所有逻辑对象.add(追加的结果的对象);
    }
}
