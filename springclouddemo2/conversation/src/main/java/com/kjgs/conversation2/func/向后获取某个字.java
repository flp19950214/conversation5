package com.kjgs.conversation2.func;

import com.kjgs.conversation.mysql.Impl逻辑;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class 向后获取某个字 extends FuncAbstract {
    public 向后获取某个字(){
        后面能否跟内置动作=false;
    }
    @Autowired
    Impl逻辑 impl逻辑;
    @PostConstruct
    public void init(){
    }
    @Override
    public void 功能() {
        判断句的包含动作();
    }

    public void 判断句的包含动作(){
        //向前找后面某个字
        Document 指定下标前面的句子成分 = Tool.指定下标前面一个句子成分(句子下标);
        if(指定下标前面的句子成分 == null || !指定下标前面的句子成分.containsKey(Cons.属于)
                || !指定下标前面的句子成分.containsKey(Cons.个数)
        || !指定下标前面的句子成分.getString(Cons.属于).equals(Cons.后面某个字)
        ){
            return;
        }
        int 个数 = 指定下标前面的句子成分.getInteger(Cons.个数);
        String 词语 = 句子.substring(句子结束下标, 句子结束下标+个数);
        Document 新句子成分 = new Document();
        新句子成分.put(Cons._id, new ObjectId());
        新句子成分.put(Cons.词语, 词语);
        新句子成分.put(Cons.下标, 句子结束下标);
        新句子成分.put(Cons.结束下标, 句子结束下标 + 个数);
        新句子成分.put(Cons.是否是句子成分, true);
        逻辑成分.put(Cons.指向, 新句子成分);
    }
}
