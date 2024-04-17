package com.kjgs.工具;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.数据库.MongoDao;
import org.apache.commons.collections4.CollectionUtils;

public class 非递归查询对象 {

    public static JSONArray 单条件先查缓存再查数据库(JSONArray 缓存, String 键, Object 键值){
        JSONArray result = new JSONArray();
        JSONArray 查缓存结果 = 查缓存(缓存, 键, 键值);
        JSONArray 查数据库结果 = 查数据库(键, 键值);
        if(CollectionUtils.isNotEmpty(查缓存结果)){
            result.addAll(查缓存结果);
        }     if(CollectionUtils.isNotEmpty(查数据库结果)){
            result.addAll(查数据库结果);
        }
        return result;
    }

    public static JSONArray 查缓存(JSONArray 缓存, String 键, Object 键值){
        JSONArray result = new JSONArray();
        for(int i=0;i<缓存.size();i++) {
            JSONObject 临时对象 = 缓存.getJSONObject(i);
            if(!临时对象.keySet().contains(键)){
                continue;
            }
            if(键值.toString().equals(临时对象.get(键).toString())){
                result.add(临时对象);
            }
        }
        return result;
    }

    public static JSONArray 查数据库(String 键, Object 键值){
        return MongoDao.select(键, 键值);
    }
}
