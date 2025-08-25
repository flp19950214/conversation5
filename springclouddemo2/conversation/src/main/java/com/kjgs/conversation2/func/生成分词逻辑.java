package com.kjgs.conversation2.func;

import com.kjgs.conversation.mysql.mapper.逻辑Mapper;
import com.kjgs.conversation2.*;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class 生成分词逻辑  extends FuncAbstract {

    @Autowired
    private 逻辑Mapper impl逻辑Mapper;

    @Autowired
    给输入的句子生成内置格式化逻辑 impl给输入的句子生成内置格式化逻辑;

    @Override
    public void 功能() throws IngoreException {
    }

    @Override
    public void 判断结果是true时执行(){
        boolean 判断结果 = Tool.往前找判断结果(下标);
        if(!判断结果){
            return;
        }
        生成逻辑();
    }


    public void 生成逻辑(){
        Document 指定下标前面的逻辑成分 = Tool.指定下标前面的逻辑成分(下标);
        Object 分词 = 指定下标前面的逻辑成分.get(Cons.词语);
        if(!(分词 instanceof String)){
            return;
        }
        if(分词.toString().length() < 2){
            return;
        }
        String 锚点词 = 分词.toString().substring(0,1);
        String 后续词 = 分词.toString().substring(1);
        String 逻辑 = String.format(Cons.分词逻辑format,锚点词, 后续词.length(), 后续词, 后续词.length());
        System.out.println("生成逻辑：" + 逻辑);
        impl给输入的句子生成内置格式化逻辑.保持并刷新逻辑(逻辑);
    }
}
