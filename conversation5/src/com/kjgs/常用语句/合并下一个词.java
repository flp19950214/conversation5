package com.kjgs.常用语句;

import com.kjgs.执行逻辑;
import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.junit.Test;

public class 合并下一个词 {
    /**
     * 判断条件和判断结果要分开处理
     **/
    String 合并下一个词 =
            "被加数《是》￥{待处理对象在句子中的下标}\n加数《是》1\n《执行加法方法》"+
            "\n查询的对象《是》￥{待处理对象所在的句子}\n查询的下标《是》￥{相加的结果}\n《执行获取指定下标值方法》" +
            "\n被追加的对象《是》￥{待处理的对象}\n追加的对象《是》￥{查询的结果}\n《执行追加方法》"+
             "\n输出的内容《是》￥{追加的结果}\n《执行输出方法》";
    @Test
    public void test(){
        Document document = new Document();
        document.put("待处理对象所在的句子", "如果");
        执行逻辑.所有逻辑对象.add(document);
        Document document2 = new Document();
        document2.put("待处理对象在句子中的下标", 0);
        执行逻辑.所有逻辑对象.add(document2);
        执行逻辑.执行逻辑(合并下一个词, "如");
    }

    @Test
    public void test2(){
        Document document = new Document();
        document.put(Cons.对象,"合并下一个词");
        document.put(Cons.处理逻辑,合并下一个词);
        MongoDao.insert(document);
    }
}
