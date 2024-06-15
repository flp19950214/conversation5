package com.kjgs.常用词语;

import com.kjgs.执行逻辑;
import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import com.mongodb.Mongo;
import org.bson.Document;
import org.junit.Test;

public class 如 {
    //给待处理对象加个是否开始处于判断
    String 查询这个词的类型2 = "更新的对象《是》￥{待处理的对象}\n更新的属性《是》是否处于判断语境\n更新的属性值《是》是\n《执行更新对象属性方法》";
    @Test
    public void test(){
        执行逻辑.执行逻辑(查询这个词的类型2, Cons.如果);
    }
    @Test
    public void test2(){
        Document document = new Document();
        document.put(Cons.对象,"公共逻辑");
        document.put(Cons.处理逻辑+1+Cons.的+Cons.判断条件,"￥{判断当前词语能否与后面的词组成词组}");
        document.put(Cons.处理逻辑+1,"￥{与后面的词合并，生成新的词组}");
        MongoDao.insert(document);
    }
}
