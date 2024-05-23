package com.kjgs.工具包;

import com.kjgs.枚举.Cons;
import org.bson.Document;

import java.util.List;

public class 找到当前对象的上一个对象 {
    public static void main(String[] args) {

    }

    public static Document method(Document 当前对象){
        List<Document> 句子所有对象 = 根据父id找到所有子成员.method(当前对象);
        Integer 当前对象下标 = 当前对象.getInteger(Cons.下标);
        if(当前对象下标 == null){
            return null;
        }
        for (int i = 0; i < 句子所有对象.size(); i++) {
            //直接找到结束下标是当前对象下标减1的对象
            Document 临时对象 = 句子所有对象.get(i);
            Integer 临时对象结束下标 = 临时对象.getInteger(Cons.结束下标);
            if(临时对象结束下标 == null){
                continue;
            }
            if(临时对象结束下标 + 1 == 当前对象下标){
                return 临时对象;
            }
        }
        return null;
    }
}
