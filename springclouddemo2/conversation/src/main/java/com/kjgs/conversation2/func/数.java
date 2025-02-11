package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 数 extends FuncAbstract {

    public void 功能() {
        分词();
    }

    public void 分词(){
        if (下标 != 0) {
            return;
        }
        Document 指定下标的逻辑成分 = Tool.指定下标的逻辑成分(结束下标);
        if (指定下标的逻辑成分 == null) {
            return;
        }
        if (!"字".equals(指定下标的逻辑成分.getString(Cons.词语))) {
            return;
        }
        //满足条件 合并果，创建新成分，删除旧成分
        逻辑成分.put(Cons.词语, 逻辑成分.getString(Cons.词语) + 指定下标的逻辑成分.getString(Cons.词语));
        逻辑成分.put(Cons.结束下标, 指定下标的逻辑成分.getInteger(Cons.结束下标));
        Tool.删除指定下标的逻辑成分(指定下标的逻辑成分.getInteger(Cons.下标));
    }

    public void 以如开头并且下一个词是果() {
        //1,表示判断句， 找到后面表示肯定的 赋值为肯定句，找到表示否定的 赋值为否定句
        Tool.赋值后面所有逻辑成分的句型(下标, Cons.假设句);
    }
}
