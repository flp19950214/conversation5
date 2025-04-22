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
public class 偏 extends FuncAbstract {
    @Autowired
    Impl逻辑 impl逻辑;
    @PostConstruct
    public void init(){
        //加载初始化逻辑语句
        impl逻辑.保存逻辑("如果遇到偏，并且后面2个字是《移量》，那就把当前词和后面2个字合并为1个词");
        impl逻辑.保存逻辑("如果遇到偏，并且后面4个字是《移量尺寸》，那就把当前词和后面4个字合并为1个词");
    }
    public void 功能() {
        分词_偏移量尺寸();
        分词_偏移量();
    }
    public void 分词_偏移量尺寸(){
        Document 指定下标的逻辑成分 = Tool.指定下标的逻辑成分(结束下标);
        if (指定下标的逻辑成分 == null) {
            return;
        }
        int 结束下标 =  下标+5;
        String 执行相加方法 = 逻辑句子.substring(下标, 结束下标);
        if (!"偏移量尺寸".equals(执行相加方法)) {
            return;
        }
        //满足条件 合并果，创建新成分，删除旧成分
        逻辑成分.put(Cons.词语, 执行相加方法);
        逻辑成分.put(Cons.结束下标, 结束下标);
        Tool.删除指定范围下标的逻辑成分(下标+1, 结束下标);
    }

    public void 分词_偏移量(){
        Document 指定下标的逻辑成分 = Tool.指定下标的逻辑成分(结束下标);
        if (指定下标的逻辑成分 == null) {
            return;
        }
        int 结束下标 =  下标+3;
        String 执行相加方法 = 逻辑句子.substring(下标, 结束下标);
        if (!"偏移量".equals(执行相加方法)) {
            return;
        }
        //满足条件 合并果，创建新成分，删除旧成分
        逻辑成分.put(Cons.词语, 执行相加方法);
        逻辑成分.put(Cons.结束下标, 结束下标);
        Tool.删除指定范围下标的逻辑成分(下标+1, 结束下标);
    }

}
