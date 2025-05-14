package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 前面所有字 extends FuncAbstract {
    public 前面所有字(){
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
        Document 新句子成分 = new Document();

        新句子成分.put(Cons.词语, 句子.substring(0, 句子下标));
        新句子成分.put(Cons.下标, 0);
        新句子成分.put(Cons.结束下标, 句子下标);
        新句子成分.put(Cons.是否是句子成分, true);

        逻辑成分.put(Cons.指向,新句子成分);
    }
}
