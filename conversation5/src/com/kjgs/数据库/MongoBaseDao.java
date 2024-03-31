package com.kjgs.数据库;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

public abstract class MongoBaseDao {

    public static final String host = "localhost";
    public static final int port = 27017;
    public static final String dbName = "kjgs2";
    public static final String doc = "kjgsDoc";
    public static JSONArray resultToJson(MongoIterable<Document> documents){
        JSONArray jsonArray =new JSONArray();
        for(Document doc:documents){
            jsonArray.add(JSON.parse(doc.toJson()));
        }
        return jsonArray;
    }

}
