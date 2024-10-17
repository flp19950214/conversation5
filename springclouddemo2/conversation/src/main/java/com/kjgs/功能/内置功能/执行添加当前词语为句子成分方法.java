package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能对象;
import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.枚举.Cons;
import com.kjgs.逻辑流程.执行逻辑;
import org.bson.Document;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class 执行添加当前词语为句子成分方法 extends 功能抽象 {
    @Autowired
    private 执行逻辑 执行逻辑;
    @Autowired
    private 功能对象 功能对象Impl;
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName());
        异步初始化类.初始化记录内置功能属性(obj);
    }
    public void 功能(){
        Document document = new Document();
        document.put(Cons.对象类型, Cons.句子成分);
        String 词语 = 功能对象Impl.获取最近的属性值(执行逻辑.所有逻辑对象, Cons.当前处理的词语);
        document.put(Cons.对象,  词语);
        String 当前处理的词语位置 = 功能对象Impl.获取最近的属性值(执行逻辑.所有逻辑对象, Cons.当前处理的词语位置);
        document.put(Cons.在句子中的下标,  当前处理的词语位置);
        document.put(Cons.level,level);
        所有逻辑对象.add(document);
    }

    @Test
    public void test(){
        String 执行添加对象方法= "添加的属性《是》待处理的对象\n添加的属性值《是》如果\n《执行添加对象方法》";
        System.out.println(执行逻辑.所有逻辑对象.size());
    }
}
