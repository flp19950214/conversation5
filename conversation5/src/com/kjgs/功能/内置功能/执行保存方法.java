package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.bson.types.ObjectId;

public class 执行保存方法 extends 功能抽象 {
    public static final String 保存的对象 = "保存的对象";
    public static final String 保存的属性 = "保存的属性";
    public static final String 保存的属性值 = "保存的属性值";
    @Override
    public void 功能() {
        String 保存的对象 = 获取最近的属性值(所有逻辑对象, this.保存的对象);
        String 保存的属性 = 获取最近的属性值(所有逻辑对象, this.保存的属性);
        String 保存的属性值 = 获取最近的属性值(所有逻辑对象, this.保存的属性值);
        Document document = new Document();
        document.put(Cons.主键, new ObjectId());
        document.put(Cons.对象, 保存的对象);
        document.put(保存的属性, 保存的属性值);
        MongoDao.insert(document);
    }
}
