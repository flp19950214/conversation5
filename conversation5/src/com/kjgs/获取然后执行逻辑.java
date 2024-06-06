package com.kjgs;

import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.junit.Test;

import java.util.List;

public class 获取然后执行逻辑 {


    @Test
    public void test2(){
        String sen = "3加2是什么";
        for (int i = 0; i < sen.length()-1; i++) {
            Document 查询逻辑条件 = new Document();
            查询逻辑条件.put(Cons.对象, sen.substring(i,i+1));
            Document 查询逻辑条件2 = new Document();
            查询逻辑条件2.put("$exists", true);
            查询逻辑条件.put(Cons.判断条件1, 查询逻辑条件2);
            List<Document> select = MongoDao.select(查询逻辑条件);
            for (int j = 0; j <select.size() ; j++) {
                String 判断条件1的正向结果 = select.get(j).getString("判断条件1的正向结果");
                执行逻辑.执行逻辑(判断条件1的正向结果, null);
            }

        }

    }
}
