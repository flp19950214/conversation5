package com.kjgs.工具;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.枚举.Cons;
import com.sun.org.apache.regexp.internal.RE;

public class 环境信息 {

    /**
     * 每个句子都添加一个属于自己的环境信息
     * @param input
     * @return
     */
    public static JSONArray 默认环境信息(String input){
        JSONObject 环境对象1 = new JSONObject();
        环境对象1.put(Cons.当前人,获取当前人信息());
        环境对象1.put(Cons.指向,Cons.小燕);

        JSONArray result = new JSONArray();
        result.add(环境对象1);
        return result;
    }

    public static JSONObject 默认环境信息(){
        JSONObject result = new JSONObject();
        result.put(Cons.当前人,获取当前人信息());
        return result;
    }

    public static JSONObject 获取当前人信息(){
        JSONObject result = new JSONObject();
        result.put(Cons.对象,"小燕");
        return result;
    }
}
