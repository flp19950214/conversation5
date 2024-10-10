package com.kjgs.逻辑流程;

import com.kjgs.功能.功能对象;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 最重要的是：
 * 保存和更新逻辑：保存且不说，更新是要根据前面的语句判断出要更新的数据id, 然后再更新，具有可行性
 *
 * 保存逻辑的存储方式：就和对象放一起
 */
@Service
public class 正式执行逻辑 {
    @Autowired
    private 执行逻辑 执行逻辑;
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

        执行逻辑();
    }

    public void 执行逻辑(){
        String temp待处理的对象=null;
        int temp待处理的对象在所有对象中的下标=0;
        do {
            功能对象 空对象 = new 功能对象();
            //获取新对象逻辑
            String 待处理的对象 = 空对象.获取最近的属性值(执行逻辑.所有逻辑对象, Cons.待处理的对象);
            if(StringUtils.equals(temp待处理的对象, 待处理的对象)
                    && temp待处理的对象在所有对象中的下标 == 功能对象.属性在所有对象中的下标){
                return;
            }else {
                temp待处理的对象 = 待处理的对象;
            }
            执行当前词语相关逻辑.method();
        }while (true);
    }

}
