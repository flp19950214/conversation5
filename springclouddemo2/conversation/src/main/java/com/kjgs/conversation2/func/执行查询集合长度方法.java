package com.kjgs.conversation2.func;

import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.Tool查询;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class 执行查询集合长度方法 extends FuncAbstract {
    public 执行查询集合长度方法(){
        后面能否跟内置动作=false;
    }
    @Autowired
    private Tool查询 tool查询;

    public void 功能() {

    }

    @Override
    public void 判断结果是true时执行(){
        boolean 判断结果 = Tool.往前找判断结果(下标);
        if(!判断结果){
            return;
        }
        执行查询集合长度方法();
    }
    public void 执行查询集合长度方法(){
        Document 查询的集合 = Tool.指定下标前面的逻辑成分(下标, "查询的集合");
        if (查询的集合==null){
            return;
        }
        逻辑成分.put("查询集合长度的结果", 查询的集合.size());
    }

}
