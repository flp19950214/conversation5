package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 为 extends FuncAbstract {
    public 为(){
        后面能否跟内置动作=false;
    }

    @Override
    public void 功能() {
        判断句的包含动作();
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
        String 属性 = null;
        if(指定前面下标的逻辑成分.containsKey(Cons.归属对象)){
            属性 = 指定前面下标的逻辑成分.getString(Cons.词语);
            Document 对象 = 指定前面下标的逻辑成分.get(Cons.归属对象,Document.class);
            对象 = Tool.代词的最终指向(对象);
            if(Tool.判断对象是否是句子成分(指定后面下标的逻辑成分)){
                Document 属性对象 = Tool.往后找归属对象(下标, 指定后面下标的逻辑成分);
                if(属性对象==null){
                    对象.put(属性, 指定后面下标的逻辑成分);
                }else{
                    对象.put(属性, 指定后面下标的逻辑成分.get(属性对象.getString(Cons.词语)));
                }
            }else{
                String 属性值 = 指定后面下标的逻辑成分.getString(Cons.词语);
                对象.put(属性, 属性值);
            }
            Tool.添加更新逻辑内容(对象, 属性,逻辑句子);
            Tool.添加句子成分(对象);
        }else{
            String 属性值 = 指定后面下标的逻辑成分.getString(Cons.词语);
            属性=Cons.指向;
            指定前面下标的逻辑成分.put(Cons.指向, Tool.生成动作结果指向对象(属性值));
        }
        Tool.添加更新逻辑内容(指定前面下标的逻辑成分, 属性,逻辑句子);
    }


    public void 判断句的包含动作(){
        // 是判断句
        Object 句型 = Tool.往前找指定的键值(下标, Cons.句型);
        if(句型 == null || !StringUtils.equals(Cons.假设句, 句型.toString())){
            return;
        }
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Document 指定下标后面的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        if(指定下标前面的逻辑成分 == null || 指定下标后面的逻辑成分 == null){
            return;
        }
        //前面也是是 当前词不作为动词处理
        if(StringUtils.equals(指定下标前面的逻辑成分.getString(Cons.词语), "为")){
            return;
        }
        //前面一个成分等于后面一个成分
        boolean result = 指定下标前面的逻辑成分.getString(Cons.词语).equals(指定下标后面的逻辑成分.getString(Cons.词语));
        Tool.赋值判断结果(逻辑成分, result);
    }
}
