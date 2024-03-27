package com.kjgs.工具;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.枚举.Cons;

public class 获取操作对象 {

    public static JSONObject 操作对象(JSONArray 句子词语集合, JSONObject 当前词语对象){
        int 结束下标 = 当前词语对象.getInteger(Cons.结束下标);

        JSONObject 结果对象 = null;
        for(int i=0;i<句子词语集合.size();i++){
            JSONObject 临时对象 = 句子词语集合.getJSONObject(i);
            int 临时开始下标 = 临时对象.getInteger(Cons.下标);
            int 临时结束下标 = 临时对象.getInteger(Cons.结束下标);
            boolean 临时是否是对象 = 临时对象.getBoolean(Cons.是否是对象);

            //大于当前对象 跳过
            if(临时开始下标 > 结束下标){
                continue;
            }
            //不能作为对象 跳过
            if(!临时是否是对象){
                continue;
            }
            if(结果对象 == null){
                结果对象 = 临时对象;
                continue;
            }
            int 结果开始下标 = 结果对象.getInteger(Cons.下标);
            int 结果结束下标 = 结果对象.getInteger(Cons.结束下标);

            //临时下标大于结果下标
            if(结果开始下标> 临时开始下标){
                结果对象 = 临时对象;
                continue;
            }
            //临时下标==结果下标
            if(结果开始下标 == 临时开始下标 && 结果结束下标 < 临时结束下标){
                结果对象 = 临时对象;
                continue;
            }
        }
        return 结果对象;
    }
}
