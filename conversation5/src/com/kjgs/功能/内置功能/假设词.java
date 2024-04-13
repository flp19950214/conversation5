package com.kjgs.功能.内置功能;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.功能.功能抽象;
import com.kjgs.工具.找到最近的词性的对象;
import com.kjgs.工具.获取句子中的功能词;
import com.kjgs.常用工具.截取字符串;
import com.kjgs.常用工具.拼接字符串;
import com.kjgs.常用工具.替换句型;
import com.kjgs.常用工具.添加集合;
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
     *
     * 添加判断条件：当前词和判断词之间的内容
     **/
    @Override
    public void 陈述句() {
        //找到大于当前词的判断词
        int 判断词下标 = Integer.MAX_VALUE;
        JSONObject 最近的词性的对象 = 找到最近的词性的对象.向后找(句子词语集合, 当前词语对象,Cons.词性, Cons.判断词);
        if(最近的词性的对象 != null && 最近的词性的对象.getInteger(Cons.下标) != null){
            判断词下标 = 最近的词性的对象.getInteger(Cons.下标);
        }
        替换句型.替换句型(句子词语集合,获取当前词语对象下标(), 判断词下标, Cons.假设句);

        //添加判断条件：当前词和判断词之间的内容
        String 截取的判断条件 = 截取字符串.截取结束下标到开始下标(获取当前词语的上级对象(), 获取当前词语对象结束下标(), 判断词下标);
        JSONObject 新对象 = new JSONObject();
        新对象.put(Cons.上级对象, 获取当前词语的上级对象());
        新对象.put(Cons.对象, 截取的判断条件);
        新对象.put(Cons.在上级对象中的成分, Cons.判断条件);
        新对象.put(Cons.下标, 获取当前词语对象结束下标());
        新对象.put(Cons.结束下标, 判断词下标);
        句子词语集合.add(新对象);

        //记录动作内容
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        当前词语对象.put(Cons.动作句型,methodName);
        String 动作结果1 = 拼接字符串.拼接(Cons.修改,Cons.下标,获取当前词语对象下标(),
                Cons.和,判断词下标,Cons.之间,Cons.的对象,Cons.句型,Cons.是,Cons.假设句);
        String 动作结果2 = 拼接字符串.拼接(Cons.新增,Cons.判断条件,截取的判断条件);
        当前词语对象.put(Cons.动作结果, 添加集合.添加集合类型属性元素(当前词语对象, Cons.动作结果, 动作结果1));
        当前词语对象.put(Cons.动作结果, 添加集合.添加集合类型属性元素(当前词语对象, Cons.动作结果, 动作结果2));
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
