package com.kjgs.工具包;

import com.alibaba.fastjson.JSONArray;
import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import org.bson.Document;

import java.util.List;

public class 根据父id找到所有子成员 {
    public static void main(String[] args) {

    }

    public static List<Document> method(String 父id){
        List<Document> 所有子成员 = MongoDao.select(Cons.父id, 父id);
        return 所有子成员;
    }
    public static List<Document> method(Document 当前对象){
        List<Document> 所有子成员 = MongoDao.select(Cons.父id, 当前对象.get(Cons.父id));
        return 所有子成员;
    }

}
