package com.kjgs.conversation2.func;

import com.kjgs.conversation.mysql.Impl逻辑;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class 添加为 extends FuncAbstract {

    @Autowired
    private Impl逻辑 逻辑impl;

    @Override
    public void 功能() {
        后面一个成分是句子的成分();
    }

    //保存前面一个成分为输入句子的成分
    public void 后面一个成分是句子的成分(){
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);

    }
}
