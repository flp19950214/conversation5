package com.kjgs.conversation2.func;

import com.kjgs.conversation.mysql.Impl逻辑;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class 是 extends FuncAbstract {
    public 是(){
        后面能否跟内置动作=false;
    }
    @Autowired
    Impl逻辑 impl逻辑;
    @PostConstruct
    public void init(){
    }
    @Override
    public void 功能() {
        Integer 那就的下标 = 静态引用.逻辑的那就对象.getInteger(Cons.下标);
        if(下标 < 那就的下标){
            判断句的包含动作();
        }
    }

    public void 判断句的包含动作(){
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Document 指定下标后面的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        if(指定下标前面的逻辑成分 == null || 指定下标后面的逻辑成分 == null){
            return;
        }
        String 前面的词语 = 指定下标前面的逻辑成分.getString(Cons.词语);
        if(指定下标前面的逻辑成分.containsKey(Cons.归属对象)){
            前面的词语 = Tool.最终的归属对象(指定下标前面的逻辑成分).getString(指定下标前面的逻辑成分.getString(Cons.词语));
        }
        if(前面的词语==null){
            Tool.赋值判断结果(逻辑成分, false);
            return;
        }
        //前面一个成分等于后面一个成分
        boolean result = 前面的词语.equals(指定下标后面的逻辑成分.getString(Cons.词语));
        Tool.赋值判断结果(逻辑成分, result);
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
        if(指定前面下标的逻辑成分.containsKey(Cons.归属对象)){
            String 属性 = 指定前面下标的逻辑成分.getString(Cons.词语);
            String 属性值 = 指定后面下标的逻辑成分.getString(Cons.词语);
            Document 对象 = 指定前面下标的逻辑成分.get(Cons.归属对象,Document.class);
            对象 = Tool.代词的最终指向(对象);
            对象.put(属性, 属性值);
            Tool.添加句子成分(对象);
        }else{
            String 属性值 = 指定后面下标的逻辑成分.getString(Cons.词语);
            指定前面下标的逻辑成分.put("是", 属性值);
        }
    }
}
