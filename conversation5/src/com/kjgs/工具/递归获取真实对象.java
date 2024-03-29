package com.kjgs.工具;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;

public class 递归获取真实对象 {
    static int num = 0;//顶多递归20次，防止死循环
    public static JSONObject 递归查内存获取真实对象(JSONArray 内存集合, JSONObject jsonObject){
        if(num == 20){
            return jsonObject;
        }
        String 指向对象 = jsonObject.getString(Cons.指向);
        if(指向对象 != null){
            // 先到当前集合对象中查，再查库
            JSONObject 内存结果 = 递归查内存获取真实对象(内存集合, 指向对象);
            if(null != 内存结果){
                return 内存结果;
            }
            //查库
            JSONArray 根据对象查询结果 = MongoDao.select(Cons.对象, 指向对象);
            JSONObject 库结果 = 递归查内存获取真实对象(根据对象查询结果, 指向对象);
            if(null != 内存结果){
                return 内存结果;
            }
        }
        return  jsonObject;
    }

    public static JSONObject 递归查内存获取真实对象(JSONArray 查询结果集合, String 指向对象){
        for (int i = 0; i < 查询结果集合.size(); i++) {
            JSONObject 临时对象 = 查询结果集合.getJSONObject(i);
            String 临时指向对象 = 临时对象.getString(Cons.指向);
            String 临时对象值 = 获取对象默认值.对象值(临时对象);
            if(!指向对象.equals(临时对象值)){
                continue;
            }
            if(临时指向对象==null){
                return 临时对象;
            }else{
                递归查内存获取真实对象(查询结果集合, 临时对象);
            }
        }
        return null;
    }
}
