package com.kjgs.功能.内置功能;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.功能.功能抽象;
import com.kjgs.工具.根据属性筛选集合;
import com.kjgs.工具.获取对象默认值;
import com.kjgs.常用工具.拼接字符串;
import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class 指向词 extends 功能抽象 {
    // 初始化加载， 每个内置方法都有一个代表词，可能是对象也可能词词性。项目启动时加载到数据库，存在就更新
    @Override
    public void 功能初始化() {
        // {"词语":"是","词性":"指向词"}
        JSONObject jsonObject是 = new JSONObject();
        jsonObject是.put(Cons.对象, Cons.叫);
        jsonObject是.put(Cons.词性, Cons.指向词);
        initMethod(jsonObject是);
        JSONObject jsonObject叫 = new JSONObject();
        jsonObject叫.put(Cons.对象, Cons.是);
        jsonObject叫.put(Cons.词性, Cons.指向词);
        initMethod(jsonObject叫);
    }

    /**
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
        if(归属对象 == null || 操作对象 == null){
            return;
        }
        String 归属对象值 = 获取对象默认值.对象值(归属对象);
        String 归属未知属性 = 归属对象.getString(Cons.未知属性);
        String 操作对象值 = 获取对象默认值.对象值(操作对象);

        //处理逻辑：新增属性，并把临时属性删掉
        String 属性;
        if(归属未知属性==null){
            属性 = 获取当前对象词语();
        }else{
            属性 = 归属未知属性;
            归属对象.remove(Cons.未知属性);
        }
        归属对象.put(属性, 操作对象值);

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


    @Test
    public void test() {
    }
    @Test
    public void test_疑问句() {

    }
    /**
     * 岁的词性是什么？
     * 默认处理：找到 归属对象（作为属性）， 再找到归属对象的归属对象（作为对象）。最后查库
     * result:添加一个属性
     */
    @Override
    public void 疑问句() {
        归属对象 = 获取归属对象();
        if(归属对象 == null){
            return;
        }
        String 归属对象值 = 获取对象默认值.对象值(归属对象);
        String 归属未知属性 = 归属对象.getString(Cons.未知属性);
        if(归属未知属性 == null){
            归属未知属性 = 获取当前对象词语();
        }
        //查库 获取第一个
        Map<String,String> map = new HashMap<>();
        map.put(Cons.对象, 归属对象值);
        JSONArray 查询结果集合 = MongoDao.select(map);
        Object 查询结果属性值 = 根据属性筛选集合.单个属性筛选集合不为空的第一个属性值(查询结果集合, 归属未知属性);

        //记录动作内容
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        当前词语对象.put(Cons.动作句型,methodName);
        当前词语对象.put(Cons.归属对象,归属对象值);
        String 动作结果 = 拼接字符串.拼接(加双引号(归属对象值), Cons.根据,
                加双引号(归属未知属性), Cons.的,
                Cons.查询结果,Cons.是);
        if(查询结果属性值 == null){
            当前词语对象.put(Cons.动作结果,  拼接字符串.拼接(动作结果, 加双引号(Cons.空)));
        }else{
            当前词语对象.put(Cons.动作结果,拼接字符串.拼接(动作结果, 加双引号(查询结果属性值.toString())));
        }
    }

    @Test
    public void 疑问句_test(){
        疑问句();
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
