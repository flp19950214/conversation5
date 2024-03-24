package com.kjgs.功能.内置功能;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.功能.功能抽象;
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
//        int 判断词下标 = Integer.MAX_VALUE;
//        for(int i=0;i<句子词语集合.size();i++){
//            JSONObject 临时词语对象 = 句子词语集合.getJSONObject(i);
//            JSONArray 临时词性 = 临时词语对象.getJSONArray(Cons.词性);
//            int 临时下标 = 临时词语对象.getInteger(Cons.开始下标);
//            if(临时下标 <= 获取当前词语对象下标()){
//                continue;
//            }
//            if(!临时词性.contains(词性种类.判断词)){
//                continue;
//            }
//            判断词下标 = 临时下标;
//        }
//
//        //修改假设词和判断词之间的动作词句型为假设句
//        JSONArray 需包含的词性 = 获取句子中的功能词.句子中的功能词(句子词语集合);
//        for(int i=0;i<句子词语集合.size();i++){
//            JSONObject 临时词语对象 = 句子词语集合.getJSONObject(i);
//            JSONArray 临时词性 = 临时词语对象.getJSONArray(Cons.词性);
//            int 临时下标 = 临时词语对象.getInteger(Cons.开始下标);
//            if(临时下标 <= 获取当前词语对象下标()){
//                continue;
//            }
//            if(临时下标 >= 判断词下标){
//                continue;
//            }
//            //不是指定词性 跳过
//            if(!判断集合是否互相包含.判断集合是否互相包含(需包含的词性, 临时词性)){
//                continue;
//            }
//            临时词语对象.put(Cons.句型, 句型种类.假设句);
//        }
    }

    @Override
    public void 疑问句() {

    }

    @Override
    public void 假设负向结果陈述句() {

    }

    @Override
    public void 假设句() {

    }

    @Override
    public void 假设正向结果陈述句() {

    }
}
