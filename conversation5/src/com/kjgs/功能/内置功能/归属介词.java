package com.kjgs.功能.内置功能;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.功能.功能抽象;
import com.kjgs.工具.获取对象默认值;
import com.kjgs.常用工具.拼接字符串;
import com.kjgs.枚举.Cons;


/**
 * 代表词：的
 * 归属介词：把“的”后面的对象归为前面的对象的一个属性 如“岁的词性” == 对象岁有一个属性是词性
 * 最重要是：把前后对象合成一个整体对象
 */
public class 归属介词 extends 功能抽象 {
    // 初始化加载， 每个内置方法都有一个代表词，可能是对象也可能词词性。项目启动时加载到数据库，存在就更新
    public void 功能初始化() {
        // {"词语":"的","词性":"归属介词"}
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Cons.对象, Cons.的);
        jsonObject.put(Cons.词性, Cons.归属介词);
        initMethod(jsonObject);
    }

    /**
     * {
     *     上级对象：小明的爸爸的爸爸的爸爸是小华
     *     对象：小明
     *     下标：0
     *     结束下标：4 //当前对象+未知属性
     *     未知属性：爸爸
     * }
     * {
     *     上级对象：小明的爸爸的爸爸的爸爸是小华
     *     对象：小明的爸爸
     *     下标：0
     *     结束下标：7
     *     未知属性：爸爸
     * }
     * {
     *     上级对象：小明的爸爸的爸爸的爸爸是小华
     *     对象：小明的爸爸的爸爸
     *     下标：0
     *     结束下标：10
     *     未知属性：爸爸
     * }
     * {
     *     上级对象：小明的爸爸的爸爸的爸爸是小华
     *     对象：小明的爸爸的爸爸
     *     下标：0
     *     结束下标：10
     *     爸爸：小华
     * }
     */
    @Override
    public void 陈述句() {
        归属对象 = 获取归属对象();
        操作对象 = 获取操作对象();

        String 归属对象值 = 获取对象默认值.对象值(归属对象);
        int 归属开始下标 = 归属对象.getInteger(Cons.下标);
        String 归属未知属性 = 归属对象.getString(Cons.未知属性);
        String 操作对象值 = 获取对象默认值.对象值(操作对象);
        int 操作结束下标 = 归属对象.getInteger(Cons.结束下标);

        //拼接新的对象，下标跟归属对象一致
        JSONObject 新对象 = new JSONObject();
        String 新对象值 = 拼接字符串.拼接(归属对象值, 获取当前对象词语(), 归属未知属性);
        新对象.put(Cons.上级对象, 归属对象.getString(Cons.上级对象));
        新对象.put(Cons.对象, 新对象值);
        新对象.put(Cons.下标, 归属开始下标);
        新对象.put(Cons.结束下标, 操作结束下标);
        新对象.put(Cons.未知属性, 操作对象值);

        //记录动作内容
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        当前词语对象.put(Cons.动作句型,methodName);
        当前词语对象.put(Cons.归属对象,归属对象值);
        当前词语对象.put(Cons.操作对象,操作对象值);
        当前词语对象.put(Cons.动作结果,
                拼接字符串.拼接(Cons.新增,Cons.对象,加双引号(新对象值)));
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

    @Override
    public void 假设正向结果陈述句() {
    }
}
