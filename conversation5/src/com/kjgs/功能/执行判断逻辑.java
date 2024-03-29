package com.kjgs.功能;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.处理流程;
import com.kjgs.工具.环境信息;
import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;

public class 执行判断逻辑 {
    public static String 判断逻辑(String input){
        JSONArray jsonArray = MongoDao.regexSelect(Cons.判断条件, input);

        //多个判断逻辑依次执行，作用在一条句子上。
        String 句子清理的结果 = input;

        for(int i=0;i<jsonArray.size();i++){
            JSONObject 判断对象 = jsonArray.getJSONObject(i);
            String 判断句子 = 判断对象.getString(Cons.对象);
            //添加一条判断对象记录
            JSONArray 句子词语集合 = 处理流程.查询在句子中的词语对象(判断句子);

            JSONObject 句子所有信息 = new JSONObject();
            句子所有信息.put(Cons.待处理句子, 句子清理的结果);

            处理流程.处理句子共用流程(句子词语集合, input);

            句子清理的结果 = 句子所有信息.getString(Cons.待处理句子);
        }
        return 句子清理的结果;
    }
}
