package com.kjgs.常用语句;

import com.kjgs.执行逻辑;
import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.junit.Test;

public class 判断是否有新的待处理对象 {
    /**
     * 判断条件和判断结果要分开处理     */
    String 判断是否有新的待处理对象 = //下标和内容一样就不是新对象
            "查询的属性《是》待处理的对象\n《执行查询指定属性方法》" +
                    "\n查询的集合《是》￥{查询的结果}\n《执行查询集合长度方法》"+
                    "\n被减数《是》￥{查询的结果}\n减数《是》2\n《执行减法方法》"+
                    "\n查询的集合《是》￥{查询指定属性的结果}\n查询的下标《是》￥{相减的结果}\n《执行查询集合指定下标方法》"+
                    "\n被判断的对象《是》￥{待处理的对象}\n判断的对象《是》￥{查询的结果}\n《执行判断等于方法》"+
                    "\n输出的内容《是》￥{判断的结果}\n《执行输出方法》";
    @Test
    public void test(){
        Document 待处理的对象值 = new Document();
        待处理的对象值.put(Cons.待处理的对象, "24");
        执行逻辑.所有逻辑对象.add(待处理的对象值);

        执行逻辑.执行逻辑(判断是否有新的待处理对象, "24");
    }

    @Test
    public void test2(){
        Document document = new Document();
        document.put(Cons.对象,"判断是否有新的待处理对象");
        document.put(Cons.处理逻辑,判断是否有新的待处理对象);
        MongoDao.insert(document);
    }
}
