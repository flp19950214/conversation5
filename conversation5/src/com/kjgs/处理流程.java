package com.kjgs;

import com.kjgs.功能.功能抽象;
import com.kjgs.工具包.拼接字符串;
import com.kjgs.数据库.MongoDao;
import com.kjgs.数据库.Mongo词语在句子中;
import com.kjgs.枚举.Cons;
import org.apache.commons.collections4.CollectionUtils;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * 1,常用字段有 父id id,对象，值，
 * 2,组合动作和参数 形成新的对象，对象的值就是处理结果
 */
public class 处理流程 {
    public static void main(String[] args) {
//        String input = "岁的词性是名词";
        String input = "你";
        Document 输入对象 = new Document();
        输入对象.put(Cons.对象, input);
        ObjectId 输入对象id = MongoDao.insert(输入对象);
        String[] senArr = input.split("");
        for (int i = 0; i < senArr.length; i++) {

            Document 输入成员对象 = new Document();
            输入成员对象.put(Cons.父id, 输入对象id);
            输入成员对象.put(Cons.对象, senArr[i]);
            ObjectId 输入成员对象id = MongoDao.insert(输入成员对象);

            String 怎么找待处理对象的处理逻辑 = Cons.怎么找待处理对象的处理逻辑;
            Document 逻辑对象 = 找处理逻辑.找处理逻辑(怎么找待处理对象的处理逻辑);
            逻辑对象.put(Cons.父id, 输入成员对象id);
            逻辑对象.put(Cons.对象, 怎么找待处理对象的处理逻辑);
            ObjectId 输入成员对象的处理对象id = MongoDao.insert(逻辑对象);

            执行逻辑(输入成员对象, 逻辑对象);
        }
    }


    public static void 执行逻辑(Document 逻辑对象){
        //找到逻辑中所有成员
        String 逻辑 = 逻辑对象.getString(Cons.对象);
        List<Document> 逻辑成员集合 = Mongo词语在句子中.查询在句子中的(Cons.对象, 逻辑);
        循环执行功能(逻辑成员集合);
    }

    public static void 循环执行功能(List<Document> 逻辑成员集合){
        for (int i = 0; i < 逻辑成员集合.size(); i++) {
            Document 逻辑成员 = 逻辑成员集合.get(i);
            Document 逻辑对象 = new Document();
            逻辑对象.put(Cons.父id, 逻辑成员.get(Cons.父id));
            逻辑对象.put(Cons.对象, 拼接字符串.拼接(逻辑成员.getString(Cons.对象), Cons.的, Cons.处理逻辑));
            逻辑对象.put(Cons.值, Cons.怎么判断待处理对象是否是内置动作);
            执行功能(逻辑成员);
        }
    }

    //你 -》 你的处理逻辑=怎么判断待处理对象是否是内置动作 -》  怎么判断待处理对象是否是内置动作 -》 真实的处理逻辑
    public static void 逻辑中转(Document 待处理对象, String 逻辑语句){
        Document 逻辑对象 = new Document();
        逻辑对象.put(Cons.父id, 待处理对象.get(Cons.id));
        逻辑对象.put(Cons.对象, 拼接字符串.拼接(待处理对象.getString(Cons.对象), Cons.的, Cons.处理逻辑));
        逻辑对象.put(Cons.值, Cons.怎么判断待处理对象是否是内置动作);


        ObjectId 输入对象id = MongoDao.insert(逻辑对象);
        Document 逻辑对象2 = new Document();
        逻辑对象2.put(Cons.父id, 逻辑对象.get(Cons.id));
        逻辑对象2.put(Cons.对象, 拼接字符串.拼接(待处理对象.getString(Cons.对象), Cons.的, Cons.处理逻辑));
        逻辑对象2.put(Cons.值, Cons.怎么判断待处理对象是否是内置动作);
        ObjectId 输入对象id = MongoDao.insert(逻辑对象2);
    }

    public static void 执行功能(Document 功能对象){
        String 动作名 = null;
        try {
            功能抽象 功能抽象对象 = (功能抽象) Class.forName("com.kjgs.功能.内置功能." + 动作名).newInstance();
            功能抽象对象.执行流程(功能对象);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Document 直接找逻辑(String value){
        List<Document> 逻辑集合 = MongoDao.select(Cons.对象, value);
        if(CollectionUtils.isEmpty(逻辑集合)){
            return null;
        }
        return 逻辑集合.get(0);
    }
}
