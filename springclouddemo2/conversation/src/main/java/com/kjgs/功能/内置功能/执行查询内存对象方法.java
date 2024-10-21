package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import org.springframework.stereotype.Service;

@Service
// 只查数据库对象  区别于  执行查询指定属性值方法
public class 执行查询内存对象方法 extends 功能抽象 {
    public static final String 查询的属性 = "查询的属性";
    public static final String 查询的属性值 = "查询的属性值";
    public static final String 查询的对象类型 = "查询的对象类型";
    public static final String 查询的结果 = "查询的结果";

    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(查询的属性).set参数名2(查询的属性值)
                .set结果名(查询的结果);
        异步初始化类.初始化记录内置功能属性(obj);
    }

    @Override
    public void 功能() {
        // 属性值为空 就只匹配键
        String 查询的属性 = 获取最近的属性值(所有逻辑对象, this.查询的属性);
        String 查询的属性值 = 获取最近的属性值(所有逻辑对象, this.查询的属性值);
        String 查询的对象类型 = 获取最近的属性值(所有逻辑对象, this.查询的对象类型);

        Object 查询的结果 = 获取最近的对象(所有逻辑对象, 查询的属性, 查询的属性值, 查询的对象类型);
        动作结果 = 查询的结果;
    }
}
