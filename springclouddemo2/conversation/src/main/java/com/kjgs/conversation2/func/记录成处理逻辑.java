package com.kjgs.conversation2.func;

import com.kjgs.conversation.mysql.mapper.逻辑Mapper;
import com.kjgs.conversation.mysql.逻辑Impl;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class 记录成处理逻辑 extends FuncAbstract {

    @Autowired
    private 逻辑Impl 逻辑impl;

    @Override
    public void 功能() {
        找到前面一个成分保存成逻辑();
    }
    public void 找到前面一个成分保存成逻辑(){
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        if(指定下标前面的逻辑成分 == null){
            return;
        }
        if(StringUtils.isEmpty(指定下标前面的逻辑成分.getString(Cons.词语))){
            return;
        }
        逻辑impl.保存逻辑(指定下标前面的逻辑成分.getString(Cons.词语));
    }
}
