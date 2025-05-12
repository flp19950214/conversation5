package com.kjgs.conversation2;

import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
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

    public int 执行层级=2;
    public boolean 后面能否跟内置动作=true;

    public abstract void 功能() throws IngoreException;

    public void 执行流程( Document 逻辑成分, Document 句子成分, Document 原句子成分) throws IngoreException {
        if(静态引用.逻辑执行层级!=执行层级){
            return;
        }
        this.逻辑成分 = 逻辑成分;
        this.句子成分 = 句子成分;
        this.原句子成分 = 原句子成分;
        赋值常用字段();


        //如果前面一个逻辑成分后面不能跟内置动作 那么当前这次判断方法就不执行
        if(!静态引用.上个逻辑后面能否跟内置动作){
           return;
        }
        功能();
        boolean 往前找判断结果 = Tool.往前找判断结果(下标);
        //如果是《那就》后面的动作，要判断结果为true才行，并且要有判断结果
        Integer 那就的下标 = 静态引用.逻辑的那就对象.getInteger(Cons.下标);
        if(下标>那就的下标 && 往前找判断结果 == false){
            return;
        }
        //如果是判断的结果逻辑，判断结果要为true才执行
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
