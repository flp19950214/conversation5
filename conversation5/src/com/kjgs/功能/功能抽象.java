package com.kjgs.功能;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.工具.获取归属对象;
import com.kjgs.工具.获取操作对象;
import com.kjgs.常用工具.保存对象;
import com.kjgs.常用工具.拼接字符串;
import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import org.apache.commons.collections4.CollectionUtils;


public abstract class 功能抽象 implements 功能接口{
    public JSONArray 句子词语集合;
    public JSONObject 当前词语对象;
    public JSONObject 归属对象;
    public JSONObject 操作对象;

    public int 获取当前词语对象下标(){
        return 当前词语对象.getInteger(Cons.下标);
    }
    public int 获取当前词语对象结束下标(){
        return 当前词语对象.getInteger(Cons.结束下标);
    }
    public String 获取当前对象词语(){
        return 当前词语对象.getString(Cons.对象);
    }
    public String 获取当前词语的上级对象(){
        return 当前词语对象.getString(Cons.上级对象);
    }
    public abstract void 功能初始化();

    /**
     * @param jsonObject
     * {
     *     "对象": "如果",
     *     "词性": "假设词"
     * }
     */
    public void initMethod(JSONObject jsonObject) {
        JSONArray 查询词语集合 = MongoDao.select(jsonObject);
        if (CollectionUtils.isNotEmpty(查询词语集合)) {
            return;
        }
        保存对象.保存或更新对象(jsonObject);
    }

    public void 执行流程(JSONArray 句子词语集合, JSONObject 当前词语对象) {
        this.句子词语集合 = 句子词语集合;
        this.当前词语对象 = 当前词语对象;
        String 句型 = 当前词语对象.getString(Cons.句型);
        function(句型 == null ? "陈述句" : 句型);
    }
    //词的句型一旦发生改变，则需要重新执行新句型的方法
    public void function(String 句型) {
        Boolean 是否执行动作 = 当前词语对象.getBoolean(Cons.是否执行动作);
        if(是否执行动作!=null && 是否执行动作==false){
            return;
        }
        switch (句型) {
            case Cons.疑问句:
                疑问句();
                break;
            case Cons.假设句:
                假设句(); // 假设条件句
                break;
            case Cons.假设陈述句:
                否定句();
                break;
            case Cons.否定句:
                否定句();
                break;
            default:
                陈述句();
        }
    }

    /**
     *
     * @return
     */
    public JSONObject 获取归属对象(){
        JSONObject 归属对象 = 获取归属对象.归属或默认对象(句子词语集合, 当前词语对象);
//        归属对象 = 递归获取真实对象.递归查内存获取真实对象(句子词语集合, 归属对象);
        return 归属对象;
    }

    /**
     *
     * @return
     */
    public JSONObject 获取操作对象(){
        JSONObject 操作对象 = 获取操作对象.操作或默认对象(句子词语集合,当前词语对象);
//        操作对象 = 递归获取真实对象.递归查内存获取真实对象(句子词语集合, 操作对象);
        return 操作对象;
    }

    public String 加双引号(Object arg){
        return 拼接字符串.双引号拼接(arg);
    }
}
