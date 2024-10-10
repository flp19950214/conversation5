package com.kjgs.常用语句;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.逻辑实体;
import com.kjgs.常用语句.抽象.逻辑抽象;
import com.kjgs.逻辑流程.执行逻辑;
import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class 判断是否有新的待处理对象 extends 逻辑抽象 {
    @Autowired
    private 执行逻辑 执行逻辑;
    /**
     * 判断条件和判断结果要分开处理     */
    public static String 判断是否有新的待处理对象 = //下标和内容一样就不是新对象
            找到待处理对象的上一个值.找到待处理对象的上一个值+
                    找到待处理对象的上一个值的下标.找到待处理对象的上一个值的下标+
                    "\n被判断的对象《是》￥{查询的结果}" +
                    "\n判断的对象《是》￥{待处理的对象的下标}\n《执行判断等于方法》"+
                    "\n《执行判断并且方法》"+
                    "\n输出的内容《是》￥{判断的结果}\n《执行输出方法》";
    @Test
    public void test(){
        Document 待处理的对象值 = new Document();
        待处理的对象值.put(Cons.待处理的对象, "24");
        执行逻辑.所有逻辑对象.add(待处理的对象值);
        Document 待处理的对象的下标 = new Document();
        待处理的对象的下标.put(Cons.待处理的对象的下标, 1);
        执行逻辑.所有逻辑对象.add(待处理的对象的下标);
        Document 待处理的对象的下标2 = new Document();
        待处理的对象的下标2.put(Cons.待处理的对象的下标, 1);
        执行逻辑.所有逻辑对象.add(待处理的对象的下标2);

    }
    @Override
    public void 初始化记录常用逻辑() {
        逻辑实体 obj = new 逻辑实体();
        obj.set逻辑名(功能抽象.getClasName()).set逻辑(判断是否有新的待处理对象);
        异步初始化类.初始化记录内置功能属性(obj);
    }
    @Test
    public void test2(){
        Document document = new Document();
        document.put(Cons.对象,"判断是否有新的待处理对象");
        document.put(Cons.处理逻辑,判断是否有新的待处理对象);
        MongoDao.insert(document);
    }
}
