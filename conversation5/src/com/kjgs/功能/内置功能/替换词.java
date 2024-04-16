package com.kjgs.功能.内置功能;

import com.alibaba.fastjson.JSONObject;
import com.kjgs.功能.功能抽象;
import com.kjgs.工具.获取对象默认值;
import com.kjgs.常用工具.拼接字符串;
import com.kjgs.常用工具.添加集合;
import com.kjgs.枚举.Cons;


/**
 * 直接对目标句子处理
 * 默认对待处理对象做处理
 *
 * A 替换成 B  等价于  A 指向 B
 *
 * 如果遇到你，那么把待处理对象中的你替换成为当前人
 */
public class 替换词 extends 功能抽象 {
    public static String 替换 = "替换";
    @Override
    public void 功能初始化() {
        // {"词语":"替换成","词性":"替换词"}
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Cons.对象, Cons.替换成);
        jsonObject.put(Cons.词性, Cons.替换词);
        initMethod(jsonObject);
    }


    @Override
    public void 陈述句() {

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

    /**
     * 如果遇到'你'，那么把待处理对象中的'你'替换成为当前人
     * {
     *     上级对象：如果遇到'你'，那么把待处理对象中的'你'替换成为当前人
     *     对象：待处理对象
     *     指向：我爱你
     *     未知属性:'你'
     * }
     * 替换后
     * {
     *     上级对象：如果遇到'你'，那么把待处理对象中的'你'替换成为当前人
     *     对象：待处理对象
     *     指向：我爱小燕
     * }
     */
    @Override
    public void 假设陈述句() {
        归属对象 = 获取归属对象();
        操作对象 = 获取操作对象();
        if(归属对象 == null || 操作对象 ==null) {
            return;
        }
        String 归属对象值 = 获取对象默认值.对象值(归属对象);//被替换词
        String 操作对象值 = 获取对象默认值.对象值(操作对象);//替换词

        //替换 改为 指向
        归属对象.put(Cons.指向, 操作对象值);

        //记录动作内容
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        当前词语对象.put(Cons.动作句型,methodName);
        当前词语对象.put(Cons.归属对象,归属对象值);
        当前词语对象.put(Cons.操作对象,操作对象值);
        String 动作结果 = 拼接字符串.拼接(Cons.对象,加双引号(归属对象值)
                , Cons.新增
                ,Cons.属性,加双引号(Cons.指向 +Cons.箭头符+ 操作对象值)
        );
        当前词语对象.put(Cons.动作结果, 添加集合.添加集合类型属性元素(当前词语对象, Cons.动作结果, 动作结果));
    }
}
