package com.kjgs.conversation2;

import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Comparator;

public class Tool {
    public static Document 指定下标前面的逻辑成分(int 下标){
        //过滤出小于下标的，然后排序，找出第一条
        Document result =  静态引用.逻辑句子的成分集合.stream()
                .filter(m -> m.containsKey(Cons.下标))
                .filter (m -> m.getInteger(Cons.下标) < 下标)
                .sorted((a,b) -> b.getInteger(Cons.下标) -  a.getInteger(Cons.下标))
                .findFirst().orElse(null);
        return 代词的最终指向(result);
    }
    public static Document 指定下标后面的逻辑成分(int 下标){
        Document result =  静态引用.逻辑句子的成分集合.stream()
                .filter(m -> m.containsKey(Cons.下标))
                .filter (m -> m.getInteger(Cons.下标) > 下标)
                .sorted((a,b) -> a.getInteger(Cons.下标) -  b.getInteger(Cons.下标))
                .findFirst().orElse(null);
        return 代词的最终指向(result);
    }
    public static Document 指定下标的下下一个逻辑成分(int 下标){
        Document 指定下标后面的逻辑成分 = 指定下标后面的逻辑成分(下标);
        Document result = null;
        if(指定下标后面的逻辑成分 != null){
            result = 指定下标后面的逻辑成分(指定下标后面的逻辑成分.getInteger(Cons.下标));
        }
        return 代词的最终指向(result);
    }
    public static Document 指定下标的逻辑成分(int 下标){
        Document result =  静态引用.逻辑句子的成分集合.stream()
                .filter (m -> m.getInteger(Cons.下标) == 下标)
                .findFirst().orElse(null);
        return 代词的最终指向(result);
    }
    public static Document 指定词语的逻辑成分(String 词语){
        Document result =  静态引用.逻辑句子的成分集合.stream()
                .filter (m -> StringUtils.equals(m.getString(Cons.词语), 词语))
                .findFirst().orElse(null);
        return 代词的最终指向(result);
    }
    public static void 删除指定范围下标的逻辑成分(int 下标,int 结束下标){
        for (int i = 0; i < 结束下标; i++) {
            删除指定下标的逻辑成分(i);
        }

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
                document.put(Cons.句型的下标, 开始下标);
                document.put(Cons.句型的结束下标, 开始下标);
            }
        }
    }
    public static void 赋值后面所有逻辑成分的句型(int 开始下标, String 句型){
        for (int i = 0; i < 静态引用.逻辑句子的成分集合.size(); i++) {
            Document document = 静态引用.逻辑句子的成分集合.get(i);
            if(document.getInteger(Cons.下标) >= 开始下标 ){
                document.put(Cons.句型, 句型);
                document.put(Cons.句型的下标, 开始下标);
            }
        }
    }
    public static void 赋值指定范围的逻辑成分的判断结果(int 开始下标, int 结束下标, boolean 判断结果){
        for (int i = 0; i < 静态引用.逻辑句子的成分集合.size(); i++) {
            Document document = 静态引用.逻辑句子的成分集合.get(i);
            if(document.getInteger(Cons.句型的下标) >= 开始下标
                    && document.getInteger(Cons.句型的结束下标) <= 结束下标){
                document.put(Cons.判断的结果, 判断结果);
            }
        }
    }

    public static Document 代词的最终指向(Document document){
        if(document != null && document.containsKey(Cons.指向id)){
            Document document1 = document.get(Cons.指向id, Document.class);
            return 代词的最终指向(document1);
        }else{
            return document;
        }
    }

}
