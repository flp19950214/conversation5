package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class 和 extends FuncAbstract {
    public 和(){
        后面能否跟内置动作=true;
    }
    @Override
    public void 功能() {
        合并前后成分并指向多成分();
    }
    public void 合并前后成分并指向多成分(){
        //前面一个成分包含后面一个成分
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Document 指定下标后面的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        if(指定下标前面的逻辑成分 == null || 指定下标后面的逻辑成分 == null){
            return;
        }

        添加指向(逻辑成分, 指定下标前面的逻辑成分, 指定下标后面的逻辑成分);
    }

    public void 添加指向(Document 新逻辑成分, Document 指定下标前面的逻辑成分,Document 指定下标后面的逻辑成分){
        List<Document> 多成分 = new ArrayList<>();
        多成分.add(指定下标前面的逻辑成分);
        if(Tool.判断对象指向是否是集合(指定下标后面的逻辑成分)){
            多成分.addAll(指定下标后面的逻辑成分.get(Cons.指向, List.class));
        }else{
            多成分.add(指定下标后面的逻辑成分);
        }

        新逻辑成分.put(Cons.并列集合, 多成分);
    }
}
