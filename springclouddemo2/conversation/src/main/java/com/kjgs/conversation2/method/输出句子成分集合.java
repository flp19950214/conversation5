package com.kjgs.conversation2.method;

import com.alibaba.fastjson.JSON;
import com.kjgs.conversation2.静态引用;
import com.kjgs.枚举.Cons;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class 输出句子成分集合 {


    public Object method (String str){
        if(!StringUtils.equals(str, "输出句子成分集合")){
            return null;
        }
        if(CollectionUtils.isEmpty(静态引用.输入句子的成分集合)){
            return null;
        }else{
            静态引用.输入句子的成分集合.forEach(m -> {
                m.remove(Cons._id);
                m.remove(Cons.父id);
            });
//            List<Document> collect = 静态引用.输入句子的成分集合.stream().map(m -> {
//                Document document = new Document();
//                document.put(Cons.词语, m.get(Cons.词语));
//                document.put(Cons.词性, m.get(Cons.词性));
//                document.put(Cons.新成分的处理逻辑, m.get(Cons.新成分的处理逻辑));
//                m.entrySet().stream().forEach(m1 -> {
//                    if (m1.getKey().contains("更新") && m1.getKey().contains("的处理逻辑")) {
//                        document.put(m1.getKey(), m1.getValue());
//                    }
//                    if (m1.getKey().contains(Cons.指向)) {
//                        document.put(m1.getKey(), m1.getValue());
//                    }
//                    if (m1.getKey().contains(Cons.属于)) {
//                        document.put(m1.getKey(), m1.getValue());
//                    }
//                });
//                document.put(Cons.新成分的处理逻辑, m.get(Cons.新成分的处理逻辑));
//                return document;
//            }).collect(Collectors.toList());
            return JSON.toJSON(静态引用.输入句子的成分集合);
        }
    }
}
