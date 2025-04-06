package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 输出 extends FuncAbstract {
    @Override
    public void 功能() {

    }

    @Override
    public void 判断结果是true时执行(){
        boolean 判断结果 = Tool.往前找判断结果(下标);
        if(!判断结果){
            return;
        }
        输出下一个成分();
    }

    public void 输出下一个成分(){
        Document 指定后面下标的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        if( 指定后面下标的逻辑成分 == null){
           return;
        }
        Document 属性对象 = Tool.往后找归属对象(下标, 指定后面下标的逻辑成分);
        String result ="";
        if(属性对象!=null){
            String 属性 = 属性对象.get(Cons.词语).toString();
            if(StringUtils.equals(属性, Cons.值)){
                result = 指定后面下标的逻辑成分.get(Cons.词语).toString();
            }else{
                result = 指定后面下标的逻辑成分.get(属性).toString();
            }
        }else{
            result = 指定后面下标的逻辑成分.get(Cons.词语).toString();
        }
        指定后面下标的逻辑成分.put(Cons.输出的句子, result);
        静态引用.输出内容 = 指定后面下标的逻辑成分;
    }


}
