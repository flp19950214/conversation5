package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 左尖括号 extends FuncAbstract {
    public 左尖括号(){
        后面能否跟内置动作=true;
        执行层级=1;
    }
    public void 功能() {
        合并左右尖括号中的内容();
    }

    public void 合并左右尖括号中的内容(){
        //往后找到右尖括号
        Document 往后找指定词语的逻辑成分 = Tool.往后找指定词语的逻辑成分(下标, Cons.右尖括号);
        if(往后找指定词语的逻辑成分 == null || !往后找指定词语的逻辑成分.containsKey(Cons.下标)){
            return;
        }
        //满足条件 合并果，创建新成分，删除旧成分
        String 新词语 = Tool.合并逻辑集合指定范围的词语(下标+1, Tool.转数字(往后找指定词语的逻辑成分.get(Cons.下标))-1);
        逻辑成分.put(Cons.词语, 新词语);
        Tool.删除指定范围下标的逻辑成分(下标+1, Tool.转数字(往后找指定词语的逻辑成分.get(Cons.下标))+1);
    }

}
