package com.kjgs.数据库;

import com.kjgs.枚举.Cons;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.junit.Test;

import java.util.List;

public class Mongo获取判断逻辑 extends MongoBaseDao {
    public static final Document sort = new Document(){{put("sort",-1);}};

    @Test
    public void testRegexSelect(){
        Document 查询对象 = new Document();
        查询对象.put(Cons.词性, Cons.反向判断词);
        Document jsonObject = new Document();
        jsonObject.put("$regex", "否");
        查询对象.put(Cons.对象,jsonObject);
        System.out.println(正则查询判断逻辑(查询对象));
    }
    public static List<Document> 正则查询判断逻辑(String input) {
        Document 查询对象 = new Document();
        查询对象.put(Cons.在上级对象中的成分, Cons.判断条件);
        Document jsonObject = new Document();
        jsonObject.put("$regex", input);
        查询对象.put(Cons.对象,jsonObject);
        return 正则查询判断逻辑(查询对象);
    }
    public static List<Document> 正则查询判断逻辑(Document 查询对象) {
        MongoCollection<Document> kjgsDoc = MongoPool.getMongoPool().getDefaultCollection();
        FindIterable<Document> documents = kjgsDoc.find(查询对象).sort(sort);
        return resultToJson(documents);

    }
}
