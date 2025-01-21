package com.kjgs.功能.整合功能;

import com.alibaba.fastjson.JSON;
import com.kjgs.conversation.service.ToolService;
import com.kjgs.功能.功能抽象;
import com.kjgs.枚举.Cons;
import com.kjgs.静态变量;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class 合并当前逻辑成分和下一个字为新逻辑成分  extends 功能抽象 {

    @Autowired
    获取当前逻辑句子成分的下一个字 获取当前逻辑句子成分的下一个字Impl;

    @Override
    public void 初始化记录内置功能属性() {

    }

    @Override
    public void 功能() {
        String 前逻辑句子成分的下一个字 =  获取当前逻辑句子成分的下一个字Impl.下一个字();
        Document 获取当前逻辑句子成分 = ToolService.获取当前逻辑句子成分(uuidLevel);
        Document 成分对象 = new Document();
        成分对象.put(Cons._id, new ObjectId());
        成分对象.put(Cons.对象类型, Cons.逻辑句子成分);
        String 词语 = 获取当前逻辑句子成分.get(Cons.词语)+前逻辑句子成分的下一个字;
        成分对象.put(Cons.词语, 词语);
        int 在句子中的下标 = 获取当前逻辑句子成分.getInteger(Cons.在句子中的下标);
        成分对象.put(Cons.在句子中的下标, 获取当前逻辑句子成分.getInteger(Cons.在句子中的下标));
        成分对象.put(Cons.在句子中的结束下标,  获取当前逻辑句子成分.getInteger(Cons.在句子中的结束下标) + 1);
        成分对象.put(Cons.level, level);
        成分对象.put(Cons.uuidLevel, uuidLevel);
        静态变量.添加执行层级集合(String.format("%s %s", level, " 新合成逻辑成分的结果："+ JSON.toJSONString(成分对象)));
        if(!ToolService.是否存在逻辑对象(uuidLevel, 词语, 在句子中的下标) ){
            所有逻辑对象.add(成分对象);
        }
        this.动作结果=成分对象;
    }
}
