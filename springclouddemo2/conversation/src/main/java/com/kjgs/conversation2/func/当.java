package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 当 extends FuncAbstract {

    public void 功能() {

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

