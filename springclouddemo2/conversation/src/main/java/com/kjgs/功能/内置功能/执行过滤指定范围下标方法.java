package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class 执行过滤指定范围下标方法 extends 功能抽象 {
    public static final String 过滤的对象 = "过滤的对象";
    public static final String 过滤的开始下标 = "过滤的开始下标";
    public static final String 过滤的结束下标 = "过滤的结束下标";
    public static final String 过滤的结果 = "过滤的结果";
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(过滤的对象).set参数名2(过滤的开始下标).set参数名3(过滤的结束下标)
                .set结果名(过滤的结果);
        异步初始化类.初始化记录内置功能属性(obj);
    }
    @Override
    public void 功能() {
        List 过滤的对象 = (List)获取最近的属性值(所有逻辑对象, this.过滤的对象, List.class);
        int 过滤的开始下标 = Integer.parseInt(获取最近的属性值(所有逻辑对象, this.过滤的开始下标));
        int 过滤的结束下标 = Integer.parseInt(获取最近的属性值(所有逻辑对象, this.过滤的结束下标));
        List<Object> 过滤的结果 = new ArrayList<>();
        过滤的结果.addAll(过滤的对象.subList(过滤的开始下标, 过滤的结束下标));
        Document  过滤的结果对象 =  new Document();
        过滤的结果对象.put(this.过滤的结果, 过滤的结果);
        所有逻辑对象.add(过滤的结果对象);
    }
}
