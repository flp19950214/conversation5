package com.kjgs.常用工具;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class 添加集合 {
    public static JSONArray 添加集合类型属性元素(JSONObject 对象, String 属性, String 属性值){
        JSONArray 属性值集合;
        try{
            属性值集合 = 对象.getJSONArray(属性);
            属性值集合.add(属性值);
        }catch (Exception e){
            属性值集合 = new JSONArray();
            属性值集合.add(属性值);
        }
        return 属性值集合;
    }
}
