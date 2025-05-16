package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 输入句子的成分集合 extends FuncAbstract {
    public 输入句子的成分集合(){
        后面能否跟内置动作=true;
        执行层级=1;
    }

    /**
     * 分词后直接干活
     */
    @Override
    public void 功能() {
        找到前面某个字并赋值指向(逻辑成分);
    }

    public void 找到前面某个字并赋值指向(Document 逻辑成分){

        逻辑成分.put(Cons.指向, 静态引用.输入句子的成分集合);
    }
}
