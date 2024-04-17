package com.kjgs.数据库;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoPool extends MongoBaseDao{
    private MongoClient mongoClient = null;
    private static final MongoPool mongoPool = new MongoPool();// 饿汉式单例模式
    private MongoPool()
    {
        if (mongoClient == null)
        {
            MongoClientOptions.Builder buide = new MongoClientOptions.Builder();
            buide.connectionsPerHost(100);// 与目标数据库可以建立的最大链接数
            buide.connectTimeout(1000 * 60 * 20);// 与数据库建立链接的超时时间
            buide.maxWaitTime(100 * 60 * 5);// 一个线程成功获取到一个可用数据库之前的最大等待时间
            buide.threadsAllowedToBlockForConnectionMultiplier(100);
            buide.maxConnectionIdleTime(0);
            buide.maxConnectionLifeTime(0);
            buide.socketTimeout(0);
            buide.socketKeepAlive(true);
            MongoClientOptions myOptions = buide.build();
            mongoClient = new MongoClient(new ServerAddress(host, port), myOptions);
        }
    }
    public static MongoPool getMongoPool()
    {
        return mongoPool;
    }

    public MongoDatabase getDb(String dbName)
    {
        return mongoClient.getDatabase(dbName);
    }

    public MongoCollection<Document> getCollection(String dbName, String collectionName)
    {
        MongoDatabase db = mongoClient.getDatabase(dbName);
        return db.getCollection(collectionName);
    }

    public static MongoCollection<Document> getDefaultCollection(){
        return getMongoPool().getCollection(dbName, doc);
    }


    public static void main(String[] args) {
        //获取表对象
        MongoCollection<Document> kjgsDoc = MongoPool.getMongoPool().getDefaultCollection();
        JSONObject jsonObject = new JSONObject(){{put("对象","如果");}};
        FindIterable<Document> documents = kjgsDoc.find(Document.parse(jsonObject.toJSONString()));
        JSONArray jsonArray = resultToJson(documents);
        System.out.println(jsonArray.toJSONString());
    }
}
