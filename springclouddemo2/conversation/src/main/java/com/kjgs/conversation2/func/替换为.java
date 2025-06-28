package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 替换为 extends FuncAbstract {
    public 替换为(){
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
        把什么替换为什么();
    }

    public void 把什么替换为什么(){
        Document 指定前面下标的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Document 指定后面下标的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        if(指定前面下标的逻辑成分 == null || 指定后面下标的逻辑成分 == null){
            return;
        }
        if(指定前面下标的逻辑成分.containsKey(Cons.归属对象)
                || 指定后面下标的逻辑成分.containsKey(Cons.归属对象)){
            return;
        }
        if(指定前面下标的逻辑成分.containsKey(Cons.原词语)
        && !StringUtils.equals(指定前面下标的逻辑成分.getString(Cons.原词语),
                指定前面下标的逻辑成分.getString(Cons.词语))){
            return;
        }
        指定前面下标的逻辑成分.put(Cons.原词语, 指定前面下标的逻辑成分.get(Cons.词语));
        指定前面下标的逻辑成分.put(Cons.词语, 指定后面下标的逻辑成分.get(Cons.词语));
        Tool.添加更新逻辑内容(指定前面下标的逻辑成分, Cons.词语,逻辑句子);
    }

//    public void 把什么中的什么替换为什么(){
//        Document 指定前面下标的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
//        Document 指定后面下标的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
//
//        if(指定前面下标的逻辑成分 == null || 指定后面下标的逻辑成分 == null
//                || !指定前面下标的逻辑成分.containsKey(Cons.归属对象)){
//            return;
//        }
//        //一个是替换对象的属性值，没有替换对象的词语 的功能
//        //这个是替换对象的属性
//        Document 对象 = 指定前面下标的逻辑成分.get(Cons.归属对象,Document.class);
//        String 属性 = 指定前面下标的逻辑成分.getString(Cons.词语);
//        Object 属性值 = 指定后面下标的逻辑成分.get(Cons.词语);
//        对象.put(属性, 属性值);
//    }


}
