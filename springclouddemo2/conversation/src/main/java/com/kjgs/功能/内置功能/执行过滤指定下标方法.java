package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 执行过滤指定下标方法 extends 功能抽象 {
    public static final String 过滤的对象 = "过滤的对象";
    public static final String 过滤的下标 = "过滤的下标";
    public static final String 过滤的结果 = "过滤的结果";
    public static final String 查询的结果 = "查询的结果";
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(过滤的对象).set参数名2(过滤的下标).set参数名3(过滤的结果)
                .set结果名(查询的结果);
        异步初始化类.初始化记录内置功能属性(obj);
    }
    @Override
    public void 功能() {
        List 过滤的对象 = (List)获取最近的属性值(所有逻辑对象, this.过滤的对象, List.class);
        int 过滤的下标 = (int)Double.parseDouble(获取最近的属性值(所有逻辑对象, this.过滤的下标));
        Object 过滤的结果=null;
        if(过滤的下标>=0 && 过滤的下标<过滤的对象.size()){
            过滤的结果 = 过滤的对象.get(过滤的下标);
        }
        动作结果=过滤的结果;
    }
}
