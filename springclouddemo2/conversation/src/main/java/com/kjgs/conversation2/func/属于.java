package com.kjgs.conversation2.func;

import com.kjgs.conversation.mysql.Impl逻辑;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class 属于 extends FuncAbstract {
    public 属于(){
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
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Document 指定下标后面的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        if(指定下标前面的逻辑成分 == null || 指定下标后面的逻辑成分 == null){
            return;
        }

        //前面一个成分的属于属性等于后面一个成分
        boolean result = 指定下标前面的逻辑成分.containsKey(Cons.属于) &&
                指定下标前面的逻辑成分.getString(Cons.属于).equals(指定下标后面的逻辑成分.getString(Cons.词语));
        Tool.赋值判断结果(逻辑成分, result);
    }
}
