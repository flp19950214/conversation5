package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import org.springframework.stereotype.Service;

@Service
// 只查数据库对象  区别于  执行查询指定属性值方法
public class 执行获取所有内存对象方法 extends 功能抽象 {

    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName());
        异步初始化类.初始化记录内置功能属性(obj);
    }

    @Override
    public void 功能() {
        动作结果 = 所有逻辑对象;
    }
}
