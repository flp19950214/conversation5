package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 作为 extends FuncAbstract {

    public 作为(){
        后面能否跟内置动作=false;
    }

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
        Object 属性值 = 指定前面下标的逻辑成分.getString(Cons.词语);
        if(指定前面下标的逻辑成分.containsKey(Cons.归属对象)){
            属性值 = Tool.最终的归属对象(指定前面下标的逻辑成分).get(属性值);
        }
        Document 属性对象 = Tool.往后找归属对象(下标, 指定后面下标的逻辑成分);
        if(属性对象==null){
            return;
        }
        String 属性 = 属性对象.getString(Cons.词语);
        Document 对象 = 指定后面下标的逻辑成分;
        对象.put(属性, 属性值);
//        Tool.添加句子成分(对象);
    }


}
