package com.kjgs.工具;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.枚举.Cons;

/**
 * 取当前功能对象和前一个功能对象之间的词
 */
public class 获取默认归属对象 {

    public static JSONObject 默认归属对象(JSONArray 句子词语集合, JSONObject 当前词语对象) {
        JSONObject 默认归属对象 = new JSONObject();
        String 上级对象 = 当前词语对象.getString(Cons.上级对象);
        JSONObject 前一个功能对象 =上一个动作对象(句子词语集合, 当前词语对象);
        Integer 当前对象的下标 = 当前词语对象.getInteger(Cons.下标);
        if(当前对象的下标 == null){
            return null;
        }
        if(前一个功能对象 ==  null){
            默认归属对象.put(Cons.对象, 上级对象.substring(0,当前对象的下标));
            默认归属对象.put(Cons.下标, 0);
            默认归属对象.put(Cons.结束下标, 默认归属对象.getString(Cons.对象).length());
        }else{
            Integer 上一个对象的结束下标 = 前一个功能对象.getInteger(Cons.结束下标);
            if(上一个对象的结束下标 == null){
                return null;
            }
            默认归属对象.put(Cons.对象, 上级对象.substring(上一个对象的结束下标,当前对象的下标));
            默认归属对象.put(Cons.下标, 上一个对象的结束下标);
            默认归属对象.put(Cons.结束下标, 上一个对象的结束下标+默认归属对象.getString(Cons.对象).length());
        }
        默认归属对象.put(Cons.是否是对象, true);
        默认归属对象.put(Cons.是否是新对象, Boolean.TRUE);
        默认归属对象.put(Cons.上级对象, 上级对象);
        句子词语集合.add(默认归属对象);
        return 默认归属对象;
    }

    //即获取上一个动作对象
    public static JSONObject 上一个动作对象(JSONArray 句子词语集合, JSONObject 当前词语对象) {
        Integer 开始下标 = 当前词语对象.getInteger(Cons.下标);
        if(开始下标 == null){
            return null;
        }
        JSONObject 结果对象 = null;
        for (int i = 0; i < 句子词语集合.size(); i++) {
            JSONObject 临时对象 = 句子词语集合.getJSONObject(i);
            Integer 临时开始下标 = 临时对象.getInteger(Cons.下标);
            Integer 临时结束下标 = 临时对象.getInteger(Cons.结束下标);
            if(临时开始下标==null || 临时结束下标 == null){
                continue;
            }
            String 临时结束词性 = 临时对象.getString(Cons.词性);

            //大于当前对象 跳过
            if (临时开始下标 > 开始下标) {
                continue;
            }
            //不是内置功能词 跳过
            if (!获取内置功能名.内置功能类名.contains(临时结束词性)) {
                break;
            }
            //词语结尾超过当前词 跳过
            if (开始下标 < 临时结束下标) {
                continue;
            }
            if (结果对象 == null) {
                结果对象 = 临时对象;
                continue;
            }
            Integer 结果开始下标 = 结果对象.getInteger(Cons.下标);
            Integer 结果结束下标 = 结果对象.getInteger(Cons.结束下标);
            if(结果开始下标==null || 结果结束下标 ==null){
                continue;
            }
            if (临时结束下标 > 结果结束下标) {
                结果对象 = 临时对象;
                continue;
            }

            //临时下标==结果下标
            if (结果结束下标 == 临时结束下标 && 结果开始下标 > 临时开始下标) {
                结果对象 = 临时对象;
                continue;
            }
        }
        return 结果对象;
    }


}
