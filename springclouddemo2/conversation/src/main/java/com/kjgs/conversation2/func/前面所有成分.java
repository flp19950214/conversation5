package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 前面所有成分 extends FuncAbstract {
    public 前面所有成分(){
        后面能否跟内置动作=true;
        执行层级=1;
    }
    @Override
    public void 功能() {
            前面所有成分();
    }

    public void 前面所有成分(){
        找到前面所有成分并赋值指向(逻辑成分);
    }
    public void 找到前面所有成分并赋值指向(Document 逻辑成分){
        List<Document> 指定范围下标的句子成分 = Tool.获取指定范围下标的句子成分(0, 句子下标);
        逻辑成分.put(Cons.指向,Tool.新建一个对象存放集合类型(指定范围下标的句子成分));
    }

}
