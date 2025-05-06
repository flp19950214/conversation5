package com.kjgs.conversation2.func;

import com.kjgs.conversation.mysql.Impl数据;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class 输入句子的数据表下标 extends FuncAbstract {

    @Autowired
    private Impl数据 impl数据;
    @Override
    public void 功能() {

    }
    @Override
    public void 判断结果是true时执行(){
        boolean 判断结果 = Tool.往前找判断结果(下标);
        if(!判断结果){
            return;
        }
        输入句子的数据表下标();
    }
    public void 输入句子的数据表下标(){
        //到数据表中找，找其中包含数据表指向属性的数据
        Document 查询上一个输出对象 = impl数据.查询数据表指向();
        if(查询上一个输出对象== null){
            查询上一个输出对象 = impl数据.查询上一个输入对象();
        }
        if(查询上一个输出对象 == null){
            return;
        }
        Document 新成分 = Tool.复制对象(句子成分);
        新成分.putAll(查询上一个输出对象);
        逻辑成分.put(Cons.指向,查询上一个输出对象);
    }


}
