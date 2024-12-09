package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能对象;
import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.枚举.Cons;
import com.kjgs.逻辑流程.执行逻辑;
import com.kjgs.静态变量;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class 执行添加当前词语为句子成分方法 extends 功能抽象 {
    @Autowired
    private 执行逻辑 执行逻辑;
    @Autowired
    private 功能对象 功能对象Impl;
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName());
        异步初始化类.初始化记录内置功能属性(obj);
    }
    public void 功能(){
        Document 当前处理的词语对象 = 功能对象Impl.获取最近的对象(执行逻辑.所有逻辑对象, Cons.当前处理的词语);
        String 词语 = (String) 功能对象Impl.获取最近的属性值NoLevel(执行逻辑.所有逻辑对象, Cons.当前处理的词语);
        String 当前处理的词语位置 =功能对象Impl.获取最近的属性值NoLevel(执行逻辑.所有逻辑对象, Cons.当前处理的词语位置)+"";
        String 当前处理的词语结束位置 =功能对象Impl.获取最近的属性值NoLevel(执行逻辑.所有逻辑对象, Cons.当前处理的词语结束位置)+"";
        //添加去重功能 词语 开始未知 结束位置一样就是一个成分
        Document 成分对象 = 成分句子去重(词语, 当前处理的词语位置, 当前处理的词语结束位置);
        if(成分对象==null){
            成分对象 = new Document();
            for(Map.Entry entry:当前处理的词语对象.entrySet()){
                成分对象.put(entry.getKey().toString(), entry.getValue());
            }
            成分对象.put(Cons._id, new ObjectId());
            成分对象.put(Cons.词语,  词语);
            成分对象.put(Cons.对象类型, Cons.句子成分);
            成分对象.put(Cons.在句子中的下标,  当前处理的词语位置);
            成分对象.put(Cons.在句子中的结束下标,  当前处理的词语结束位置);
            成分对象.put(Cons.uuidLevel,uuidLevel);
            成分对象.put(Cons.level,level);
            静态变量.添加执行层级集合(String.format("%s %s", level, " 添加的词语："+词语));
            静态变量.添加执行层级集合(String.format("%s %s", level, " 添加的词语位置："+当前处理的词语位置));
            静态变量.添加执行层级集合(String.format("%s %s", level, " 添加的词语结束位置："+当前处理的词语结束位置));
            所有逻辑对象.add(成分对象);
        }
//        Document 当前处理的句子成分 =(Document)获取最近的属性值(所有逻辑对象, Cons.当前处理的句子成分, Document.class);
        Document 当前处理的句子成分 = new Document();
        当前处理的句子成分.put(Cons.当前处理的句子成分,  成分对象);
        所有逻辑对象.add(当前处理的句子成分);


    }

    public Document 成分句子去重(String 词语, String 当前处理的词语位置,String 当前处理的词语结束位置){

        return (Document)所有逻辑对象.stream()
                .filter(m -> StringUtils.equals(((Document) m).getString(Cons.对象类型), Cons.句子成分))
                .filter(m -> StringUtils.equals(((Document) m).getString(Cons.词语), 词语))
                .filter(m -> StringUtils.equals(((Document) m).getString(Cons.在句子中的下标), 当前处理的词语位置))
                .filter(m -> StringUtils.equals(((Document) m).getString(Cons.在句子中的结束下标), 当前处理的词语结束位置))
                .findFirst().orElse(null);
    }
}
