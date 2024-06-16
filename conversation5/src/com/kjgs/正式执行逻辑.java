package com.kjgs;

import org.bson.Document;
import org.junit.Test;

/**
 * 最重要的是：
 * 保存和更新逻辑：保存且不说，更新是要根据前面的语句判断出要更新的数据id, 然后再更新，具有可行性
 *
 * 保存逻辑的存储方式：就和对象放一起
 */
public class 正式执行逻辑 {

    @Test
    public void test(){
        String sen = "如果";
        //用第一个词执行
        Document document = new Document();
        document.put("待处理对象所在的句子", sen);
        执行逻辑.所有逻辑对象.add(document);

        String 待处理的词语 = sen.substring(0,1);
        Document document3 = new Document();
        document3.put("待处理的对象", 待处理的词语);
        执行逻辑.所有逻辑对象.add(document3);

        Document document2 = new Document();
        document2.put("待处理对象在句子中的下标", 0);
        执行逻辑.所有逻辑对象.add(document2);

//        do {
//            公共逻辑.执行所有公共逻辑();
//            执行当前词语相关逻辑.method();
//        }while ()
    }

}
