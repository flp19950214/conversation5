package com.kjgs.功能.整合功能;

import com.alibaba.fastjson.JSON;
import com.kjgs.功能.功能抽象;
import com.kjgs.枚举.Cons;
import com.kjgs.静态变量;
import javafx.util.Pair;
import org.bson.Document;

public class 执行添加查询条件键值对方法 extends 功能抽象 {
    @Override
    public void 初始化记录内置功能属性() {

    }

    @Override
    public void 功能() {
        Object 查询条件的值 = 获取最近的属性值(所有逻辑对象, Cons.查询条件的值,Object.class);
        Object 查询条件的键 = 获取最近的属性值(所有逻辑对象, Cons.查询条件的键,Object.class);
        Document document = new Document();
        Pair pair = new Pair(查询条件的键, 查询条件的值);
        document.put(Cons.查询条件, pair);
        所有逻辑对象.add(document);
        静态变量.添加执行层级集合(String.format("%s %s", level, " 添加查询条件键值对的结果："+ JSON.toJSONString(pair)));
    }
}
