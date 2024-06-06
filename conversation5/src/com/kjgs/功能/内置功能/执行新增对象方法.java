package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.执行逻辑;
import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.bson.types.ObjectId;

public class 执行新增对象方法 extends 功能抽象 {
    public static final String 新增的属性 = "新增的属性";
    public static final String 新增的属性值 = "新增的属性值";
    @Override
    public void 功能() {
        String 新增的属性 = 获取最近的属性值(所有逻辑对象, this.新增的属性);
        String 新增的属性值 = 获取最近的属性值(所有逻辑对象, this.新增的属性值);
        Document document = new Document();
        document.put(新增的属性, 新增的属性值);
        执行逻辑.所有逻辑对象.add(document);
    }
}
