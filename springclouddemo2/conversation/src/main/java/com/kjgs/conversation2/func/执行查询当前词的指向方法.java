package com.kjgs.conversation2.func;

import com.kjgs.conversation.mysql.Impl数据;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class 执行查询当前词的指向方法 extends FuncAbstract {
    public 执行查询当前词的指向方法(){
        后面能否跟内置动作=true;
    }
    @Autowired
    private Impl数据 impl数据;

    public void 功能() {

    }

    @Override
    public void 判断结果是true时执行(){
        boolean 判断结果 = Tool.往前找判断结果(下标);
        if(!判断结果){
            return;
        }
        查询当前词的指向属性();
    }
    public void 查询当前词的指向属性(){
        Document 代词的最终指向 = Tool.代词的最终指向(句子成分);
        if(代词的最终指向 == null){
            return;
        }
        if(代词的最终指向.containsKey(Cons.指向)){
            逻辑成分.put(Cons.指向, 代词的最终指向.get(Cons.指向));
        }else{
            逻辑成分.put(Cons.指向, 代词的最终指向.get(Cons.词语));
        }
    }

}
