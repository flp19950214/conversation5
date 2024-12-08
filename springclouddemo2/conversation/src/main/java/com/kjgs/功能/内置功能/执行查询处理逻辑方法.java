package com.kjgs.功能.内置功能;

import com.kjgs.conversation.mysql.逻辑Impl;
import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.实体.逻辑实体;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 执行查询处理逻辑方法 extends 功能抽象 {
    public static final String 查询的逻辑名 = "查询的逻辑名";

    @Autowired
    private 逻辑Impl 逻辑Mapper;

    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(查询的逻辑名);
        异步初始化类.初始化记录内置功能属性(obj);
    }

    @Override
    public void 功能() {
        String 查询的逻辑名 = 获取最近的属性值(所有逻辑对象, this.查询的逻辑名);
        List<逻辑实体> 逻辑集合 = 逻辑Mapper.根据逻辑名查询所有处理逻辑(查询的逻辑名);
        动作结果=逻辑集合;
    }
}
