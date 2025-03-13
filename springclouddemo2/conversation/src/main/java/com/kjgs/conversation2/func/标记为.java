package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 标记为 extends FuncAbstract {
    @Override
    public void 功能() {

    }

    @Override
    public void 判断结果是true时执行(){
        boolean 判断结果 = Tool.往前找判断结果(下标);
        if(!判断结果){
            return;
        }
        标记对象属性值();
    }

    public void 标记对象属性值(){
        Document 指定前面下标的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Document 指定后面下标的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        if(指定前面下标的逻辑成分 == null || 指定后面下标的逻辑成分 == null){
           return;
        }
        if(!指定前面下标的逻辑成分.containsKey(Cons.归属对象)){
            return;
        }
        String 属性 = 指定前面下标的逻辑成分.getString(Cons.词语);
        String 属性值 = 指定后面下标的逻辑成分.getString(Cons.词语);
        Document 对象 = 指定前面下标的逻辑成分.get(Cons.归属对象,Document.class);
        对象.put(属性, 属性值);
    }


}
