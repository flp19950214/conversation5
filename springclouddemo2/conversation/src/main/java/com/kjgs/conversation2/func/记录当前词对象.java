package com.kjgs.conversation2.func;

import com.kjgs.conversation.mysql.Impl数据;
import com.kjgs.conversation.mysql.Impl逻辑;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class 记录当前词对象 extends FuncAbstract {
    public 记录当前词对象(){
        后面能否跟内置动作=false;
    }
    @Autowired
    private Impl逻辑 逻辑impl;
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
        记录当前词对象();
    }

    public void 记录当前词对象(){
        impl数据.保存数据对象(句子成分);
    }
}
