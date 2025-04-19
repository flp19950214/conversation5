package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 替换为 extends FuncAbstract {
    @Override
    public void 功能() {

    }

    @Override
    public void 判断结果是true时执行(){
        boolean 判断结果 = Tool.往前找判断结果(下标);
        if(!判断结果){
            return;
        }
        把什么中的什么替换为什么();
        把什么替换为什么();
    }

    public void 把什么替换为什么(){
        Document 指定前面下标的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Document 指定后面下标的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        if(指定前面下标的逻辑成分 == null || 指定后面下标的逻辑成分 == null){
            return;
        }
        String 被替换词 = 指定前面下标的逻辑成分.getString(Cons.词语);
        String 替换词 = 指定后面下标的逻辑成分.getString(Cons.词语);
        String replace = StringUtils.replace(句子, 被替换词, 替换词);
        指定前面下标的逻辑成分.put(Cons.词语, 替换词);
        指定前面下标的逻辑成分.put(Cons.原词语, 被替换词);
    }


    public void 把什么中的什么替换为什么(){
        Document 指定前面下标的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Document 指定后面下标的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        Document 中的 = Tool.指定下标前面的逻辑成分(下标,Cons.中的);
        if(指定前面下标的逻辑成分 == null || 指定后面下标的逻辑成分 == null
                || 中的 == null){
            return;
        }
        Document 指定前前面下标的逻辑成分 = Tool.指定下标前面的逻辑成分(中的.getInteger(Cons.下标));
        if(指定前前面下标的逻辑成分 == null){
            return;
        }
        String 句子 = 指定前前面下标的逻辑成分.getString(Cons.词语);
        String 被替换词 = 指定前面下标的逻辑成分.getString(Cons.词语);
        String 替换词 = 指定后面下标的逻辑成分.getString(Cons.词语);
        String replace = StringUtils.replace(句子, 被替换词, 替换词);
        指定前前面下标的逻辑成分.put(Cons.词语, replace);
        if(!指定前前面下标的逻辑成分.containsKey(Cons.原词语)){
            指定前前面下标的逻辑成分.put(Cons.原词语, 句子);
         }
    }


}
