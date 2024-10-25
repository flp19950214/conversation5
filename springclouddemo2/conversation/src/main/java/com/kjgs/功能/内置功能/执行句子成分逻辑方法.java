package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.实体.逻辑实体;
import com.kjgs.枚举.Cons;
import com.kjgs.逻辑流程2.新处理逻辑;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 执行句子成分逻辑方法 extends 功能抽象 {
    public static final String 句子成分集合 = "句子成分集合";

    @Autowired
    private 新处理逻辑 新处理逻辑Impl;

    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(句子成分集合);
        异步初始化类.初始化记录内置功能属性(obj);
    }

    @Override
    public void 功能() {
        List<Document> 句子成分集合 =  (List)获取最近的属性值(所有逻辑对象, this.句子成分集合, List.class);
        if(句子成分集合==null)return;
        for (int i = 0; i <句子成分集合.size() ; i++) {
            Document document = 句子成分集合.get(i);
            //更新当前处理的词语、下标对象
            Document 当前处理的词语位置 = 获取最近的对象(所有逻辑对象, Cons.当前处理的词语位置);
            当前处理的词语位置.put(Cons.当前处理的词语位置,document.getString(Cons.在句子中的下标));
            Document 当前处理的词语 = 获取最近的对象(所有逻辑对象, Cons.当前处理的词语);
            当前处理的词语.put(Cons.当前处理的词语,Cons.对象);
            //执行逻辑
            List<Document> 待执行逻辑List = document.get(Cons.待执行逻辑, List.class);
            for (int j = 0; j <待执行逻辑List.size() ; j++) {
                Document 逻辑doc = 待执行逻辑List.get(j);
                逻辑实体 逻辑Obj = new 逻辑实体();
                逻辑Obj.set逻辑(逻辑doc.getString(Cons.当前处理逻辑));
                逻辑Obj.set逻辑名(逻辑doc.getString(Cons.当前处理逻辑名));
                新处理逻辑Impl.执行逻辑(逻辑Obj );
            }
        }
    }
}
