package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 删除 extends FuncAbstract {
    public 删除(){
        后面能否跟内置动作=false;
    }


    @Override
    public void 功能() {
    }

    @Override
    public void 判断结果是true时执行(){
        boolean 判断结果 = Tool.往前找判断结果(下标);
        if(!判断结果){
            return;
        }
        从什么中删除什么(逻辑成分);
    }

    public void 从什么中删除什么(Document 逻辑成分){
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Document 指定下标后面的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        if(指定下标前面的逻辑成分 == null || 指定下标后面的逻辑成分 == null){
            return;
        }
        if(StringUtils.equals(指定下标前面的逻辑成分.getString(Cons.词语), Cons.中)){
            指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(指定下标前面的逻辑成分.getInteger(Cons.下标));
        }
        if(!指定下标前面的逻辑成分.containsKey(Cons.指向)){
            return;
        }
        if(!(指定下标前面的逻辑成分.get(Cons.指向) instanceof List)){
            return;
        }
        //从集合中删除
        List<Document> 集合 = 指定下标前面的逻辑成分.get(Cons.指向, List.class);
        for (int i = 0; i < 集合.size(); i++) {
            if(集合.get(i).getObjectId(Cons._id).equals(指定下标后面的逻辑成分.getObjectId(Cons._id))){
                集合.remove(i);
            }
        }

    }
}
