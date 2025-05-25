package com.kjgs.conversation2.func2;

import com.kjgs.conversation.mysql.Impl逻辑;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.IngoreException;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class 向 extends FuncAbstract {
    @Autowired
    Impl逻辑 impl逻辑;
    @PostConstruct
    public void init(){
        //加载初始化逻辑语句
        impl逻辑.保存逻辑("《如果》《遇到》《向》《，》《并且》《后面6个字》《是》《后获取某个字》《，》《那就》《把》《当前词》《和》《后面6个字》《合并为》《1》《个词》");
    }

    @Override
    public void 功能() throws IngoreException {

    }
}
