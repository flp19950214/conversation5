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
 * 1,常用字段有 父id id,对象，值
 * 2,组合动作和参数 形成新的对象，对象的值就是处理结果
 * 3,解决逻辑自洽问题：用已知的内置逻辑 解答未知 语句 如 你 -》怎么找待处理对象的处理逻辑
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
            中转逻辑.已知逻辑处理未知语句(输入成员对象id.toString(), senArr[i], Cons.找待处理对象的处理逻辑);
        }
    }


    public static void 执行逻辑(Document 逻辑对象){
        //找到逻辑中所有成员
        String 逻辑 = 逻辑对象.getString(Cons.对象);
        String 逻辑id = 逻辑对象.getString(Cons.id);
        List<Document> 逻辑成员集合 = Mongo词语在句子中.查询在句子中的(Cons.对象, 逻辑);
        if(CollectionUtils.isEmpty(逻辑成员集合)){
            return;
        }
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
            String 逻辑id = 逻辑成员.getString(Cons.id);
            中转逻辑.已知逻辑处理未知语句(逻辑id, 成员对象, Cons.判断待处理对象是否是内置动作);
            //不管怎么转，(当前对象id + “${当前成员对象}+是否是内置动作”  能够查出值)

            //查询是否执行判断结果
            boolean 是否执行 = true;
            if(是否执行){
                执行功能(逻辑成员);
            }
        }
    }

    public static boolean 查询是否是内置动作(String 父逻辑id, String 对象){
        Document 查询条件 = new Document();
        查询条件.put(Cons.父id, 父逻辑id)
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
