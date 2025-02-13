package com.kjgs.conversation2;

import com.kjgs.枚举.Cons;
import org.bson.Document;

public abstract class FuncAbstract {
    public Document 句子成分;
    public String 句子;
    public int 句子下标;
    public int 句子结束下标;

    public Document 逻辑成分;
    public int 下标;
    public int 结束下标;
    public String 逻辑句子;

    public abstract void 功能();

    public void 执行流程(Document 逻辑成分, Document 句子成分) {
        this.逻辑成分 = 逻辑成分;
        this.句子成分 = 句子成分;
        赋值常用字段();
        功能();
    }

    protected void 赋值常用字段(){
        句子下标 = 句子成分.getInteger(Cons.在句子中的下标);
        句子结束下标 = 句子成分.getInteger(Cons.在句子中的结束下标);
        句子 = 静态引用.输入的句子对象.getString(Cons.输入的句子);

        下标 = 逻辑成分.getInteger(Cons.下标);
        结束下标 = 逻辑成分.getInteger(Cons.结束下标);
        逻辑句子 = 静态引用.输入的句子对象.getString(Cons.逻辑句子);
    }
}
