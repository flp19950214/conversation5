package com.kjgs.conversation2.func;

import com.kjgs.conversation.mysql.Impl逻辑;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class 再后面某个成分 extends FuncAbstract {
    public 再后面某个成分(){
        后面能否跟内置动作=true;
        执行层级=1;
    }
    @Autowired
    Impl逻辑 impl逻辑;

    @PostConstruct
    public void init(){
    }
    @Override
    public void 功能() {
        Integer 量词 = Tool.转数字(StringUtils.substringBetween(逻辑词语, "再后面", "个成分"));
        if(量词 == null){
            return;
        }
        找到后面1个成分并赋值指向(逻辑成分, 量词);
    }

    public void 找到后面1个成分并赋值指向(Document 逻辑成分, int num){
        if(句子下标 + num + 1> 句子.length()){
            return;
        }
        Document 新句子成分 = Tool.指定下标后面一个句子成分(句子结束下标);
        if(新句子成分==null){
            return;
        }
        Document 新句子成分2 = Tool.指定下标后面一个句子成分(新句子成分.getInteger(Cons.结束下标));
        if(新句子成分2 != null){
            逻辑成分.put(Cons.指向,新句子成分2);
        }
    }
}
