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
public class 当 extends FuncAbstract {
    @Autowired
    Impl逻辑 impl逻辑;
    @PostConstruct
    public void init(){
        //加载初始化逻辑语句
        impl逻辑.保存逻辑("《如果》《遇到》《当》《，》《并且》《后面》《2》《个字》《是》《前词》《，》《那就》《把》《当前词》《和》《后面》《2》《个字》《合并为》《1》《个词》");
    }
    public void 功能() {
        分词();
    }

    public void 分词(){
        Document 指定下标的逻辑成分 = Tool.指定下标的逻辑成分(结束下标);
        if (指定下标的逻辑成分 == null) {
            return;
        }
        int 结束下标 =  下标+3;
        String 记录成处理逻辑 = 逻辑句子.substring(下标, 结束下标);
        if (!"当前词".equals(记录成处理逻辑)) {
            return;
        }
        //满足条件 合并果，创建新成分，删除旧成分
        逻辑成分.put(Cons.词语, 记录成处理逻辑);
        逻辑成分.put(Cons.结束下标, 结束下标);
        Tool.删除指定范围下标的逻辑成分(下标+1, 结束下标);
    }

    /**
     * 如果句子中有加字，前后有数字，那就加在一起
     * 如果句子以是什么结尾，并且在加和是什么之间只有数字，那么输出加的结果，
     * 如果句子中有数字，那么就判断它的前后没有数字，如果有就合并在一起
     * 如果句子中有中文格式的数字，那么就转成数字格式
     */
    public void 当前成分() {
        //当前成分
        if(下标+3>逻辑句子.length()){
            return;
        }
        String substring = 逻辑句子.substring(下标, 下标 + 3);
        if(!substring.equals("当前成分")){
            return;
        }
        //满足条件 合并果，创建新成分，删除旧成分
        逻辑成分.put(Cons.词语,substring);
        逻辑成分.put(Cons.词性,Cons.代词);
        逻辑成分.put(Cons.结束下标, 下标 + 3);
        Tool.删除指定下标的逻辑成分(下标+1);
        Tool.删除指定下标的逻辑成分(下标+2);
        Tool.删除指定下标的逻辑成分(下标+3);

    }
}

