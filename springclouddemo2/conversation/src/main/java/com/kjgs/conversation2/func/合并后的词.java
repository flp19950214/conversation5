package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 合并后的词 extends FuncAbstract {
    public 合并后的词(){
        后面能否跟内置动作=true;
    }
    @Override
    public void 功能() {
        找合并的结果();
    }

    public void 找合并的结果(){
        //往前找动作对象的动作结果
        Document 合并后的词 = Tool.往前根据属性找对象(Cons.合并的结果, 下标);
        if(合并后的词 != null){
            逻辑成分.put(Cons.指向, 合并后的词.get(Cons.合并的结果));
        }
    }
}
