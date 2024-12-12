package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.实体.内置功能实体;
import com.kjgs.数据库.MongoCRUDDao;
import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import com.kjgs.线程池.异步_初始化记录内置功能属性;
import com.kjgs.静态变量;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class 执行入库方法 extends 功能抽象 {
    public static final String 保存的对象 = "保存的对象";
    public static final String 保存的属性 = "保存的属性";
    public static final String 保存的属性值 = "保存的属性值";

    @Autowired
    private MongoCRUDDao mongoCRUDDao;

    @Override
    public void 初始化记录内置功能属性() {
        内置功能实体 obj = new 内置功能实体();
        obj.set功能名(getClasName()).set参数名1(保存的对象).set参数名2(保存的属性).set结果名(保存的属性值);
        异步初始化类.初始化记录内置功能属性(obj);
    }

    @Override
    public void 功能() {
        String 保存的对象 = 获取最近的属性值(所有逻辑对象, this.保存的对象);
        String 保存的属性 = 获取最近的属性值(所有逻辑对象, this.保存的属性);
        String 保存的属性值 = 获取最近的属性值(所有逻辑对象, this.保存的属性值);
        静态变量.添加执行层级集合(String.format("%s %s", level, " 保存的对象："+保存的对象.toString()));
        静态变量.添加执行层级集合(String.format("%s %s", level, " 保存的属性："+保存的属性));
        静态变量.添加执行层级集合(String.format("%s %s", level, " 保存的属性值："+保存的属性值));
        Document document = new Document();
        document.put(Cons.词语, 保存的对象);
        document.put(保存的属性, 保存的属性值);
        document.put(Cons.uuidLevel,uuidLevel);
        document.put(Cons.level,level);
        mongoCRUDDao.保存对象(document);
    }
}
