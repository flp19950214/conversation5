package com.kjgs;

import com.kjgs.功能.功能抽象;
import com.kjgs.工具包.拼接字符串;
import com.kjgs.数据库.MongoDao;
import com.kjgs.数据库.Mongo词语在句子中;
import com.kjgs.枚举.Cons;
import com.mongodb.Mongo;
import org.apache.commons.collections4.CollectionUtils;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.UUID;

/**
 * 1,常用字段有 父id id,对象，值
 * 2,组合动作和参数 形成新的对象，对象的值就是处理结果
 * 3,解决逻辑自洽问题：用已知的内置逻辑 解答未知 语句 如 你 -》怎么找待处理对象的处理逻辑
 * 4,字段“值"的value 只能是objectId
 */

/**
 * 1,输入句子，入库，分割句子
 * 2，循环每个词，依次入库
 * 3，为每个词生成 找到待处理对象的处理逻辑  并为处理逻辑 生成待处理对象
 * 4，查 “找到待处理对象的处理逻辑”的真是处理逻辑
 * 5，执行逻辑 ：先查逻辑中的可能所有逻辑成员，依次执行逻辑成员功能
 * 6，结束
 */
public class 处理流程 {
    public static void init(){
        if(MongoDao.select(Cons._id, Cons.找待处理对象的处理逻辑_id)==null){
            Document 初始对象1 = new Document();
            初始对象1.put(Cons._id, Cons.找待处理对象的处理逻辑_id);
            初始对象1.put(Cons.对象, Cons.找待处理对象的处理逻辑);
            MongoDao.insert(初始对象1);
        }
        if(MongoDao.select(Cons._id, Cons.找待处理对象的处理逻辑_id)==null){
            Document 初始对象1 = new Document();
            初始对象1.put(Cons._id, Cons.找待处理对象的处理逻辑_id);
            初始对象1.put(Cons.对象, Cons.找待处理对象的处理逻辑);
            MongoDao.insert(初始对象1);
        }
    }
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
            中转逻辑.已知逻辑处理未知语句(输入成员对象id.toString(), senArr[i], Cons.找待处理对象的处理逻辑_id);
        }
    }


    public static void 执行逻辑(Document 逻辑对象){
        //找到逻辑中所有成员
        String 逻辑 = 逻辑对象.getString(Cons.对象);
        ObjectId 逻辑id = 逻辑对象.getObjectId(Cons._id);
        List<Document> 逻辑成员集合 = Mongo词语在句子中.查询在句子中的(Cons.对象, 逻辑);
        if(CollectionUtils.isEmpty(逻辑成员集合)){
            return;
        }
        // todo 加下标
        //重新给逻辑成员赋值父id
        逻辑成员集合.stream().forEach(m -> {
            m.put(Cons.父id, 逻辑id);
        });
        循环执行功能(逻辑成员集合);
    }

    public static void 循环执行功能(List<Document> 逻辑成员集合){
        for (int i = 0; i < 逻辑成员集合.size(); i++) {
            Document 逻辑成员 = 逻辑成员集合.get(i);
            String 成员对象 = 逻辑成员.getString(Cons.对象);
            执行功能(逻辑成员);
        }
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
}
