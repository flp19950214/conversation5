package com.kjgs.常用语句;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.逻辑实体;
import com.kjgs.常用语句.抽象.逻辑抽象;
import com.kjgs.逻辑流程.执行逻辑;
import org.bson.Document;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class 判断当前词语能否与后面的词组成词组 extends 逻辑抽象 {
    @Autowired
    private 执行逻辑 执行逻辑;
    /**
     * 判断条件和判断结果要分开处理
     **/
    String 判断当前词语能否与后面的词组成词组 =
            "《合并下一个词》"+
            "\n查询的属性《是》对象\n查询的属性值《是》￥{追加的结果}\n《执行查询方法》"+
            "\n被判断的对象《是》￥{查询的结果}\n《执行判断集合是否为空方法》"+
            "\n输出的内容《是》￥{判断的结果}\n《执行输出方法》";
    @Test
    public void test(){
        Document document = new Document();
        document.put("待处理对象所在的句子", "如果");
        执行逻辑.所有逻辑对象.add(document);
        Document document2 = new Document();
        document2.put("待处理对象在句子中的下标", 0);
        执行逻辑.所有逻辑对象.add(document2);
    }

    @Override
    public void 初始化记录常用逻辑() {
        逻辑实体 obj = new 逻辑实体();
        obj.set逻辑名(功能抽象.getClasName()).set逻辑(判断当前词语能否与后面的词组成词组);
        异步初始化类.初始化记录内置功能属性(obj);
    }
}
