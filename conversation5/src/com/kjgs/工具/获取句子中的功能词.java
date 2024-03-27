package com.kjgs.工具;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.枚举.Cons;

public class 获取句子中的功能词 {

    public static JSONArray 句子中的功能词(JSONArray 句子词语集合) {
        JSONArray result = new JSONArray();
        for (int i = 0; i < 句子词语集合.size(); i++) {
            JSONObject 当前词语对象 = 句子词语集合.getJSONObject(i);
            String 词语词性 = 当前词语对象.getString(Cons.词性);
            // 循环执行每个可能的词性
            if (获取内置功能名.内置功能类名.contains(词语词性)) {
                String 当前词语 = 当前词语对象.getString(Cons.词语);
                result.add(当前词语);
                break;
            }
        }
        return result;
    }
}
