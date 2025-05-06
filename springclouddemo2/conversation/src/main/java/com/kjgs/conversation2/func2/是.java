package com.kjgs.conversation2.func2;

import com.kjgs.conversation.mysql.Impl逻辑;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service("是2")
public class 是 extends FuncAbstract {
    @Autowired
    Impl逻辑 impl逻辑;
    @PostConstruct
    public void init(){
        //加载初始化逻辑语句
        impl逻辑.保存逻辑("《如果》《遇到》《是》《，》《并且》《后面》《5》《个字》《是》《否是无用词》《，》《那就》《把》《当前词》《和》《后面》《5》《个字》《合并为》《1》《个词》");
        impl逻辑.保存逻辑("《如果》《遇到》《是》《，》《并且》《后面》《8》《个字》《是》《否具有分隔符功能》《，》《那就》《把》《当前词》《和》《后面》《8》《个字》《合并为》《1》《个词》");
        impl逻辑.保存逻辑("《如果》《遇到》《是》《，》《并且》《句子》《的》《句型》《是》《假设句》《，》《那就》《把》《当前词》《和》《后面》《1》《个分隔符》《之间的内容》《合并为》《1》《个词》");

    }
    @Override
    public void 功能() {
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
}
