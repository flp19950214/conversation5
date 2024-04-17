package com.kjgs.数据库;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.Test;

import java.util.Map;

public class MongoDao extends MongoBaseDao {

    public static final Document sort = new Document(){{put("sort",-1);}};

    public static void main(String[] args) {
        MongoClient mc = new MongoClient(host, port);
        //获取库对象
        MongoDatabase db = mc.getDatabase(dbName);
        //获取库中表的集合
        MongoIterable<String> iterable = db.listCollectionNames();
        MongoCursor<String> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            System.out.println("wod");
        }
        mc.close();
    }


    public static void insert(Map jsonObject){
        insert(JSON.parseObject(JSON.toJSONString(jsonObject)));
    }
    public static void insert(JSONObject jsonObject){
        MongoCollection<Document> kjgsDoc = MongoPool.getMongoPool().getDefaultCollection();
        kjgsDoc.insertOne(Document.parse(jsonObject.toJSONString()));
    }

    @Test
    public void testSelect(){
        System.out.println(select(new JSONObject(){{put("词语","如果");}}));
    }
    public static JSONArray select(Map jsonObject){
       return select(JSON.parseObject(JSON.toJSONString(jsonObject)));
    }
    public static JSONArray select(String key, Object value){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key, value);
       return select(jsonObject);
    }
    public static JSONArray select(JSONObject jsonObject){
        MongoCollection<Document> kjgsDoc = MongoPool.getMongoPool().getDefaultCollection();
        FindIterable<Document> documents = kjgsDoc.find(Document.parse(jsonObject.toJSONString())).sort(sort);
        return resultToJson(documents);
    }


    @Test
    public void testRegexSelect(){
        System.out.println(regexSelect("sen","陈述句2"));
    }
    public static JSONArray regexSelect(String key, Object value) {
        MongoCollection<Document> kjgsDoc = MongoPool.getMongoPool().getDefaultCollection();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("$regex", value);
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put(key, jsonObject);
        FindIterable<Document> documents = kjgsDoc.find(Document.parse(jsonObject2.toJSONString())).sort(sort);
        return resultToJson(documents);
    }
    @Test
    public void test_update(){

    }
    public static void update(String _id, Map jsonObject) {
        update(_id, JSONObject.parseObject(JSON.toJSONString(jsonObject)));
    }
    // 只根据id更新
    public static void update(String _id, JSONObject jsonObject) {
        MongoCollection<Document> kjgsDoc = MongoPool.getMongoPool().getDefaultCollection();
        ObjectId objectId = new ObjectId(_id);
        Document searchSingle = new Document("_id", objectId);
        Document updateSingle = new Document("$set", Document.parse(jsonObject.toJSONString()));
        kjgsDoc.updateOne(searchSingle, updateSingle);

    }

}
