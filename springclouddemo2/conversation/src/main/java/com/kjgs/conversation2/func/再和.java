package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.apache.commons.collections4.CollectionUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class 再和 extends FuncAbstract {
    public 再和(){
        后面能否跟内置动作=true;
    }

    @Override
    public void 功能() {
        找到前面一个并列集合再合并到后面一个集合();
    }
    public void 找到前面一个并列集合再合并到后面一个集合(){
        Document 指定下标前面的包含并列集合的逻辑成分 = Tool.指定下标前面包含某key的逻辑成分(下标, Cons.并列集合);
        if(指定下标前面的包含并列集合的逻辑成分 == null){
            return;
        }
        List<Document> 子成分 = 指定下标前面的包含并列集合的逻辑成分.get(Cons.并列集合, List.class);
        if(CollectionUtils.isEmpty(子成分)){
            return;
        }
        Document 指定下标后面的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        if(指定下标后面的逻辑成分 == null){
            return;
        }
        List<Document> 多成分 = new ArrayList<>();
        多成分.addAll(子成分);
        多成分.add(指定下标后面的逻辑成分);
        逻辑成分.put(Cons.并列集合, 多成分);
    }
}
