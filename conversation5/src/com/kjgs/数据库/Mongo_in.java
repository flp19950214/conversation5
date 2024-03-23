package com.kjgs.数据库;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据多个or查询
 */
public class Mongo_in extends MongoDao {
    public static void main(String[] args) {
        String 查询字段 = "词语";
        List<String> 查询集合 = new ArrayList(){{
           add("是");
           add("的");
        }};
        System.out.println(查询在集合中的(查询字段, 查询集合));
    }

    /** 查询词性 */
    public static JSONArray 查询在集合中的(String 查询字段,List<String> 查询集合){
        // 排除objectid
        MongoClient mc = new MongoClient(host, port);
        //获取库对象
        MongoDatabase db = mc.getDatabase(dbName);
        //获取表对象
        MongoCollection<Document> kjgsDoc = db.getCollection(doc);
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("$in", 查询集合);
        jsonObject.put(查询字段, jsonObject1);
        FindIterable<Document> documents = kjgsDoc.find(Document.parse(jsonObject.toJSONString()));
        try{
            return resultToJson(documents);
        }finally {
            mc.close();
        }
    }
}
