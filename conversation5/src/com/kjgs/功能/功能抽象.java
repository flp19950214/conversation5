package com.kjgs.功能;

import com.kjgs.枚举.Cons;
import org.bson.Document;

import java.util.List;


public abstract class 功能抽象 implements 功能接口 {
    public List<Document> 所有逻辑对象;
    public Document 当前逻辑对象;
    public Document 当前动作;
    public Document 当前逻辑句子对象;
    public String 当前逻辑句子;

    public int 获取当前逻辑对象开始下标(){
        return 当前逻辑对象.getInteger(Cons.开始下标);
    }
    public int 获取当前逻辑对象结束下标(){
        return 当前逻辑对象.getInteger(Cons.结束下标);
    }
    public void 执行流程(Document 逻辑对象) {
        当前逻辑对象 = 逻辑对象;
        功能();
    }

}
