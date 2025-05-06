package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 中的 extends FuncAbstract {
    public 中的(){
        执行层级=1;
        后面能否跟内置动作=true;
    }

    @Override
    public void 功能() {
        //给后面的属性添加所属对象
        Document 指定前面下标的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Document 指定后面下标的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        if(指定前面下标的逻辑成分 == null || 指定后面下标的逻辑成分 == null){
            return;
        }
        指定后面下标的逻辑成分.put(Cons.归属对象, 指定前面下标的逻辑成分);
    }
}
