package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.逻辑流程.执行逻辑;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class 执行集合排序方法 extends 功能抽象 {
    public static final String 被合并的集合 = "被合并的集合";
    public static final String 合并的集合 = "合并的集合";

    @Autowired
    private 执行逻辑 执行逻辑;
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(被合并的集合).set参数名2(合并的集合);
        异步初始化类.初始化记录内置功能属性(obj);
    }

    @Override
    public void 功能() {
        List 被合并的集合 = (List) 获取最近的属性值(所有逻辑对象, this.被合并的集合,List.class);
        if(被合并的集合==null){
            被合并的集合 = new ArrayList();
        }
        List 合并的集合 = (List) 获取最近的属性值(所有逻辑对象, this.合并的集合,List.class);
        if(合并的集合!=null){
            被合并的集合.addAll(合并的集合);
        }
        动作结果 = 被合并的集合;
    }

    @Test
    public void test(){
    }
}
