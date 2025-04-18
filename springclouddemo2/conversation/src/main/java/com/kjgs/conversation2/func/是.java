package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 是 extends FuncAbstract {
    {
        静态引用.内置判断方法集合.add(this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".")+1));
    }
    @Override
    public void 功能() {
        判断句的包含动作();
        分词_是否具有分隔符功能();
        分词_是否是无用词();
    }
    public void 分词_是否具有分隔符功能(){
        Document 指定下标的逻辑成分 = Tool.指定下标的逻辑成分(结束下标);
        if (指定下标的逻辑成分 == null) {
            return;
        }
        String 词语 = "是否具有分隔符功能";
        int 结束下标 =  下标+词语.length();
        if(结束下标 > 逻辑句子.length()){
            return;
        }
        String 记录成处理逻辑 = 逻辑句子.substring(下标, 结束下标);
        if (!词语.equals(记录成处理逻辑)) {
            return;
        }
        //满足条件 合并果，创建新成分，删除旧成分
        逻辑成分.put(Cons.词语, 记录成处理逻辑);
        逻辑成分.put(Cons.结束下标, 结束下标);
        Tool.删除指定范围下标的逻辑成分(下标+1, 结束下标);
    }
    public void 分词_是否是无用词(){
        Document 指定下标的逻辑成分 = Tool.指定下标的逻辑成分(结束下标);
        if (指定下标的逻辑成分 == null) {
            return;
        }
        int 结束下标 =  下标+6;
        if(结束下标 > 逻辑句子.length()){
            return;
        }
        String 记录成处理逻辑 = 逻辑句子.substring(下标, 结束下标);
        if (!"是否是无用词".equals(记录成处理逻辑)) {
            return;
        }
        //满足条件 合并果，创建新成分，删除旧成分
        逻辑成分.put(Cons.词语, 记录成处理逻辑);
        逻辑成分.put(Cons.结束下标, 结束下标);
        Tool.删除指定范围下标的逻辑成分(下标+1, 结束下标);
    }
    public void 判断句的包含动作(){
        // 是判断句
        Object 句型 = Tool.往前找指定的键值(下标, Cons.句型);
        if(句型 == null || !StringUtils.equals(Cons.假设句, 句型.toString())){
            return;
        }
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Document 指定下标后面的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        if(指定下标前面的逻辑成分 == null || 指定下标后面的逻辑成分 == null){
            return;
        }
        //前面也是是 当前词不作为动词处理
        if(StringUtils.equals(指定下标前面的逻辑成分.getString(Cons.词语), "是")
        && 指定下标前面的逻辑成分.getBoolean(Cons.是否是句子成分) != Boolean.TRUE){
            return;
        }
        String 前面的词语 = 指定下标前面的逻辑成分.getString(Cons.词语);
        if(指定下标前面的逻辑成分.containsKey(Cons.归属对象)){
            前面的词语 = Tool.最终的归属对象(指定下标前面的逻辑成分).getString(指定下标前面的逻辑成分.getString(Cons.词语));
        }
        if(前面的词语==null){
            Tool.赋值判断结果(逻辑成分, false);
            return;
        }
        //前面一个成分等于后面一个成分
        boolean result = 前面的词语.equals(指定下标后面的逻辑成分.getString(Cons.词语));
        Tool.赋值判断结果(逻辑成分, result);
    }
}
