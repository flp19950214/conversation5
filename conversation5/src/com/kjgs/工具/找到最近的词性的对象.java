package com.kjgs.工具;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.枚举.Cons;

import java.util.ArrayList;
import java.util.List;

public class 找到最近的词性的对象 {

    public static JSONObject 向前找(JSONArray 句子词语集合, JSONObject 当前词语对象){
        return 向前找(句子词语集合, 当前词语对象,Cons.词性, Cons.句子结束词);
    }

    public static JSONObject 向前找(JSONArray 句子词语集合, JSONObject 当前词语对象, String 目标键, String 目标键值) {
        return 向前找(句子词语集合, 当前词语对象, 目标键, new ArrayList(){{add(目标键值);}});
    }
    public static JSONObject 向前找(JSONArray 句子词语集合, JSONObject 当前词语对象, String 目标键, List<String> 目标键值){
        Integer 当前对象下标 = 当前词语对象.getInteger(Cons.下标);
        if(当前对象下标 == null){
            return null;
        }
        JSONObject 结果对象=null;
        for (int i = 0; i <句子词语集合.size() ; i++) {
            JSONObject 临时对象 = 句子词语集合.getJSONObject(i);
            //不是句子结束词 跳过
            String 临时目标键值 = 临时对象.getString(目标键);
            // 不是需要的词性 跳过
            if(!目标键值.contains(临时目标键值)){
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
        return 向后找(句子词语集合, 当前词语对象,Cons.词性, Cons.句子结束词);
    }

    /**
     *
     * @param 句子词语集合
     * @param 当前词语对象
     * @param 目标键 用于对象属性的键
     * @param 目标键值  用于对象属性的键
     * @return
     */
    public static JSONObject 向后找(JSONArray 句子词语集合, JSONObject 当前词语对象, String 目标键, String 目标键值) {
        Integer 当前对象结束下标 = 当前词语对象.getInteger(Cons.结束下标);
        if(当前对象结束下标 == null){
            return null;
        }
        JSONObject 结果对象=null;
        for (int i = 0; i <句子词语集合.size() ; i++) {
            JSONObject 临时对象 = 句子词语集合.getJSONObject(i);
            //不是句子结束词 跳过
            String 临时目标键值 = 临时对象.getString(目标键);
            // 不是需要的词性 跳过
            if(!目标键值.equals(临时目标键值)){
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
