package com.kjgs.工具;

import com.alibaba.fastjson.JSONObject;
import com.kjgs.枚举.Cons;

public class 获取对象默认值 {

    /**
     * 是代理词的，那就递归找，不是那就直接返回对象值
     */
    public  static String 对象值(JSONObject jsonObject){
        String 对象 = jsonObject.getString(Cons.对象);
        if(对象 == null){
            return jsonObject.getString(Cons.是);
        }else{
            return 对象;
        }
    }
}
