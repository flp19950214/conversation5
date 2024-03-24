package com.kjgs.功能.内置功能;

import com.alibaba.fastjson.JSONObject;
import com.kjgs.功能.功能抽象;
import com.kjgs.工具.获取对象默认值;
import com.kjgs.常用工具.拼接字符串;
import com.kjgs.枚举.Cons;


/**
 * 直接对目标句子处理
 * 默认对待处理句子做处理
 *
 * 如果遇到你，那么把待处理句子中的你替换成为当前人
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
    public void 假设负向结果陈述句() {

    }

    @Override
    public void 假设句() {

    }

    /**
     * 如果遇到'你'，那么把待处理句子中的'你'替换成为当前人
     * {
     *     上级对象：如果遇到'你'，那么把待处理句子中的'你'替换成为当前人
     *     对象：待处理句子
     *     指向：我爱你
     *     未知属性:'你'
     * }
     * 替换后
     * {
     *     上级对象：如果遇到'你'，那么把待处理句子中的'你'替换成为当前人
     *     对象：待处理句子
     *     指向：我爱小燕
     * }
     */
    @Override
    public void 假设正向结果陈述句() {
        JSONObject 归属对象 = 获取归属对象();
        JSONObject 操作对象 = 获取操作对象();
        if(归属对象 == null || 操作对象 ==null) {
            return;
        }
        String 归属对象值 = 获取对象默认值.对象值(归属对象);//被替换词
        String 归属对象未知属性 = 归属对象.getString(Cons.未知属性);//替换内容
        String 操作对象值 = 获取对象默认值.对象值(操作对象);//替换词

        //替换
        String 替换结果 = 归属对象值.replace(归属对象未知属性,操作对象值);

        //覆盖原值
        归属对象.put(Cons.对象, 替换结果);

        //记录动作内容
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        当前词语对象.put(Cons.动作句型,methodName);
        当前词语对象.put(Cons.归属对象,归属对象值);
        当前词语对象.put(Cons.归属对象未知属性,归属对象未知属性);
        当前词语对象.put(Cons.操作对象,操作对象值);
        当前词语对象.put(Cons.动作结果,
                拼接字符串.拼接(Cons.把,加双引号(归属对象值),
                        Cons.中,Cons.的,加双引号(归属对象未知属性),
                        Cons.替换成,加双引号(操作对象值)
                ));
    }
}
