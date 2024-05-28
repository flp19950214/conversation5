package com.kjgs.功能;

import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import com.mongodb.Mongo;
import org.bson.Document;
import org.junit.Test;

public class 初始化录入功能 {

    @Test
    public void 包含() {
        Document 功能对象 = new Document();
        功能对象.put(Cons.对象, Cons.包含);
        MongoDao.select(功能对象);
    }
    @Test
    public void 找() {
        Document 功能对象 = new Document();
        功能对象.put(Cons.对象, Cons.找);
        MongoDao.select(功能对象);
    }
    @Test
    public void 是() {
        Document 功能对象 = new Document();
        功能对象.put(Cons.对象, Cons.是);
        MongoDao.select(功能对象);
    }
    @Test
    public void 的() {
        Document 功能对象 = new Document();
        功能对象.put(Cons.对象, Cons.的);
        MongoDao.select(功能对象);
    }
    @Test
    public void 输出() {
        Document 功能对象 = new Document();
        功能对象.put(Cons.对象, Cons.输出);
        MongoDao.select(功能对象);
    }

}
