package com.kjgs;

import com.kjgs.功能.功能对象;
import com.kjgs.功能.功能抽象;
import com.kjgs.数据库.MongoDao;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.ObjectUtils;
import org.bson.Document;
import org.junit.Test;

import java.util.List;

public class 公共逻辑 {
    private  final static String 公共逻辑 = "公共逻辑";
    @Test
    public void 公共逻辑test(){
        Document 待处理对象所在句子 = new Document();
        待处理对象所在句子.put(Cons.待处理对象所在句子, "如果");
        执行逻辑.所有逻辑对象.add(待处理对象所在句子);
        Document 待处理的对象值 = new Document();
        待处理的对象值.put(Cons.待处理的对象, "如");
        执行逻辑.所有逻辑对象.add(待处理的对象值);
        执行所有公共逻辑();
    }

    public static void 执行所有公共逻辑(){
        //执行所有公共逻辑
        List<Document> select = MongoDao.select(Cons.对象, 公共逻辑);
        for(Document document : select){
            //逻辑有判断条件就先执行判断条件，没有直接执行处理逻辑
            if(ObjectUtils.isEmpty(document.get(Cons.处理逻辑的判断条件))){
                //直接执行结果
                if(ObjectUtils.isNotEmpty(document.get(Cons.处理逻辑))){
                    执行逻辑.执行逻辑(document.getString(Cons.处理逻辑));
                }
            }else{
                //判断条件的处理结果是true才执行处理逻辑
                执行逻辑.执行逻辑(document.getString(Cons.处理逻辑的判断条件));
                功能对象 功能对象 = new 功能对象();
                String 判断的结果 = 功能对象.获取最近的属性值(执行逻辑.所有逻辑对象, Cons.判断的结果);
                if(Boolean.parseBoolean(判断的结果)){
                    //直接执行结果
                    if(ObjectUtils.isNotEmpty(document.get(Cons.处理逻辑))){
                        执行逻辑.执行逻辑(document.getString(Cons.处理逻辑));
                    }
                }
            }
        }
    }


    @Test
    public void test2(){
        Document document = new Document();
        document.put(Cons.对象,"公共逻辑");
        document.put(Cons.处理逻辑,"￥{查询这个词的类型}"); //有点公共逻辑 没有条件 直接执行即可
        MongoDao.insert(document);
    }


}
