package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 排序有讲究
 * 只做基础类型的排序  想办法把很高级的聚合转成基础类型的排序，就像人一样思考。人脑可没有现成的复杂排序方法
 */
@Service
public class 执行集合去重方法 extends 功能抽象 {
    public static final String 被去重的集合 = "被去重的集合";

    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(被去重的集合);
        异步初始化类.初始化记录内置功能属性(obj);
    }

    @Override
    public void 功能() {
        List<String> 被去重的集合 = (List) 获取最近的属性值(所有逻辑对象, this.被去重的集合,List.class);
        被去重的集合 = 被去重的集合.stream().distinct().collect(Collectors.toList());
        动作结果 = 被去重的集合;
    }
}
