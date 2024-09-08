package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.数据库.MongoDao;
import org.bson.Document;

public class 执行更新方法 extends 功能抽象 {
    public static final String 更新的主键 = "更新的主键";
    public static final String 更新的属性 = "更新的属性";
    public static final String 更新的属性值 = "更新的属性值";
    @Override
    public void 功能() {
        String 更新的主键 = 获取最近的属性值(所有逻辑对象, this.更新的主键);
        String 更新的属性 = 获取最近的属性值(所有逻辑对象, this.更新的属性);
        String 更新的属性值 = 获取最近的属性值(所有逻辑对象, this.更新的属性值);
        Document document = new Document();
        document.put(更新的属性, 更新的属性值);
        MongoDao.update(更新的主键, document);
    }
}
