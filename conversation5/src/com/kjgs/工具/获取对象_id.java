package com.kjgs.工具;

import com.alibaba.fastjson.JSONObject;
import com.kjgs.数据库.MongoBaseDao;
import com.kjgs.枚举.Cons;

public class 获取对象_id {
    public static String 获取_id(JSONObject jsonObject){
        if(jsonObject.getJSONObject(Cons._id) == null){
            return null;
        }
        return jsonObject.getJSONObject(Cons._id).getString(MongoBaseDao.$oid);
    }
}
