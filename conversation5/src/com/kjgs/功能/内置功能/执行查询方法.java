package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.List;

public class 执行查询方法 extends 功能抽象 {
    public static final String 查询的属性 = "查询的属性";
    public static final String 查询的属性值 = "查询的属性值";
    public static final String 查询的结果= "查询的结果";
    @Override
    public void 功能() {
        String 查询的属性 = 获取最近的属性值(所有逻辑对象, this.查询的属性);
        String 查询的属性值 = 获取最近的属性值(所有逻辑对象, this.查询的属性值);
        Document document = new Document();
        document.put(查询的属性, 查询的属性值);
        List<Document> 查询的结果 = MongoDao.select(document);
        Document  查询的结果对象 =  new Document();
        查询的结果对象.put(this.查询的结果, 查询的结果);
        所有逻辑对象.add(查询的结果对象);
    }
}
