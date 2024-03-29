package com.kjgs.工具;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 克隆对象，先转成json字符串，再反转
 */
public class 克隆JSON {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("1","1");
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject);
        System.out.println("原对象：");
        System.out.println(jsonObject);
        System.out.println(jsonArray);
        JSONObject jsonObject1 = copyJSONObject(jsonObject);
        jsonObject1.put("2","2");
        jsonArray.add(jsonObject1);
        System.out.println("复制并修改后：");
        System.out.println(jsonObject);
        System.out.println(jsonArray);
    }

    public static JSONObject copyJSONObject(JSONObject jsonObject){
        String tmp = JSON.toJSONString(jsonObject);
        return JSON.parseObject(tmp);
    }

    public static JSONArray copyJSONArray(JSONArray jsonArray){
        String tmp = JSON.toJSONString(jsonArray);
        return JSON.parseArray(tmp);
    }
}
