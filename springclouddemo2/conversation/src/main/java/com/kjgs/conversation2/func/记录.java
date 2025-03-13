package com.kjgs.conversation2.func;

import com.kjgs.conversation.mysql.逻辑Impl;
import com.kjgs.conversation2.FuncAbstract;
import com.kjgs.conversation2.Tool;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class 记录 extends FuncAbstract {

    @Autowired
    private 逻辑Impl 逻辑impl;

    @Override
    public void 功能() {

    }

    @Override
    public void 判断结果是true时执行(){
        boolean 判断结果 = Tool.往前找判断结果(下标);
        if(!判断结果){
            return;
        }
        找到逻辑后面的所有内容记录成逻辑();
    }

    public void 找到逻辑后面的所有内容记录成逻辑(){
        String 逻辑后面的内容 = 逻辑句子.substring(结束下标);
        // 如果遇到当前词、这个词就替换成
//        逻辑后面的内容 = 逻辑后面的内容.replaceAll("当前词",句子词语);
        逻辑后面的内容 = 逻辑后面的内容.replaceAll("这个词",句子词语);
        //保持逻辑
        逻辑impl.保存逻辑(逻辑后面的内容);
    }
}
