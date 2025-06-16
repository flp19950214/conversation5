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
        Document 指定下标前面的逻辑成分_无迭代 = Tool.指定下标前面的逻辑成分_无迭代(下标, "合并为");
        if(指定下标前面的逻辑成分_无迭代 == null  || !指定下标前面的逻辑成分_无迭代.containsKey(Cons.指向)){
            return;
        }
        Document 执行查询句子成分方法的值 = Tool.指定下标前面的逻辑成分(下标, "合并为");
        if(执行查询句子成分方法的值 == null){
            return;
        }
        if(Tool.获取是或者作为的值(执行查询句子成分方法的值) == null ){
            return;
        }
        逻辑成分.put(Cons.指向, Tool.生成动作结果指向对象(执行查询句子成分方法的值));
    }
}
