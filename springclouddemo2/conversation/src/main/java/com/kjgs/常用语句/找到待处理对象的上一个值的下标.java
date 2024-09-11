package com.kjgs.常用语句;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.逻辑实体;
import com.kjgs.常用语句.抽象.逻辑抽象;
import com.kjgs.逻辑流程.执行逻辑;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class 找到待处理对象的上一个值的下标 extends 逻辑抽象 {
    @Autowired
    private 执行逻辑 执行逻辑;
    /**
     * 判断条件和判断结果要分开处理     */
    public static final String 找到待处理对象的上一个值的下标 =
            "\n查询的属性《是》待处理的对象的下标\n《执行查询指定属性方法》" +
                    "\n查询的集合《是》￥{查询的结果}\n《执行查询集合长度方法》"+
                    "\n被减数《是》￥{查询的结果}\n减数《是》2\n《执行减法方法》"+
                    "\n查询的集合《是》￥{查询指定属性的结果}\n查询的下标《是》￥{相减的结果}\n《执行查询集合指定下标方法》"+
              "\n输出的内容《是》￥{查询的结果}\n《执行输出方法》";


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

        执行逻辑.执行逻辑(找到待处理对象的上一个值的下标, "23");
    }


    @Override
    public void 初始化记录常用逻辑() {
        逻辑实体 obj = new 逻辑实体();
        obj.set逻辑名(功能抽象.getClasName()).set逻辑(找到待处理对象的上一个值的下标);
        异步初始化类.初始化记录内置功能属性(obj);
    }
}
