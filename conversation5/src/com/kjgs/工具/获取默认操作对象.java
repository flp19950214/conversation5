package com.kjgs.工具;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;

/**
 * 取当前功能对象和下一个功能对象之间的词
 */
public class 获取默认操作对象 {
    public static JSONObject 默认操作对象( JSONArray 句子词语集合, JSONObject 当前词语对象){
        JSONObject 默认操作对象 = new JSONObject();
        String 上级对象 = 当前词语对象.getString(Cons.上级对象);
        JSONObject 下一个功能对象 =下一个动作对象(句子词语集合, 当前词语对象);
        Integer 当前对象的结束下标 = 当前词语对象.getInteger(Cons.结束下标);
        if(当前对象的结束下标 == null){
            return null;
        }
        if(下一个功能对象 ==  null){
            默认操作对象.put(Cons.对象, 上级对象.substring(当前对象的结束下标));
            默认操作对象.put(Cons.下标, 当前对象的结束下标);
            默认操作对象.put(Cons.结束下标, 默认操作对象.getString(Cons.对象).length());
        }else{
            Integer 下一个功能的下标 = 下一个功能对象.getInteger(Cons.下标);
            if(下一个功能的下标 == null){
                return null;
            }
            String 截取的对象 = 上级对象.substring(当前对象的结束下标,下一个功能的下标);
            if(StringUtils.isEmpty(截取的对象)){
                return null;
            }
            默认操作对象.put(Cons.对象, 上级对象.substring(当前对象的结束下标,下一个功能的下标));
            默认操作对象.put(Cons.下标, 当前对象的结束下标);
            默认操作对象.put(Cons.结束下标, 当前对象的结束下标+默认操作对象.getString(Cons.对象).length());
        }
        默认操作对象.put(Cons.是否是对象, true);
        默认操作对象.put(Cons.是否是新对象, Boolean.TRUE);
        默认操作对象.put(Cons.上级对象, 上级对象);
        句子词语集合.add(默认操作对象);
        return 默认操作对象;
    }

    //即获取下一个动作对象
    public static JSONObject 下一个动作对象(JSONArray 句子词语集合, JSONObject 当前词语对象) {
        Integer 结束下标 = 当前词语对象.getInteger(Cons.结束下标);
        if(结束下标 == null){
            return null;
        }
        JSONObject 结果对象 = null;
        for(int i=0;i<句子词语集合.size();i++){
            JSONObject 临时对象 = 句子词语集合.getJSONObject(i);
            Integer 临时开始下标 = 临时对象.getInteger(Cons.下标);
            Integer 临时结束下标 = 临时对象.getInteger(Cons.结束下标);
            if(临时开始下标 == null || 临时结束下标 == null){
                continue;
            }
            String 临时结束词性 = 临时对象.getString(Cons.词性);
            if(结束下标 == null){
                return null;
            }
            //大于当前对象 跳过
            if(临时开始下标 < 结束下标){
                continue;
            }
            //不是内置功能词 跳过
            if (!获取内置功能名.内置功能类名.contains(临时结束词性)) {
                break;
            }
            if(结果对象 == null){
                结果对象 = 临时对象;
                continue;
            }
            Integer 结果开始下标 = 结果对象.getInteger(Cons.下标);
            Integer 结果结束下标 = 结果对象.getInteger(Cons.结束下标);
            if(结果开始下标 == null || 结果结束下标 == null){
                continue;
            }
            //临时下标大于结果下标
            if(临时开始下标 < 结果开始下标){
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
