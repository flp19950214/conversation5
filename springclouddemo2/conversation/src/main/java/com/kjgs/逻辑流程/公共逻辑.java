package com.kjgs.逻辑流程;

import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 公共逻辑 {
    private  final static String 公共逻辑 = "公共逻辑";
    @Autowired
    private 执行逻辑 执行逻辑;
    @Test
    public void 公共逻辑test(){
        Document 待处理对象所在句子 = new Document();
        待处理对象所在句子.put(Cons.待处理对象所在句子, "如果");
        执行逻辑.所有逻辑对象.add(待处理对象所在句子);
        Document 待处理的对象值 = new Document();
        待处理的对象值.put(Cons.待处理的对象, "如");
        执行逻辑.所有逻辑对象.add(待处理的对象值);
        执行所有公共逻辑();
    }

    public void 执行所有公共逻辑(){
        //执行所有公共逻辑
        List<Document> select = MongoDao.select(Cons.对象, 公共逻辑);
        for(Document document : select){
            执行逻辑.执行逻辑(document);
        }
    }


    @Test
    public void test2(){
        Document document = new Document();
        document.put(Cons.对象,"公共逻辑");
        document.put(Cons.处理逻辑,"￥{查询这个词的类型}"); //有点公共逻辑 没有条件 直接执行即可
        MongoDao.insert(document);
    }


}
