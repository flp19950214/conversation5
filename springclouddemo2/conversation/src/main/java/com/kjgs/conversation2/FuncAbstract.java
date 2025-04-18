package com.kjgs.conversation2;

import com.kjgs.枚举.Cons;
import org.bson.Document;

public abstract class FuncAbstract {
    public Document 句子成分;
    public Document 原句子成分;
    public String 句子;
    public String 句子词语;
    public int 句子下标;
    public int 句子结束下标;

    public Document 逻辑成分;
    public String 逻辑句子;
    public String 逻辑词语;
    public int 下标;
    public int 结束下标;

    public abstract void 功能() throws IngoreException;

    public void 执行流程(Document 逻辑成分, Document 句子成分, Document 原句子成分) throws IngoreException {
        this.逻辑成分 = 逻辑成分;
        this.句子成分 = 句子成分;
        this.原句子成分 = 原句子成分;
        赋值常用字段();

        //如果前面一个逻辑成分是内置判断方法 那么就当前这次判断方法就不执行
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        if(指定下标前面的逻辑成分 != null && 指定下标前面的逻辑成分.containsKey(Cons.词语)) {
            if(静态引用.内置判断方法集合.contains(指定下标前面的逻辑成分.getString(Cons.词语))
                && 静态引用.内置判断方法集合.contains(逻辑词语)){
                return;
            }
        }

        //如果判断的结果逻辑，判断结果要为true才执行
        if(静态引用.是否是陈述部分逻辑 && Tool.往前找判断结果(下标) == false){
            return;
        }
        功能();
        判断结果是true时执行();
    }

    public void 判断结果是true时执行(){

    }

    protected void 赋值常用字段(){
        句子下标 = 句子成分.containsKey(Cons.下标) ? 句子成分.getInteger(Cons.下标):原句子成分.getInteger(Cons.下标);
        句子结束下标 = 句子成分.containsKey(Cons.结束下标) ? 句子成分.getInteger(Cons.结束下标) : 原句子成分.getInteger(Cons.结束下标);
        句子词语 = 句子成分.containsKey(Cons.词语) ? 句子成分.getString(Cons.词语):原句子成分.getString(Cons.词语);
        句子 = 静态引用.输入的句子对象.getString(Cons.词语);

        下标 = 逻辑成分.getInteger(Cons.下标);
        结束下标 = 逻辑成分.getInteger(Cons.结束下标);
        逻辑词语 = 逻辑成分.getString(Cons.词语);
        逻辑句子 = 静态引用.逻辑句子对象.getString(Cons.词语);
    }
}
