package com.kjgs.工具;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.常用工具.获取词语在句子中的所有位置;
import com.kjgs.枚举.Cons;

import java.util.List;

public class 补充对象下标 {
    public static void 补充对象下标(JSONArray 句子词语集合){
        JSONArray 增加的词语集合 = new JSONArray();
        for (int i = 0; i < 句子词语集合.size(); i++) {
            JSONObject 单个对象 = 句子词语集合.getJSONObject(i);
            String 上级对象 = 单个对象.getString(Cons.上级对象);
            String 对象 = 获取对象默认值.对象值(单个对象);
            int 对象长度 = 对象.length();
            List<Integer> 词语出现所有下标 = 获取词语在句子中的所有位置.词语在句子中的所有位置(上级对象, 对象);
            if(词语出现所有下标.size() == 1){
                单个对象.put(Cons.下标, 词语出现所有下标.get(0));
                单个对象.put(Cons.结束下标, 词语出现所有下标.get(0)+对象长度);
            }
            if(词语出现所有下标.size() > 1){
                for (int j = 1; j <词语出现所有下标.size() ; j++) {
                    JSONObject 增加的对象 = JSONObject.parseObject(JSON.toJSONString(单个对象));
                    单个对象.put(Cons.下标, 词语出现所有下标.get(j));
                    单个对象.put(Cons.结束下标, 词语出现所有下标.get(j)+对象长度);
                    增加的词语集合.add(增加的对象);
                }
            }
        }
        句子词语集合.addAll(增加的词语集合);
    }
}
