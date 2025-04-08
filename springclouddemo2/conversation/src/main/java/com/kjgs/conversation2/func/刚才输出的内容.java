package com.kjgs.conversation2.func;

import com.kjgs.conversation.mysql.Impl数据;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.Tool查询;
import com.kjgs.conversation2.model.Model数据;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class 刚才输出的内容 extends FuncAbstract {

    @Autowired
    private Impl数据 impl数据;

    public void 功能() {

    }

    @Override
    public void 判断结果是true时执行(){
        boolean 判断结果 = Tool.往前找判断结果(下标);
        if(!判断结果){
            return;
        }
        执行查询名词指向方法();
    }
    public void 执行查询名词指向方法(){
        Document 查询数据表单个目标 = impl数据.查询上一个输出对象();
        if(查询数据表单个目标 == null){
            return;
        }
//        逻辑成分.put(Cons.指向, 查询数据表单个目标);
        逻辑成分.put(Cons.指向, 查询数据表单个目标);
        逻辑成分.put(Cons.数据表指向, 查询数据表单个目标);
    }

}
