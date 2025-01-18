package com.kjgs.功能.整合功能;

import com.kjgs.conversation.service.Service逻辑处理;
import com.kjgs.功能.功能抽象;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class 执行新合成的逻辑成分  extends 功能抽象 {
    private String 新合成的逻辑成分 = "新合成的逻辑成分";

    @Autowired
    private Service逻辑处理 service逻辑处理;

    @Override
    public void 初始化记录内置功能属性() {

    }

    @Override
    public void 功能() {
        Document 成分对象 = (Document) 获取最近的属性值(所有逻辑对象, this.新合成的逻辑成分, Document.class);
        成分对象.put(Cons.是否是当前处理的句子成分, true);
        service逻辑处理.process(成分对象.getString(Cons.词语), Service逻辑处理.逻辑成分执行阶段);
        成分对象.put(Cons.是否是当前处理的句子成分, false);
    }
}
