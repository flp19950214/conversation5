package com.kjgs.conversation2;

import com.kjgs.枚举.Cons;
import org.bson.Document;

public abstract class FuncAbstract {
    public Document 句子成分;
    public String 句子;
    public String 句子词语;
    public int 句子下标;
    public int 句子结束下标;

    public Document 逻辑成分;
    public String 逻辑句子;
    public String 逻辑词语;
    public int 下标;
    public int 结束下标;

    public abstract void 功能();

    public void 执行流程(Document 逻辑成分, Document 句子成分) {
        this.逻辑成分 = 逻辑成分;
        this.句子成分 = 句子成分;
        赋值常用字段();
        功能();
        boolean 判断结果 = Tool.往前找判断结果(下标);
        if(判断结果){
            判断结果是true时执行();
        }
    }

    public void 判断结果是true时执行(){

    }

    protected void 赋值常用字段(){
        句子下标 = 句子成分.getInteger(Cons.在句子中的下标);
        句子结束下标 = 句子成分.getInteger(Cons.在句子中的结束下标);
        句子词语 = 句子成分.getString(Cons.词语);
        句子 = 静态引用.输入的句子对象.getString(Cons.词语);

        下标 = 逻辑成分.getInteger(Cons.下标);
        结束下标 = 逻辑成分.getInteger(Cons.结束下标);
        逻辑词语 = 逻辑成分.getString(Cons.词语);
        逻辑句子 = 静态引用.逻辑句子对象.getString(Cons.词语);
    }
}
