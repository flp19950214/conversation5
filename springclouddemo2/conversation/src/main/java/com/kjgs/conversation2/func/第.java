package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.静态引用;
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
        Integer 数字 =  Integer.parseInt(往后找指定词性的逻辑成分1.get(Cons.词语).toString());
        for(Document document : 静态引用.逻辑句子的成分集合){
            if(document.getObjectId(Cons._id).equals(往后找指定词性的逻辑成分.getObjectId(Cons._id))){
                document.put(Cons.序号词, 数字);
            }
        }
    }

}
