package com.kjgs.常用工具;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.枚举.Cons;

public class 添加属性 {

    public static void 属性(JSONArray 句子词语集合, Integer 开始下标, Integer 结束下标, String 属性, Object 属性值) {
        for (int i = 0; i < 句子词语集合.size(); i++) {
            JSONObject 临时对象 = 句子词语集合.getJSONObject(i);
            Integer 临时对象下标 = 临时对象.getInteger(Cons.下标);
            if (临时对象下标 == null) {
                continue;
            }
            // 不在修改范围内 跳过
            if (开始下标 != null && 临时对象下标 < 开始下标) {
                continue;
            }
            if (结束下标 != null && 临时对象下标 > 结束下标) {
                continue;
            }
            // 修改句型
            临时对象.put(属性, 属性值);
        }
    }
}
