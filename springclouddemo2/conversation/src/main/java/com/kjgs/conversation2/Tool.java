package com.kjgs.conversation2;

import com.kjgs.枚举.Cons;
import org.bson.Document;

public class Tool {
    public static Document 指定下标的逻辑成分(int 下标){
        return 静态引用.逻辑句子的成分集合.stream()
                .filter (m -> m.getInteger(Cons.下标) == 下标)
                .findFirst().orElse(null);
    }
    public static void 删除指定下标的逻辑成分(int 下标){
        for (int i = 0; i < 静态引用.逻辑句子的成分集合.size(); i++) {
            Document document = 静态引用.逻辑句子的成分集合.get(i);
            if(document.getInteger(Cons.下标) == 下标){
                静态引用.逻辑句子的成分集合.remove(i);
            }
        }
    }
    public static void 赋值指定范围的逻辑成分的句型(int 开始下标, int 结束下标, String 句型){
        for (int i = 0; i < 静态引用.逻辑句子的成分集合.size(); i++) {
            Document document = 静态引用.逻辑句子的成分集合.get(i);
            if(document.getInteger(Cons.下标) >= 开始下标 && document.getInteger(Cons.下标) <= 结束下标){
                document.put(Cons.句型, 句型);
            }
        }
    }
    public static void 赋值后面所有逻辑成分的句型(int 开始下标, String 句型){
        for (int i = 0; i < 静态引用.逻辑句子的成分集合.size(); i++) {
            Document document = 静态引用.逻辑句子的成分集合.get(i);
            if(document.getInteger(Cons.下标) >= 开始下标 ){
                document.put(Cons.句型, 句型);
            }
        }
    }
}
