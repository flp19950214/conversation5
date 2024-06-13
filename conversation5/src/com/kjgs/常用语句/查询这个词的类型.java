package com.kjgs.常用语句;

import com.kjgs.功能.功能抽象;
import com.kjgs.执行逻辑;
import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import com.mongodb.Mongo;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 查询这个词的类型 {
    /**
     * 判断条件和判断结果要分开处理     */
    String 查询这个词的类型 = "查询的属性《是》对象\n查询的属性值《是》2\n《执行查询方法》" +
            "\n查询的对象《是》￥{查询的结果}\n查询的属性《是》类型\n《执行查询集合对象指定属性值方法》" +
            "\n过滤的对象《是》￥{查询的结果}\n过滤的下标《是》0\n《执行过滤指定下标方法》"+
            "\n输出的内容《是》￥{过滤的结果}\n《执行输出方法》";
    String 查询这个词的类型2 = "查询的属性《是》对象\n查询的属性值《是》￥{待处理的对象}\n《执行查询方法》" +
            "\n查询的对象《是》￥{查询的结果}\n查询的属性《是》类型\n《执行查询集合对象指定属性值方法》" +
            "\n过滤的对象《是》￥{查询的结果}\n过滤的下标《是》0\n《执行过滤指定下标方法》"+
            "\n输出的内容《是》￥{过滤的结果}\n《执行输出方法》";
    @Test
    public void insert(){
        Document document = new Document();
        document.put(Cons.对象, "查询这个词的类型");
        document.put(Cons.处理逻辑, 查询这个词的类型2);
        MongoDao.insert(document);
    }
    @Test
    public void test(){
        执行逻辑.执行逻辑(查询这个词的类型2, "2");
    }
}
