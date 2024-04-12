package com.kjgs.功能.内置功能;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.功能.功能抽象;
import com.kjgs.工具.找到最近的词性的对象;
import com.kjgs.工具.获取句子中的功能词;
import com.kjgs.常用工具.替换句型;
import com.kjgs.枚举.Cons;

/**
 * 代表词：如果
 * 作用：只是修改其作用域内其他词的句型。 无陈述关系
 */
public class 假设词 extends 功能抽象 {
    @Override
    public void 功能初始化() {
        // {"词语":"如果","词性":"假设词"}
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Cons.对象, Cons.如果);
        jsonObject.put(Cons.词性, Cons.假设词);
        initMethod(jsonObject);
    }

    /**
     * 取判断条件: 当前词和判断词之间的内置动词，修改句型
     * 如果没有判断词 就修改全部句型 为 假设句
     **/
    @Override
    public void 陈述句() {
//        //找到大于当前词的判断词
        int 判断词下标 = Integer.MAX_VALUE;
        JSONObject 最近的词性的对象 = 找到最近的词性的对象.向后找(句子词语集合, 当前词语对象,Cons.词性, Cons.判断词);
        if(最近的词性的对象 != null && 最近的词性的对象.getInteger(Cons.下标) != null){
            判断词下标 = 最近的词性的对象.getInteger(Cons.下标);
        }
        替换句型.替换句型(句子词语集合,获取当前词语对象下标(), 判断词下标, Cons.假设句);
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
