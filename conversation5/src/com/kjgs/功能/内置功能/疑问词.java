package com.kjgs.功能.内置功能;

import com.alibaba.fastjson.JSONObject;
import com.kjgs.功能.功能抽象;
import com.kjgs.工具.找到最近的词性的对象;
import com.kjgs.常用工具.替换句型;
import com.kjgs.枚举.Cons;


/**
 * 将句子的其他动作 句型改为疑问句
 */
public class 疑问词 extends 功能抽象 {
    @Override
    public void 功能初始化() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Cons.对象, Cons.什么);
        jsonObject.put(Cons.词性, Cons.疑问词);
        initMethod(jsonObject);
    }

    @Override
    public void 陈述句() {
        // 修改当前疑问词作用域内的所有动作的句型 改为 疑问句
        // 怎么获取疑问词的作用域 向前或向后，找到最近的词性是句子结束词的对象，在这个范围内的都改
        JSONObject 前面最近的结束词 = 找到最近的词性的对象.向前找(句子词语集合, 当前词语对象);
        JSONObject 后面最近的结束词 = 找到最近的词性的对象.向后找(句子词语集合, 当前词语对象);
        if(前面最近的结束词==null && 后面最近的结束词 == null){
            替换句型.替换句型(句子词语集合, Cons.疑问句);
        }else{

            if(前面最近的结束词==null){
                替换句型.替换句型(句子词语集合,null, 后面最近的结束词.getInteger(Cons.下标), Cons.疑问句);
            }
            if(后面最近的结束词==null){
                替换句型.替换句型(句子词语集合, 后面最近的结束词.getInteger(Cons.下标),null, Cons.疑问句);
            }
        }
    }

    @Override
    public void 疑问句() {

    }

    @Override
    public void 否定句() {

    }

    @Override
    public void 假设句() {

    }

    @Override
    public void 假设陈述句() {

    }
}
