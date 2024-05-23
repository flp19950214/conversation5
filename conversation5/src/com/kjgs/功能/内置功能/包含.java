package com.kjgs.功能.内置功能;

import com.kjgs.功能.功能抽象;
import com.kjgs.工具包.找到当前对象的上一个对象;
import com.kjgs.工具包.找到当前对象的下一个对象;
import com.kjgs.工具包.获取对象作用域下标;
import com.kjgs.工具包.拼接字符串;
import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import org.bson.Document;

public class 包含 extends 功能抽象 {
    @Override
    public void 功能() {
        //上一个对象 包含 后一个对象
        Document 上一个对象 = 找到当前对象的上一个对象.method(当前逻辑对象);
        Document 下一个对象 = 找到当前对象的下一个对象.method(当前逻辑对象);
        Document 新对象 = new Document();
        新对象.put(Cons.父id, 上一个对象.get(Cons.父id));
        新对象.put(Cons.对象,
                拼接字符串.拼接(上一个对象.getString(Cons.对象),
                        当前逻辑对象.getString(Cons.对象),
                        下一个对象.getString(Cons.对象)));
        新对象.put(Cons.值, 上一个对象.getString(Cons.对象).contains(下一个对象.getString(Cons.对象)));
        新对象.put(Cons.下标, 上一个对象.getInteger(Cons.下标));
        新对象.put(Cons.结束下标, 获取对象作用域下标.结束下标(下一个对象));
        MongoDao.insert(新对象);
    }
}
