package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import org.springframework.stereotype.Service;

@Service
public class 执行取反方法 extends 功能抽象 {
    public static final String 被取反的对象 = "被取反的对象";
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(被取反的对象);
        异步初始化类.初始化记录内置功能属性(obj);
    }
    @Override
    public void 功能() {
        String 被取反的对象 = 获取最近的属性值(所有逻辑对象, this.被取反的对象);
        boolean b = Boolean.parseBoolean(被取反的对象);
        动作结果=!b;
    }
}
