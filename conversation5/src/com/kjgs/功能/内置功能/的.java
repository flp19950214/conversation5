package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.工具包.找到当前对象的上一个对象;
import com.kjgs.工具包.找到当前对象的下一个对象;
import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import org.bson.Document;

public class 的 extends 功能抽象 {
    @Override
    public void 功能() {
        //前一个对象 + 后一个对象 = 组成新对象
        Document 上一个对象 = 找到当前对象的上一个对象.method(当前逻辑对象);
        Document 下一个对象 = 找到当前对象的下一个对象.method(当前逻辑对象);
        Document 新对象 = new Document();
        新对象.put(Cons.父id, 上一个对象.get(Cons.父id));
        新对象.put(Cons.对象,上一个对象.getString(Cons.对象)+当前逻辑对象.getString(Cons.对象)+下一个对象.getString(Cons.对象));
        新对象.put(Cons.下标, 上一个对象.getInteger(Cons.下标));
        MongoDao.insert(新对象);
    }
}
