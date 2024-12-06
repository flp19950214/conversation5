package com.kjgs.功能.内置功能;

import com.alibaba.fastjson.JSON;
import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import org.springframework.stereotype.Service;

@Service
public class 执行转json方法 extends 功能抽象 {
    public static final String 被转json的对象 = "被转json的对象";

    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(被转json的对象);
        异步初始化类.初始化记录内置功能属性(obj);
    }

    @Override
    public void 功能() {
        Object 获取最近的属性值 = 获取最近的属性值(所有逻辑对象, this.被转json的对象, Object.class);
        String result = JSON.toJSONString(获取最近的属性值);
        动作结果=result;
    }
}
