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
public class 动 extends FuncAbstract {

    @Autowired
    Impl逻辑 impl逻辑;
    @PostConstruct
    public void init(){
        //加载初始化逻辑语句
        impl逻辑.保存逻辑("《如果》《遇到》《动》《，》《并且》《后面3个字》《是》《作结果》《，》《那就》《把》《当前词》《和》《后面3个字》《合并为》《1》《个词》");
    }


    public void 功能() {
        分词_动作结果();
    }

    public void 分词_动作结果(){
        Document 指定下标的逻辑成分 = Tool.指定下标的逻辑成分(结束下标);
        if (指定下标的逻辑成分 == null) {
            return;
        }
        int 结束下标 =  下标+4;
        String 动作结果 = 逻辑句子.substring(下标, 结束下标);
        if (!"动作结果".equals(动作结果)) {
            return;
        }
        //满足条件 合并果，创建新成分，删除旧成分
        逻辑成分.put(Cons.词语, 动作结果);
        逻辑成分.put(Cons.结束下标, 结束下标);
        Tool.删除指定范围下标的逻辑成分(下标+1, 结束下标);
    }

}
