package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.枚举.Cons;
import com.kjgs.静态变量;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 执行新增一个对象方法 extends 功能抽象 {
    public static final String 新增的对象值 = "新增的对象值";
    public static final String 新增的对象属性 = "新增的对象属性";
    public static final String 新增的对象属性值 = "新增的对象属性值";
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(新增的对象值)
                .set参数名2(新增的对象属性).set参数名3(新增的对象属性值);
        异步初始化类.初始化记录内置功能属性(obj);
    }
    @Override
    public void 功能() {
        Object 新增的对象值 = 获取最近的属性值(所有逻辑对象, this.新增的对象值, Object.class);
        String 新增的对象属性 = 获取最近的属性值(所有逻辑对象, this.新增的对象属性);
        Object 新增的对象属性值 = 获取最近的属性值(所有逻辑对象, this.新增的对象属性值, Object.class);
        Document 新增的对象 = new Document();
        新增的对象.put(Cons.词语, 新增的对象值);
        新增的对象.put(新增的对象属性, 新增的对象属性值);
        所有逻辑对象.add(新增的对象);
        动作结果 = 新增的对象;

    }
}
