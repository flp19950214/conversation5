package com.kjgs.功能;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.处理流程;
import com.kjgs.数据库.Mongo获取判断逻辑;
import com.kjgs.枚举.Cons;

/**
 * 1,只需要知道判断条件就行，无需正向或负向判断逻辑。然后按照句子意思执行逻辑就行
 *
 * 2,判断逻辑值改变对象的值。所有无返回值。
 *
 * 3,只对传进来的对象做判断
 */
public class 执行判断逻辑 {

    public static void main(String[] args) {
        JSONObject 待处理对象 = new JSONObject();
        待处理对象.put(Cons.对象, "找当前人的指向");
        判断逻辑(待处理对象);
    }

    public static void 判断逻辑(JSONObject 待处理对象){
        String 对象值 = 待处理对象.getString(Cons.对象);
        JSONArray jsonArray = Mongo获取判断逻辑.正则查询判断逻辑(对象值);

        //多个判断逻辑依次执行，作用在一条句子上。
        for(int i=0;i<jsonArray.size() && i<1;i++){//执行一个判断即可
            执行一条判断逻辑(jsonArray.getJSONObject(i), 待处理对象);
        }
    }

    public static void 执行一条判断逻辑(JSONObject 判断对象, JSONObject 待处理对象){
        String 对象值 = 待处理对象.getString(Cons.对象);
        JSONObject 新建待处理对象 = new JSONObject();
        待处理对象.put(Cons.对象, Cons.待处理对象);
        待处理对象.put(Cons.指向, 对象值);

        String 判断句子 = 判断对象.getString(Cons.对象);
        //添加一条判断对象记录
        JSONArray 句子词语集合 = 处理流程.查询在句子中的词语对象(判断句子);

        句子词语集合.add(新建待处理对象);

        处理流程.处理句子共用流程(句子词语集合, 判断句子);
    }
}
