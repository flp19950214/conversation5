package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 后面所有成分 extends FuncAbstract {
    @Override
    public void 功能() {
        后面所有成分();
    }

    public void 后面所有成分(){
        找到后面所有成分并赋值指向(逻辑成分);
    }
    public void 找到后面所有成分并赋值指向(Document 逻辑成分){
        List<Document> 指定范围下标的句子成分 = Tool.获取指定范围下标的句子成分(句子结束下标, null);
        逻辑成分.put(Cons.指向,Tool.新建一个对象存放集合类型(指定范围下标的句子成分));
    }

}
