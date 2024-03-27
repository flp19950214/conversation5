package com.kjgs.功能.内置功能;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.功能.功能抽象;
import com.kjgs.工具.获取句子中的功能词;
import com.kjgs.枚举.Cons;


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
     * true将判断词后面的内容句型改为假设正向结果陈述句
     * false将判断词后面的内容句型改为假设负向结果陈述句
     **/
    @Override
    public void 陈述句() {
//        //找到大于当前词的判断词
        int 反向判断词下标 = Integer.MAX_VALUE;
        for (int i = 0; i < 句子词语集合.size(); i++) {
            JSONObject 临时词语对象 = 句子词语集合.getJSONObject(i);
            String 临时词性 = 临时词语对象.getString(Cons.词性);
            int 临时下标 = 临时词语对象.getInteger(Cons.下标);
            if (临时下标 <= 获取当前词语对象下标()) {
                continue;
            }
            if (!临时词性.equals(Cons.反向判断词)) {
                continue;
            }
            反向判断词下标 = 临时下标;
        }
        String 修改目标句型 = Cons.假设负向结果陈述句;
        for (int i = 0; i < 句子词语集合.size(); i++) {
            JSONObject 临时词语对象 = 句子词语集合.getJSONObject(i);
            String 临时判断结果 = 临时词语对象.getString(Cons.判断结果);
            if (临时判断结果 == null) {
                continue;
            }
            int 临时下标 = 临时词语对象.getInteger(Cons.下标);
            if (临时下标 >= 获取当前词语对象下标()) {
                continue;
            }
            if (Boolean.TRUE.toString().equals(临时判断结果)) {
                修改目标句型 = Cons.假设正向结果陈述句;
            }
        }

        //修改判断词和反向判断词之间的动作词句型为假设正向结果陈述句或假设负向结果陈述句
        JSONArray 需包含的词性 = 获取句子中的功能词.句子中的功能词(句子词语集合);
        for (int i = 0; i < 句子词语集合.size(); i++) {
            JSONObject 临时词语对象 = 句子词语集合.getJSONObject(i);
            String 临时词性 = 临时词语对象.getString(Cons.词性);
            int 临时下标 = 临时词语对象.getInteger(Cons.下标);
            if (临时下标 <= 获取当前词语对象下标()) {
                continue;
            }
            if (临时下标 >= 反向判断词下标) {
                continue;
            }
            //不是指定词性 跳过
            if (!需包含的词性.contains(临时词性)) {
                continue;
            }
            临时词语对象.put(Cons.句型, 修改目标句型);
        }
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
