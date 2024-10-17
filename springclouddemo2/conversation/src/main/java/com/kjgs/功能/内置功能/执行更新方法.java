package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class 执行更新方法 extends 功能抽象 {
    public static final String 更新的主键 = "更新的主键";
    public static final String 更新的属性 = "更新的属性";
    public static final String 更新的属性值 = "更新的属性值";
    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(更新的主键).set参数名2(更新的属性).set参数名3(更新的属性值);
        异步初始化类.初始化记录内置功能属性(obj);
    }
    @Override
    public void 功能() {
        String 更新的主键 = 获取最近的属性值(所有逻辑对象, this.更新的主键);
        String 更新的属性 = 获取最近的属性值(所有逻辑对象, this.更新的属性);
        String 更新的属性值 = 获取最近的属性值(所有逻辑对象, this.更新的属性值);
        Document document = new Document();
        document.put(更新的属性, 更新的属性值);
        document.put(Cons.level,level);
        MongoDao.update(更新的主键, document);
    }
}
