package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.静态变量;

public class 执行输出结果方法 extends 功能抽象 {
    final static String 输出结果 = "输出结果";
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName());
        异步初始化类.初始化记录内置功能属性(obj);
    }

    @Override
    public void 功能() {
        String 输出结果 = 获取最近的属性值(所有逻辑对象, this.输出结果);
        System.out.println(输出结果);
        静态变量.输出结果 = 输出结果;
    }
}
