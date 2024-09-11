package com.kjgs.逻辑流程;

import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 最重要的是：
 * 保存和更新逻辑：保存且不说，更新是要根据前面的语句判断出要更新的数据id, 然后再更新，具有可行性
 *
 * 保存逻辑的存储方式：就和对象放一起
 */
@Service
public class 执行判断逻辑 {
    @Autowired
    private 执行逻辑 执行逻辑;
    //
    public static String dd= "查询的对象《是》￥{待处理的对象}\n查询的开始下标《是》1\n查询的结束下标《是》2\n《执行查询对象指定下标方法》"+
            "\n输出的内容《是》￥{查询的结果}\n《执行输出方法》";

    @Test
    public void test2(){
        String sen = "如果遇到如果，添加一个开始判断的语境";
        for (int i = 0; i < sen.length()-1; i++) {
            Document 查询逻辑条件 = new Document();
            查询逻辑条件.put(Cons.对象, sen.substring(i,i+1));
            Document 查询逻辑条件2 = new Document();
            查询逻辑条件2.put("$exists", true);
            查询逻辑条件.put(Cons.处理逻辑, 查询逻辑条件2);
            List<Document> select = MongoDao.select(查询逻辑条件);
            for (int j = 0; j <select.size() ; j++) {
                执行逻辑.执行逻辑(select.get(j));
            }
        }
    }
}
