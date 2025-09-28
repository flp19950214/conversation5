package com.kjgs.conversation2;

import com.kjgs.conversation.mysql.Impl逻辑;
import com.kjgs.conversation.mysql.mapper.逻辑Mapper;
import com.kjgs.枚举.Cons;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class 启动执行初始化数据 {
    @Autowired
    private Impl逻辑 逻辑impl;
    @Autowired
    private 逻辑Mapper 逻辑MapperImpl;
    public void init (){
//        逻辑impl.保存逻辑("《如果》《句子》《以》《如果》《开头》《，》《那就》《把》《句子》《记录成处理逻辑》");
        查询所有逻辑并加载单个逻辑 ();
    }

    public void 查询所有逻辑并加载单个逻辑(){
        List<Document> 所有逻辑 = 逻辑MapperImpl.查询所有逻辑();
//        List<String> 所有逻辑 = new ArrayList(){{
//            add("《如果》《遇到》《一》《，》《并且》《前面1个成分》《是》《后面，》《后面1个成分》《是个成分》《，》《那就》《把》《句子》《中的》《当前词》《替换为》《1》");
////            add("如果遇到成，并且后面1个字是《分》，那就把当前词和后面1个字合并为1个词");
////            add("如果遇到个，并且后面2个字是《成分》，那就把当前词和后面2个字合并为1个词");
////            add("如果遇到一，并且前面1个成分是前面，后面1个成分是个成分，那就把当前词的词语替换为1");
//        }};

        for(Document document: 所有逻辑){
            加载单个逻辑(document.getInteger("id"), document.getString("逻辑"));
        }
        System.out.println("---加载逻辑初始化完成------");
    }


    public void 加载单个逻辑(int index, String luoji){
        静态引用.所有逻辑.put(index, luoji);

        Document 逻辑句子对象 = new Document();
        逻辑句子对象.put(Cons._id, new ObjectId());
        逻辑句子对象.put(Cons.词语, luoji);
        逻辑句子对象.put(Cons.词语类型, Cons.逻辑句子);
        静态引用.所有逻辑句子对象.put(index, 逻辑句子对象.toJson());

        List<String> 格式化逻辑词语 = Tool.生成格式化逻辑对象(luoji);
        if(格式化逻辑词语.size()<3){
            return;
        }
        if(StringUtils.equals(格式化逻辑词语.get(0), Cons.如果)
                && StringUtils.equals(格式化逻辑词语.get(1), Cons.遇到)){
            String 关键词 = 格式化逻辑词语.get(2);
            if(静态引用.关键词与逻辑.containsKey(关键词)){
                MapUtils.getObject(静态引用.关键词与逻辑, 关键词, new TreeSet<>()).add(index);
            }else{
                TreeSet<Integer> hashSet = new TreeSet<>(Comparator.reverseOrder());
                 hashSet.add(index);
                静态引用.关键词与逻辑.put(关键词, hashSet);
            }
        }
        List<String> 格式化逻辑对象 = new ArrayList<>();
        for (int j = 0; j < 格式化逻辑词语.size(); j++) {
            Document 成分对象 = new Document();
            成分对象.put(Cons._id, new ObjectId());
            成分对象.put(Cons.父id, 逻辑句子对象.get(Cons._id));
            成分对象.put(Cons.词语, 格式化逻辑词语.get(j));
            成分对象.put(Cons.下标, j);
            成分对象.put(Cons.结束下标, j + 1);
            格式化逻辑对象.add(成分对象.toJson());
        }
        静态引用.所有逻辑句子成分对象.put(index, 格式化逻辑对象);
    }

    public List<Document> 获取同词语的逻辑集合(int index){
        List<String> strings = 静态引用.所有逻辑句子成分对象.get(index);
        List<Document> result = new ArrayList<>();
        for(String m: strings){
            result.add(Document.parse(m));
        }
        return result;
    }
}
