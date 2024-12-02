package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 将是否执行判断结果设置为true extends 功能抽象 {
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName());
        异步初始化类.初始化记录内置功能属性(obj);
    }

    @Override
    public void 功能() {
        Document 获取最近的对象 = 获取最近的对象(所有逻辑对象, Cons.是否执行判断结果);
        获取最近的对象.put(Cons.是否执行判断结果, true);
        动作结果=true;
    }
}
