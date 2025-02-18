package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 当前词 extends FuncAbstract {
    @Override
    public void 功能() {
        添加指向();
    }

    public void 添加指向(){
        //指向当前句子成分
        逻辑成分.put(Cons.指向, 句子成分);
    }
}
