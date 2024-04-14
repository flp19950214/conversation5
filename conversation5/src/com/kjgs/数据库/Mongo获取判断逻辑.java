package com.kjgs.数据库;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kjgs.枚举.Cons;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;

public class Mongo获取判断逻辑 extends MongoBaseDao {
    public static final Document sort = new Document(){{put("sort",-1);}};

    @Test
    public void testRegexSelect(){
        JSONObject 查询对象 = new JSONObject();
        查询对象.put(Cons.词性, Cons.反向判断词);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("$regex", "否");
        查询对象.put(Cons.对象,jsonObject);
        System.out.println(正则查询判断逻辑(查询对象));
    }
    public static JSONArray 正则查询判断逻辑(JSONObject 查询对象) {
        MongoClient mc = new MongoClient(host, port);
        //获取库对象
        MongoDatabase db = mc.getDatabase(dbName);
        //获取表对象
        MongoCollection<Document> kjgsDoc = db.getCollection(doc);
        FindIterable<Document> documents = kjgsDoc.find(Document.parse(查询对象.toJSONString())).sort(sort);
        try{
            return resultToJson(documents);
        }finally {
            mc.close();
        }
    }
}
