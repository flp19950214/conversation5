package com.kjgs.功能.内置功能;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.功能.功能抽象;
import com.kjgs.工具.根据属性筛选集合;
import com.kjgs.工具.获取对象默认值;
import com.kjgs.工具.非递归查询对象;
import com.kjgs.常用工具.拼接字符串;
import com.kjgs.常用工具.添加集合;
import com.kjgs.枚举.Cons;

public class 查找词 extends 功能抽象 {

    @Override
    public void 功能初始化() {
        // {"词语":"是","词性":"指向词"}
        JSONObject jsonObject是 = new JSONObject();
        jsonObject是.put(Cons.对象, Cons.找);
        jsonObject是.put(Cons.词性, Cons.查找词);
        initMethod(jsonObject是);
    }

    /**
     * 找当前人的指向
     * 找 当前人 的 指向
     *
     * 两个结果：在当前人对象中，给属性 指向 赋值
     *          在当前人的指向中，给属性 指向 赋值
     */
    @Override
    public void 陈述句() {
        操作对象=获取操作对象();
        if(操作对象==null){
            return;
        }
        //拿对象查未知属性
        String 归属对象值 = 获取对象默认值.对象值(操作对象);
        JSONArray 对象集合 = 非递归查询对象.单条件先查缓存再查数据库(句子词语集合, Cons.对象, 归属对象值);
        String 查询属性 = 操作对象.getString(Cons.未知属性);
        JSONArray 查询属性值 = 根据属性筛选集合.单个属性筛选集合不为空的属性值(对象集合, 查询属性);
        操作对象.put(查询属性, 查询属性值);

        //记录动作内容
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        当前词语对象.put(Cons.动作句型,methodName);
        当前词语对象.put(Cons.归属对象,归属对象值);
        String 动作结果 = 拼接字符串.拼接(Cons.对象,加双引号(归属对象值)
                , Cons.和
                ,Cons.属性,加双引号(查询属性),
                Cons.的,
                Cons.查询结果,
                Cons.是,
                加双引号(JSON.toJSONString(查询属性值))
        );
        当前词语对象.put(Cons.动作结果, 添加集合.添加集合类型属性元素(当前词语对象, Cons.动作结果, 动作结果));
    }

    @Override
    public void 疑问句() {

    }

    @Override
    public void 假设句() {

    }

    @Override
    public void 否定句() {

    }

    @Override
    public void 假设陈述句() {

    }
}
