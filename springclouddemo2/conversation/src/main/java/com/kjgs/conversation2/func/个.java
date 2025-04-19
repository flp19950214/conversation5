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
public class 个 extends FuncAbstract {
    @Autowired
    Impl逻辑 impl逻辑;
    @PostConstruct
    public void init(){
        //加载初始化逻辑语句
        impl逻辑.保存逻辑("如果遇到个，并且后面3个字是《属性是》，那就把当前词和后面3个字合并为1个词");
        impl逻辑.保存逻辑("如果遇到个，并且后面2个字是《成分》，那就把当前词和后面2个字合并为1个词");
        impl逻辑.保存逻辑("如果遇到个，并且后面2个字是《名词》，那就把当前词和后面2个字合并为1个词");
        impl逻辑.保存逻辑("如果遇到个，并且后面1个字是《字》，那就把当前词和后面1个字合并为1个词");
        impl逻辑.保存逻辑("如果遇到个，并且后面1个字是《词》，那就把当前词和后面1个字合并为1个词");
    }
    public void 功能() {
        分词();
    }

    public void 分词(){
        Document 指定下标的逻辑成分 = Tool.指定下标的逻辑成分(结束下标);
        if (指定下标的逻辑成分 == null) {
            return;
        }
        if ("字".equals(指定下标的逻辑成分.getString(Cons.词语))
                || "词".equals(指定下标的逻辑成分.getString(Cons.词语))
                || "成分".equals(指定下标的逻辑成分.getString(Cons.词语))
                || "属性是".equals(指定下标的逻辑成分.getString(Cons.词语))
                || "名词".equals(指定下标的逻辑成分.getString(Cons.词语))
        ) {
            //满足条件 合并果，创建新成分，删除旧成分
            逻辑成分.put(Cons.词语, 逻辑成分.getString(Cons.词语) + 指定下标的逻辑成分.getString(Cons.词语));
            逻辑成分.put(Cons.结束下标, 指定下标的逻辑成分.getInteger(Cons.结束下标));
            Tool.删除指定下标的逻辑成分(指定下标的逻辑成分.getInteger(Cons.下标));
        }

    }

}
