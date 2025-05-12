package com.kjgs.conversation2.func;

import com.kjgs.conversation.mysql.Impl逻辑;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class 后面某个成分 extends FuncAbstract {
    public 后面某个成分(){
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
        Integer 量词 = Tool.转数字(StringUtils.substringBetween(逻辑词语, "后面", "个成分"));
        if(量词 == null){
            return;
        }
        找到后面1个成分并赋值指向(逻辑成分, 量词);
    }

    public void 找到后面1个成分并赋值指向(Document 逻辑成分, int num){
        if(句子下标 + num + 1> 句子.length()){
            return;
        }
        List<Document> 指定下标后面连续的句子成分 = Tool.指定下标后面连续的句子成分(句子结束下标, num);
        if(CollectionUtils.isEmpty(指定下标后面连续的句子成分)){
            return;
        }
        if(指定下标后面连续的句子成分.size()==1 && num==1){
            逻辑成分.put(Cons.指向, 指定下标后面连续的句子成分.get(0));
        }else{
            逻辑成分.put(Cons.指向, 指定下标后面连续的句子成分);
        }
    }
}
