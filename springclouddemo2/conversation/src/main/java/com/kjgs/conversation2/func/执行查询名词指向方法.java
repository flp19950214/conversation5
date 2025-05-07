package com.kjgs.conversation2.func;

import com.kjgs.conversation.mysql.Impl数据;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.conversation2.Tool查询;
import com.kjgs.conversation2.model.Model数据;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 执行查询名词指向方法 extends FuncAbstract {
    public 执行查询名词指向方法(){
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
        执行查询名词指向方法();
    }
    public void 执行查询名词指向方法(){
        Document 查询数据表单个目标 = tool查询.查询数据表单个目标(句子成分);
        if(查询数据表单个目标 == null){
            return;
        }
        Document 新成分 = Tool.复制对象(句子成分);
        新成分.putAll(查询数据表单个目标);
//        逻辑成分.put(Cons.指向, 查询数据表单个目标);
        句子成分.put(Cons.指向, 新成分);
        句子成分.put(Cons.数据表指向, 新成分);
    }

}
