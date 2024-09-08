package com.kjgs.数据库;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.List;

public class Mongo词语在句子中 extends MongoBaseDao {
    public static void main(String[] args) {
        String 查询字段 = "词性";
        String 查询条件 = "2如果假设词34什么234";
        System.out.println(查询在句子中的(查询字段, 查询条件));
    }

    /** 查询词性 */
    public static List<Document> 查询在句子中的(String 查询字段, String 查询条件){
        MongoCollection<Document> kjgsDoc = MongoPool.getMongoPool().getDefaultCollection();
        JSONObject jsonObject1 = new JSONObject();
        // 创建函数的JavaScript代码
        String functionBody = "function() { var queryValues = \""+查询条件+"\";" +
                "var index = queryValues.indexOf(this."+查询字段+");"+
                "return index !== -1;}";
        jsonObject1.put("$where", functionBody);
        FindIterable<Document> documents = kjgsDoc.find(Document.parse(jsonObject1.toJSONString()));
        return resultToJson(documents);
    }
}
