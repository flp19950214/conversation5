package com.kjgs.conversation2;

import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class 组装输出结果 {

    @Autowired
    private 给输入的句子生成内置格式化逻辑 impl给输入的句子生成内置格式化逻辑;

    public Document 输出结果(){
        Document document = new Document();
        document.put("输出内容", 静态引用.输出内容);
        document.put("分词结果", impl给输入的句子生成内置格式化逻辑.生成格式化逻辑(静态引用.输入句子的成分集合));
        return document;
    }
}
