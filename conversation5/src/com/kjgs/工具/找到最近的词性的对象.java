package com.kjgs.工具;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.枚举.Cons;

public class 找到最近的词性的对象 {

    public static JSONObject 向前找(JSONArray 句子词语集合, JSONObject 当前词语对象){
        Integer 当前对象下标 = 当前词语对象.getInteger(Cons.下标);
        if(当前对象下标 == null){
            return null;
        }
        JSONObject 结果对象=null;
        for (int i = 0; i <句子词语集合.size() ; i++) {
            JSONObject 临时对象 = 句子词语集合.getJSONObject(i);
            //不是句子结束词 跳过
            String 词性 = 临时对象.getString(Cons.词性);
            if(!Cons.句子结束词.equals(词性)){
                continue;
            }
            //结束下标大于等于当前词 跳过
            Integer 临时对象结束下标 =  临时对象.getInteger(Cons.结束下标);
            if(临时对象结束下标 == null){
                continue;
            }
            if(临时对象结束下标 >= 当前对象下标){
                continue;
            }
            if(结果对象 == null){
                结果对象 = 临时对象;
            }else{
                Integer 结果对象结束下标 =  结果对象.getInteger(Cons.结束下标);
                if(结果对象结束下标 == null){
                    continue;
                }
                //找最近，小于等于结果下标 就跳过
                if(临时对象结束下标 <= 结果对象结束下标){
                    continue;
                }else{
                    结果对象 = 临时对象;
                }
            }
        }
        return 结果对象;
    }

    public static JSONObject 向后找(JSONArray 句子词语集合, JSONObject 当前词语对象){
        Integer 当前对象结束下标 = 当前词语对象.getInteger(Cons.结束下标);
        if(当前对象结束下标 == null){
            return null;
        }
        JSONObject 结果对象=null;
        for (int i = 0; i <句子词语集合.size() ; i++) {
            JSONObject 临时对象 = 句子词语集合.getJSONObject(i);
            //不是句子结束词 跳过
            String 词性 = 临时对象.getString(Cons.词性);
            if(!Cons.句子结束词.equals(词性)){
                continue;
            }
            //下标小于等当前词下标 跳过
            Integer 临时对象下标 =  临时对象.getInteger(Cons.下标);
            if(临时对象下标 == null){
                continue;
            }
            if(临时对象下标 <= 当前对象结束下标){
                continue;
            }
            if(结果对象 == null){
                结果对象 = 临时对象;
            }else{
                Integer 结果对象下标 =  结果对象.getInteger(Cons.下标);
                if(结果对象下标 == null){
                    continue;
                }
                //找最近，小于等于结果下标 就跳过
                if(临时对象下标 >= 结果对象下标){
                    continue;
                }else{
                    结果对象 = 临时对象;
                }
            }
        }
        return 结果对象;
    }
}
