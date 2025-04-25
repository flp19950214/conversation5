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
public class 后面的内容 extends FuncAbstract {
    @Autowired
    Impl逻辑 impl逻辑;
    @PostConstruct
    public void init(){
    }

    @Override
    public void 功能() {
        后面的内容();
    }

    public void 后面的内容(){
        //找到句子后面的内容，并赋值指向
        Document 新句子成分 = new Document();
        新句子成分.put(Cons._id, new ObjectId());
        if(句子结束下标>=句子.length()){return;}
        新句子成分.put(Cons.词语, 句子.substring(句子结束下标));
        新句子成分.put(Cons.下标, 句子结束下标);
        新句子成分.put(Cons.结束下标, 句子.length());
        新句子成分.put(Cons.是否是句子成分, true);
        逻辑成分.put(Cons.指向,新句子成分);
    }
}
