package com.kjgs.conversation2;


import com.beust.ah.A;
import com.kjgs.枚举.Cons;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tool查询 {
    public static void main(String[] args) {
        Document document = new Document();
        document.put(Cons.方位词, Cons.后面);
        document.put(Cons.序号词, 1);
        document.put(Cons.下标, 2);
        document.put(Cons.结束下标, 3);
        document.put(Cons.词性, Cons.名词);

        Document data1 = new Document();
        document.put(Cons.词语, "话");
        document.put(Cons.下标, 1);
        document.put(Cons.结束下标, 2);
        document.put(Cons.词性, Cons.名词);
        Document data2 = new Document();
        data2.put(Cons.词语, "话1");
        data2.put(Cons.下标, 11);
        data2.put(Cons.结束下标, 21);
        data2.put(Cons.词性, Cons.名词);
        Document data3 = new Document();
        data3.put(Cons.词语, "话2");
        data3.put(Cons.下标, 21);
        data3.put(Cons.结束下标, 32);
        data3.put(Cons.词性, Cons.名词);
        List<Document> list = new ArrayList<>();
        list.add(data1);
        list.add(data2);
        list.add(data3);
//        List<Document> 查询集合 = 查询集合(document, list);
        Document 查询集合 = 查询单个目标(document, document,list);
        System.out.println(查询集合);
    }

    public static Document 查询单个目标(Document 逻辑成分, Document 句子成分,List<Document> 句子成分集合) {
        if (逻辑成分.containsKey(Cons.方位词)) {
            //注意 这里是逻辑成分的方位词  但是用的是句子成分的下标
            int 下标 = 句子成分.getInteger(Cons.下标);
            if (StringUtils.equalsAny(逻辑成分.getString(Cons.方位词), Cons.后面,Cons.向后)) {
                句子成分集合 = 句子成分集合.stream()
                        .filter(m -> m.containsKey(Cons.下标))
                        .filter(m -> m.getInteger(Cons.下标) > 下标)
                        .collect(Collectors.toList());
            }else if(StringUtils.equals(逻辑成分.getString(Cons.方位词), Cons.向前)){
                句子成分集合 = 句子成分集合.stream()
                        .filter(m -> m.containsKey(Cons.下标))
                        .filter(m -> m.getInteger(Cons.下标) < 下标)
                        .collect(Collectors.toList());
            }
        }
        if (逻辑成分.containsKey(Cons.词性)) {
            String 词性 = 逻辑成分.getString(Cons.词性);
            句子成分集合 = 句子成分集合.stream()
                    .filter(m -> StringUtils.equalsAny(m.getString(Cons.词性), 词性))
                    .collect(Collectors.toList());
        }
        if (逻辑成分.containsKey(Cons.序号词)) {
            int 序号 = 逻辑成分.getInteger(Cons.序号词)-1;
            if(序号<句子成分集合.size()){
                return 句子成分集合.get(序号);
            }
        }
        return null;
    }
}
