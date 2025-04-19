package com.kjgs.conversation2.func;

import com.kjgs.conversation.mysql.Impl逻辑;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class 输 extends FuncAbstract {
    @Autowired
    Impl逻辑 impl逻辑;
    @PostConstruct
    public void init(){
        //加载初始化逻辑语句
        impl逻辑.保存逻辑("如果遇到输，并且后面9个字是《入句子的数据表下标》，那就把当前词和后面9个字合并为1个词");
        impl逻辑.保存逻辑("如果遇到输，并且后面4个字是《入的句子》，那就把当前词和后面4个字合并为1个词");
        impl逻辑.保存逻辑("如果遇到输，并且后面4个字是《出的对象》，那就把当前词和后面4个字合并为1个词");
        impl逻辑.保存逻辑("如果遇到输，并且后面1个字是出，那就把当前词和后面1个字合并为1个词");

        impl逻辑.保存逻辑("如果遇到输出，并且句子的句型是假设句，那就把后面的内容合并为1个词");
    }

    public void 功能() {
        分词_输入句子的数据表下标();
        分词_输入的句子();
        分词_输出的对象();
        分词_输出();
    }

    public void 分词_输出(){
        Document 指定下标的逻辑成分 = Tool.指定下标的逻辑成分(结束下标);
        if (指定下标的逻辑成分 == null) {
            return;
        }
        if (!"出".equals(指定下标的逻辑成分.getString(Cons.词语))) {
            return;
        }
        //满足条件 合并果，创建新成分，删除旧成分
        逻辑成分.put(Cons.词语, 逻辑成分.getString(Cons.词语) + 指定下标的逻辑成分.getString(Cons.词语));
        逻辑成分.put(Cons.结束下标, 指定下标的逻辑成分.getInteger(Cons.结束下标));
        Tool.删除指定下标的逻辑成分(指定下标的逻辑成分.getInteger(Cons.下标));
    }
    public void 分词_输出的对象(){
        Document 指定下标的逻辑成分 = Tool.指定下标的逻辑成分(结束下标);
        if (指定下标的逻辑成分 == null) {
            return;
        }
        int 结束下标 =  下标+5;
        if(结束下标>逻辑句子.length()){
            return;
        }
        String 执行相加方法 = 逻辑句子.substring(下标, 结束下标);
        if (!"输出的对象".equals(执行相加方法)) {
            return;
        }
        //满足条件 合并果，创建新成分，删除旧成分
        逻辑成分.put(Cons.词语, 执行相加方法);
        逻辑成分.put(Cons.结束下标, 结束下标);
        Tool.删除指定范围下标的逻辑成分(下标+1, 结束下标);
    }

    public void 分词_输入的句子(){
        Document 指定下标的逻辑成分 = Tool.指定下标的逻辑成分(结束下标);
        if (指定下标的逻辑成分 == null) {
            return;
        }
        int 结束下标 =  下标+5;
        if(结束下标>逻辑句子.length()){
            return;
        }
        String 执行相加方法 = 逻辑句子.substring(下标, 结束下标);
        if (!"输入的句子".equals(执行相加方法)) {
            return;
        }
        //满足条件 合并果，创建新成分，删除旧成分
        逻辑成分.put(Cons.词语, 执行相加方法);
        逻辑成分.put(Cons.结束下标, 结束下标);
        Tool.删除指定范围下标的逻辑成分(下标+1, 结束下标);
    }
    public void 分词_输入句子的数据表下标(){
        Document 指定下标的逻辑成分 = Tool.指定下标的逻辑成分(结束下标);
        if (指定下标的逻辑成分 == null) {
            return;
        }
        int 结束下标 =  下标+10;
        if(逻辑句子.length()<结束下标){
            return;
        }
        String 执行相加方法 = 逻辑句子.substring(下标, 结束下标);
        if (!"输入句子的数据表下标".equals(执行相加方法)) {
            return;
        }
        //满足条件 合并果，创建新成分，删除旧成分
        逻辑成分.put(Cons.词语, 执行相加方法);
        逻辑成分.put(Cons.结束下标, 结束下标);
        Tool.删除指定范围下标的逻辑成分(下标+1, 结束下标);
    }
}
