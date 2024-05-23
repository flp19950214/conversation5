package com.kjgs.功能.内置功能;

import com.alibaba.fastjson.JSONArray;
import com.kjgs.功能.功能抽象;
import com.kjgs.工具包.找到当前对象的下一个对象;
import com.kjgs.工具包.筛选集合中的id;
import com.kjgs.工具包.获取对象作用域下标;
import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import org.bson.Document;

import java.util.List;

public class 找 extends 功能抽象 {
    public static void main(String[] args) {

    }

    @Override
    public void 功能() {
        //直接找下一个对象的值

        Document 下一个对象 = 找到当前对象的下一个对象.method(当前逻辑对象);
        //组装查询对象
        Document 查询对象 = new Document();
        查询对象.put(Cons.对象, 下一个对象.getString(Cons.对象));
        List<Document> 查询结果集合 = MongoDao.select(查询对象);
        List<String> 查询结果集合id = 筛选集合中的id.method(查询结果集合);

        Document 新对象 = new Document();
        新对象.put(Cons.父id, 下一个对象.get(Cons.父id));
        新对象.put(Cons.对象,下一个对象.getString(Cons.对象)+当前逻辑对象.getString(Cons.对象));
        新对象.put(Cons.值, 查询结果集合id);
        新对象.put(Cons.下标, 当前逻辑对象.getInteger(Cons.下标));
        新对象.put(Cons.结束下标, 获取对象作用域下标.结束下标(下一个对象));
        MongoDao.insert(新对象);
    }
}
