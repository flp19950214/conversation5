package com.kjgs.工具;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.CollectionUtils;

public class 根据属性筛选集合 {
    //返回对象
    public static JSONArray 单个属性筛选集合不为空的(JSONArray jsonArray, String arg1){
        JSONArray result =  new JSONArray();
        for (int i = 0; i <jsonArray.size() ; i++) {
            JSONObject 单个对象 = jsonArray.getJSONObject(i);
            String 归属未知属性值 = 单个对象.getString(arg1);
            if(归属未知属性值 != null){
                result.add(单个对象);
            }
        }
        return result;
    }

    /**
     * 返回属性值
     * @param jsonArray
     * @param arg1
     * @return
     */
    public static JSONArray 单个属性筛选集合不为空的属性值(JSONArray jsonArray, String arg1){
        JSONArray result =  new JSONArray();
        for (int i = 0; i <jsonArray.size() ; i++) {
            JSONObject 单个对象 = jsonArray.getJSONObject(i);
            String 归属未知属性值 = 单个对象.getString(arg1);
            if(归属未知属性值 != null){
                result.add(归属未知属性值);
            }
        }
        return result;
    }

    /**
     * 返回属性值
     * @param jsonArray
     * @param arg1
     * @return
     */
    public static Object 单个属性筛选集合不为空的第一个属性值(JSONArray jsonArray, String arg1){
        JSONArray 单个属性筛选集合不为空的属性值 = 单个属性筛选集合不为空的属性值(jsonArray, arg1);
        if(CollectionUtils.isNotEmpty(单个属性筛选集合不为空的属性值)){
            return 单个属性筛选集合不为空的属性值.get(0);
        }
        return null;
    }
}
