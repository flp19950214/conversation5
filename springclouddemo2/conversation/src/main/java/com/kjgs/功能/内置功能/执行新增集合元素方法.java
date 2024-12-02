package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.逻辑流程.执行逻辑;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 执行新增集合元素方法 extends 功能抽象 {
    public static final String 新增的集合 = "新增的集合";
    public static final String 新增的元素 = "新增的元素";

    @Autowired
    private 执行逻辑 执行逻辑;
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(新增的集合).set参数名2(新增的元素);
        异步初始化类.初始化记录内置功能属性(obj);
    }

    @Override
    public void 功能() {
        List 新增的集合 = (List) 获取最近的属性值(所有逻辑对象, this.新增的集合,List.class);
        Object 新增的元素 = 获取最近的属性值(所有逻辑对象, this.新增的元素, Object.class);
        新增的集合.add(新增的元素);

        动作结果=null;
    }

    @Test
    public void test(){
    }
}
