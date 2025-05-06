package com.kjgs.conversation2.func2;

import com.kjgs.conversation.mysql.Impl逻辑;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class 中 extends FuncAbstract {
    @Autowired
    Impl逻辑 impl逻辑;
    @PostConstruct
    public void init(){
        //加载初始化逻辑语句
        impl逻辑.保存逻辑("《如果》《遇到》《中》《，》《并且》《后面》《1》《个字》《是》《有》《，》《那就》《把》《当前词》《和》《后面》《1》《个字》《合并为》《1》《个词》");
        impl逻辑.保存逻辑("《如果》《遇到》《中》《，》《并且》《后面》《1》《个字》《是》《的》《，》《那就》《把》《当前词》《和》《后面》《1》《个字》《合并为》《1》《个词》");
        impl逻辑.保存逻辑("《如果》《遇到》《中》《，》《并且》《后面》《3》《个字》《是》《文逗号》《，》《那就》《把》《当前词》《和》《后面》《3》《个字》《合并为》《1》《个词》");
        impl逻辑.保存逻辑("《如果》《遇到》《，》《，》《那就》《把》《当前词》《转义为》《中文逗号》");
        impl逻辑.保存逻辑("《如果》《遇到》《中文逗号》《，》《那就》《标记》《当前词》《的》《是否具有分隔符功能》《为》《true》");
        impl逻辑.保存逻辑("《如果》《遇到》《中》《，》《并且》《句子》《的》《句型》《是》《假设句》《，》《并且》《后面》《5》《个字》《是》《后面一个字》《，》《那就》《把》《后面》《5》《个字》《合并为》《1》《个词》");
    }
    public void 功能() {
        分词_中文逗号();
        分词_中有();
        分词_中的();
    }
    public void 分词_中文逗号(){
        Document 指定下标的逻辑成分 = Tool.指定下标的逻辑成分(结束下标);
        if (指定下标的逻辑成分 == null) {
            return;
        }
        String 词语 = "中文逗号";
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

    public void 分词_中有(){
        Document 指定下标的逻辑成分 = Tool.指定下标的逻辑成分(结束下标);
        if (指定下标的逻辑成分 == null) {
            return;
        }
        if (!"有".equals(指定下标的逻辑成分.getString(Cons.词语))) {
            return;
        }
        //满足条件 合并果，创建新成分，删除旧成分
        逻辑成分.put(Cons.词语, 逻辑成分.getString(Cons.词语) + 指定下标的逻辑成分.getString(Cons.词语));
        逻辑成分.put(Cons.结束下标, 指定下标的逻辑成分.getInteger(Cons.结束下标));
        Tool.删除指定下标的逻辑成分(指定下标的逻辑成分.getInteger(Cons.下标));
    }
    public void 分词_中的(){
        Document 指定下标的逻辑成分 = Tool.指定下标的逻辑成分(结束下标);
        if (指定下标的逻辑成分 == null) {
            return;
        }
        if (!"的".equals(指定下标的逻辑成分.getString(Cons.词语))) {
            return;
        }
        //满足条件 合并果，创建新成分，删除旧成分
        逻辑成分.put(Cons.词语, 逻辑成分.getString(Cons.词语) + 指定下标的逻辑成分.getString(Cons.词语));
        逻辑成分.put(Cons.结束下标, 指定下标的逻辑成分.getInteger(Cons.结束下标));
        Tool.删除指定下标的逻辑成分(指定下标的逻辑成分.getInteger(Cons.下标));
    }

}
