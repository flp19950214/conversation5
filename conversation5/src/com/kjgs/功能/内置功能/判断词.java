package com.kjgs.功能.内置功能;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.功能.功能抽象;
import com.kjgs.工具.找到最近的词性的对象;
import com.kjgs.工具.获取句子中的功能词;
import com.kjgs.常用工具.替换句型;
import com.kjgs.常用工具.添加属性;
import com.kjgs.枚举.Cons;

import java.util.ArrayList;


/**
 * 代表词：如果
 * 作用：只是修改其作用域内其他词的句型。 无陈述关系
 */
public class 判断词 extends 功能抽象 {
    @Override
    public void 功能初始化() {
        // {"词语":"那么","词性":"判断词"}
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Cons.对象, Cons.那么);
        jsonObject.put(Cons.词性, Cons.判断词);
        initMethod(jsonObject);
    }

    /**
     * 找到假设条件处理结果，即true or false。
     * true判断词后面的动作 不执行
     * false则反向判断词后面的动作 不执行
     **/
    @Override
    public void 陈述句() {
        // 找到大于当前词的判断词
        JSONObject 最近的判断结果对象 = 找到最近的词性的对象.向前找(句子词语集合, 当前词语对象,
                Cons.判断结果, new ArrayList(){{add(Boolean.TRUE);add(Boolean.FALSE);}});
        if(最近的判断结果对象 != null
                && Boolean.FALSE.equals(最近的判断结果对象.getString(Cons.判断结果))){
            int 反向判断词下标 = Integer.MAX_VALUE;
            JSONObject 最近的反向判断词对象 = 找到最近的词性的对象. 向后找(句子词语集合, 当前词语对象,Cons.词性, Cons.反向判断词);
            if(最近的反向判断词对象 != null && 最近的反向判断词对象.getInteger(Cons.下标) != null){
                反向判断词下标 = 最近的反向判断词对象.getInteger(Cons.下标);
            }
            添加属性.属性(句子词语集合, 获取当前词语对象下标(), 反向判断词下标, Cons.是否执行动作, false);
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
