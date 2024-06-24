package com.kjgs;

import com.kjgs.功能.功能抽象;
import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.junit.Test;

import java.util.List;

/**
 * 最重要的是：
 * 保存和更新逻辑：保存且不说，更新是要根据前面的语句判断出要更新的数据id, 然后再更新，具有可行性
 *
 * 保存逻辑的存储方式：就和对象放一起
 */
public class 执行当前词语相关逻辑 {

    @Test
    public void test2(){
        String sen = "3加2是什么";
        for (int i = 0; i < sen.length()-1; i++) {
            method( sen.substring(i,i+1));
        }
    }

    public static void method() {
    }

    public static void method(String 待处理词语){
        Document 查询逻辑条件 = new Document();
        查询逻辑条件.put(Cons.对象,待处理词语);
        Document 查询逻辑条件2 = new Document();
        查询逻辑条件2.put("$exists", true);
        查询逻辑条件.put(Cons.处理逻辑, 查询逻辑条件2);
        List<Document> select = MongoDao.select(查询逻辑条件);
        for (int j = 0; j <select.size() ; j++) {
            String 判断条件1的正向结果 = select.get(j).getString(Cons.处理逻辑的判断条件);
            执行逻辑.执行逻辑(判断条件1的正向结果, null);
        }
    }
}
