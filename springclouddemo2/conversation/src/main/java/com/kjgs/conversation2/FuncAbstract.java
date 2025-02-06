package com.kjgs.conversation2;

import com.kjgs.枚举.Cons;
import org.bson.Document;

public abstract class FuncAbstract {
    public Document 逻辑成分;
    public int 下标;
    public int 结束下标;
    public String 逻辑句子;
    public String 输入的句子;
    public abstract void 功能();

    public void 执行流程(Document 逻辑成分) {
        this.逻辑成分 = 逻辑成分;
        赋值常用字段();
        功能();
    }

    protected void 赋值常用字段(){
        下标 = 逻辑成分.getInteger(Cons.下标);
        下标 = 逻辑成分.getInteger(Cons.结束下标);
    }
}
