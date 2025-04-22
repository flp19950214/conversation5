package com.kjgs.conversation2.func;

import com.kjgs.conversation.mysql.Impl逻辑;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class 是 extends FuncAbstract {
    {
        静态引用.内置判断方法集合.add(this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".")+1));
    }

    @Autowired
    Impl逻辑 impl逻辑;
    @PostConstruct
    public void init(){
        //加载初始化逻辑语句
        impl逻辑.保存逻辑("如果遇到是，并且后面5个字是《否是无用词》，那就把当前词和后面5个字合并为1个词");
        impl逻辑.保存逻辑("如果遇到是，并且后面8个字是《否具有分隔符功能》，那就把当前词和后面8个字合并为1个词");

        impl逻辑.保存逻辑("如果遇到是，并且句子的句型是假设句，那就把当前词和后面1个分隔符之间的内容合并为1个词");

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
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Document 指定下标后面的逻辑成分 = Tool.指定下标后面的逻辑成分(下标);
        if(指定下标前面的逻辑成分 == null || 指定下标后面的逻辑成分 == null){
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
