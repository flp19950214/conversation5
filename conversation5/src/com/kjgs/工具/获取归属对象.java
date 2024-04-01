package com.kjgs.工具;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.枚举.Cons;

public class 获取归属对象 {

    public static JSONObject 归属或默认对象(JSONArray 句子词语集合, JSONObject 当前词语对象){
        JSONObject 归属对象 = 归属对象(句子词语集合, 当前词语对象);
        if(归属对象 != null){
            return 归属对象;
        }
        return 获取默认归属对象.默认归属对象(句子词语集合,当前词语对象);
    }
    public static JSONObject 归属对象(JSONArray 句子词语集合, JSONObject 当前词语对象){
        Integer 开始下标 = 当前词语对象.getInteger(Cons.下标);
        if(开始下标 == null){
            return null;
        }
        JSONObject 结果对象 = null;
        for(int i=0;i<句子词语集合.size();i++){
            JSONObject 临时对象 = 句子词语集合.getJSONObject(i);
            Integer 临时开始下标 = 临时对象.getInteger(Cons.下标);
            Integer 临时结束下标 = 临时对象.getInteger(Cons.结束下标);
            Boolean 临时是否是对象 = 临时对象.getBoolean(Cons.是否是对象);
            if(临时开始下标 == null || 临时结束下标 == null || 临时是否是对象 == null){
                continue;
            }
            //大于当前对象 跳过
            if(临时开始下标 > 开始下标){
                continue;
            }
            //不能作为对象 跳过
            if(!临时是否是对象){
                continue;
            }
            //词语结尾超过当前词 跳过
            if(开始下标 < 临时结束下标){
                continue;
            }
            if(结果对象 == null){
                结果对象 = 临时对象;
                continue;
            }
            Integer 结果开始下标 = 结果对象.getInteger(Cons.下标);
            Integer 结果结束下标 = 结果对象.getInteger(Cons.结束下标);
            if(结果开始下标 == null || 结果开始下标 == null){
                continue;
            }
            if(临时结束下标 > 结果结束下标){
                结果对象 = 临时对象;
                continue;
            }

            //临时下标==结果下标
            if(结果结束下标 == 临时结束下标 && 结果开始下标 > 临时开始下标){
                结果对象 = 临时对象;
                continue;
            }
        }
        return 结果对象;
    }
}
