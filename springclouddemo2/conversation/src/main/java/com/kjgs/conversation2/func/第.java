package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 第 extends FuncAbstract {
    @Override
    public void 功能() {
        作用到后面第一个名词();
    }

    public void 作用到后面第一个名词(){
        Document 往后找指定词性的逻辑成分1 = Tool.往后找指定词性的逻辑成分(下标, Cons.数字);
        Document 往后找指定词性的逻辑成分 = Tool.往后找指定词性的逻辑成分(下标, Cons.名词);
        if(往后找指定词性的逻辑成分 == null || 往后找指定词性的逻辑成分1 == null){
            return;
        }
        Integer 数字 = 往后找指定词性的逻辑成分1.getInteger(Cons.词语);
        往后找指定词性的逻辑成分.put(Cons.序号词, 数字);
    }

}
