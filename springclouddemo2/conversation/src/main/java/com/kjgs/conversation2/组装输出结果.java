package com.kjgs.conversation2;

import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class 组装输出结果 {

    @Autowired
    private 给输入的句子生成内置格式化逻辑 impl给输入的句子生成内置格式化逻辑;

    public Document 输出结果() {
        Document document = new Document();
        document.put("输出内容", 静态引用.输出内容);
        document.put("分词结果", impl给输入的句子生成内置格式化逻辑.生成格式化逻辑(静态引用.输入句子的成分集合));
        Document 集合中包含某属性的最后一个对象 = Tool.获取集合中包含某属性的最后一个对象(静态引用.输入句子的成分集合, Cons.是否是输出动作);
        if ( 集合中包含某属性的最后一个对象!= null) {
            Object 更新某某的处理逻辑 = 集合中包含某属性的最后一个对象.get(Cons.是否是输出动作);
            Document 处理过程 = 集合中包含某属性的最后一个对象.get(更新某某的处理逻辑.toString(), Document.class);

            document.put(Cons.处理过程, 处理过程);
        }
        return document;
    }
}
