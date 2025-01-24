package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.枚举.Cons;
import com.kjgs.静态变量;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 执行判断不为空方法 extends 功能抽象 {
    public static final String 被判断的对象 = "被判断的对象";
    public static final String 判断的结果 ="判断的结果";
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(被判断的对象).set结果名(判断的结果);
        异步初始化类.初始化记录内置功能属性(obj);
    }
    @Override
    public void 功能() {
        String 被判断的对象 = 获取最近的属性值(所有逻辑对象, this.被判断的对象);
        boolean 判断的结果 = 被判断的对象 != null && 被判断的对象 !="";

        静态变量.添加执行层级集合(String.format("%s %s", level, " 执行判断不为空方法的结果：" + 判断的结果));

        动作结果=判断的结果;
    }
}
