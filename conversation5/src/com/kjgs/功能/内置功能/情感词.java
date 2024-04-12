package com.kjgs.功能.内置功能;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.功能.功能抽象;
import com.kjgs.工具.获取对象默认值;
import com.kjgs.常用工具.保存对象;
import com.kjgs.常用工具.拼接字符串;
import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import org.apache.commons.collections4.CollectionUtils;

public class 情感词 extends 功能抽象 {
    @Override
    public void 功能初始化() {
        // {"对象,":"爱","词性":"情感词"}
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Cons.对象, Cons.爱);
        jsonObject.put(Cons.词性, Cons.情感词);
        initMethod(jsonObject);
    }

    @Override
    public void 陈述句() {
        归属对象 = 获取归属对象();
        操作对象 = 获取操作对象();
        if(归属对象 == null || 操作对象 == null){
            return;
        }
        String 归属对象值 = 获取对象默认值.对象值(归属对象);
        String 操作对象值 = 获取对象默认值.对象值(操作对象);
        String 属性 = 获取当前对象词语();
        归属对象.put(属性, 操作对象值);

        //新增一个情感对象
        JSONObject 新对象 = new JSONObject();
        新对象.put(Cons.对象, 拼接字符串.拼接(归属对象值, Cons.对, 操作对象值));
        新对象.put(Cons.是否是新对象, Boolean.TRUE);
        JSONArray 查询词语集合 = MongoDao.select(新对象);
        if(CollectionUtils.isNotEmpty(查询词语集合)){
            JSONObject 第一个对象 = 查询词语集合.getJSONObject(0);
            第一个对象.put(Cons.好感度, 第一个对象.getInteger(Cons.好感度)+10);
            保存对象.保存或更新对象(第一个对象);
        }else{
            新对象.put(Cons.好感度, 10);
            保存对象.保存或更新对象(新对象);
        }

        //记录动作内容
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        当前词语对象.put(Cons.动作句型,methodName);
        当前词语对象.put(Cons.归属对象,归属对象值);
        当前词语对象.put(Cons.操作对象,操作对象值);
        当前词语对象.put(Cons.动作结果,
                拼接字符串.拼接(Cons.对象,加双引号(归属对象值)
                        , Cons.新增
                        ,Cons.属性,加双引号(属性 +"->"+ 操作对象值)
                ));
    }

    @Override
    public void 疑问句() {

    }

    @Override
    public void 否定句() {

    }

    @Override
    public void 假设句() {

    }

    @Override
    public void 假设陈述句() {

    }
}
