package com.kjgs;

import com.kjgs.工具包.拼接字符串;
import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import org.apache.commons.collections4.CollectionUtils;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.List;

public class 中转逻辑 {
    public static void main(String[] args) {

    }

    //
    public static void 已知逻辑处理未知语句(String 未知语句id,String 未知语句, ObjectId 逻辑id){
        Document 逻辑对象 = new Document();
        逻辑对象.put(Cons.父id, 未知语句id);
        逻辑对象.put(Cons.对象, 拼接字符串.拼接(未知语句, Cons.的, Cons.处理逻辑));//你的处理逻辑
        逻辑对象.put(Cons.值, 逻辑id);
        ObjectId 逻辑对象id = MongoDao.insert(逻辑对象);

        Document 执行逻辑对象 = MongoDao.selectById(逻辑id);

        Document 逻辑对象的待处理对象 = new Document();
        逻辑对象的待处理对象.put(Cons.父id, 逻辑对象id);
        逻辑对象的待处理对象.put(Cons.对象, 拼接字符串.拼接(逻辑id, Cons.的, Cons.待处理对象));//找待处理对象的处理逻辑的待处理对象
        逻辑对象的待处理对象.put(Cons.值, 执行逻辑对象.get(Cons._id));
        ObjectId 逻辑对象的待处理对象id = MongoDao.insert(逻辑对象);
        //找到逻辑对象的 执行逻辑对象
        处理流程.执行逻辑(执行逻辑对象);
    }

}
