package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能对象;
import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.枚举.Cons;
import com.kjgs.逻辑流程.执行逻辑;
import com.kjgs.静态变量;
import org.bson.Document;
import org.bson.types.ObjectId;
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
        Document 成分对象 = new Document();
        成分对象.put(Cons._id, new ObjectId());
        成分对象.put(Cons.对象类型, Cons.句子成分);
        String 词语 = 功能对象Impl.获取最近的属性值(执行逻辑.所有逻辑对象, Cons.当前处理的词语);
        成分对象.put(Cons.对象,  词语);
        String 当前处理的词语位置 = 功能对象Impl.获取最近的属性值(执行逻辑.所有逻辑对象, Cons.当前处理的词语位置);
        成分对象.put(Cons.在句子中的下标,  当前处理的词语位置);
        成分对象.put(Cons.level,level);
        所有逻辑对象.add(成分对象);

        Document 当前处理的句子成分 =(Document)获取最近的属性值(所有逻辑对象, Cons.当前处理的句子成分, Document.class);
        当前处理的句子成分.put(Cons.当前处理的句子成分,  成分对象);
        所有逻辑对象.add(当前处理的句子成分);
    }
}
