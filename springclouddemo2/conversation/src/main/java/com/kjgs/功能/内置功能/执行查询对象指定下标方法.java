package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 执行查询对象指定下标方法 extends 功能抽象 {
    private static final String 查询的对象 = "查询的对象";
    private static final String 查询的开始下标 = "查询的开始下标";
    private static final String 查询的结束下标 = "查询的结束下标";
    private static final String 查询的结果 = "查询的结果";
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(查询的对象).set参数名2(查询的开始下标)
                .set参数名3(查询的结束下标).set结果名(查询的结果);
        异步初始化类.初始化记录内置功能属性(obj);
    }
    @Override
    public void 功能() {
        String 查询的对象 = 获取最近的属性值(所有逻辑对象, this.查询的对象);
        int 查询的开始下标 = Integer.parseInt(获取最近的属性值(所有逻辑对象, this.查询的开始下标));
        int 查询的结束下标 = Integer.parseInt(获取最近的属性值(所有逻辑对象, this.查询的结束下标));
        Document 查询的结果对象 =  new Document();
        String 查询的结果 =  查询的对象.substring(查询的开始下标, 查询的结束下标);
        查询的结果对象.put(this.查询的结果,查询的结果);
        所有逻辑对象.add(查询的结果对象);

        动作结果.setLength(0);
        动作结果.append(查询的结果);
    }
}
