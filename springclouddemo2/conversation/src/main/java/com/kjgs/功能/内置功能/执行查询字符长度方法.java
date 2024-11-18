package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.逻辑流程.执行逻辑;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 执行查询字符长度方法 extends 功能抽象 {
    public static final String 查询的字符 = "查询的字符";
    public static final String 查询的结果= "查询的结果";
    @Autowired
    private 执行逻辑 执行逻辑;
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(查询的字符)
                .set结果名(查询的结果);
        异步初始化类.初始化记录内置功能属性(obj);
    }
    @Override
    public void 功能() {
        int 字符长度 =获取最近的属性值(所有逻辑对象, this.查询的字符).length();
        Object 查询的结果 = 字符长度;
        动作结果=查询的结果;
    }

    @Test
    public void test(){
    }
}
