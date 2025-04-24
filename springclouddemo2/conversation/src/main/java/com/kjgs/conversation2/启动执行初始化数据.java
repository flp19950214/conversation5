package com.kjgs.conversation2;

import com.alibaba.fastjson.JSON;
import com.kjgs.conversation.mysql.Impl逻辑;
import com.kjgs.conversation.mysql.mapper.逻辑Mapper;
import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class 启动执行初始化数据 {
    @Autowired
    private Impl逻辑 逻辑impl;
    @Autowired
    private 逻辑Mapper 逻辑MapperImpl;
    public void init (){
        逻辑impl.保存逻辑("如果句子以如果开头，那就把句子记录成处理逻辑");
        生成格式化逻辑对象();
    }

    public void 生成格式化逻辑对象(){
        List<String> 所有逻辑 = 逻辑MapperImpl.查询所有逻辑();
//        List<String> 所有逻辑 = new ArrayList(){{
//            add("《如果》《遇到》《一》《，》《并且》《前面》《1》《个成分》《是》《后面》《，》《后面》《1》《个成分》《是》《个成分》《，》《那就》《把》《句子》《中的》《当前词》《替换为》《1》");
////            add("如果遇到成，并且后面1个字是《分》，那就把当前词和后面1个字合并为1个词");
////            add("如果遇到个，并且后面2个字是《成分》，那就把当前词和后面2个字合并为1个词");
////            add("如果遇到一，并且前面1个成分是前面，后面1个成分是个成分，那就把当前词的词语替换为1");
//        }};
        for (int i = 0; i <所有逻辑.size() ; i++) {
            静态引用.所有逻辑.put(i, 所有逻辑.get(i));

            Document 逻辑句子对象 = new Document();
            逻辑句子对象.put(Cons._id, new ObjectId());
            逻辑句子对象.put(Cons.词语, 所有逻辑.get(i));
            逻辑句子对象.put(Cons.词语类型, Cons.逻辑句子);
            静态引用.所有逻辑句子对象.put(i, JSON.toJSONString(逻辑句子对象));

            List<String> 格式化逻辑词语 = Tool.生成格式化逻辑对象(所有逻辑.get(i));
            List<Document> 格式化逻辑对象 = new ArrayList<>();
            for (int j = 0; j < 格式化逻辑词语.size(); j++) {
                Document 成分对象 = new Document();
                成分对象.put(Cons._id, new ObjectId());
                成分对象.put(Cons.父id, 逻辑句子对象.get(Cons._id));
                成分对象.put(Cons.词语, 格式化逻辑词语.get(j));
                成分对象.put(Cons.下标, j);
                成分对象.put(Cons.结束下标, j + 1);
                格式化逻辑对象.add(成分对象);
            }
            静态引用.所有逻辑句子成分对象.put(i, JSON.toJSONString(格式化逻辑对象));
        }
        System.out.println("---加载逻辑初始化完成------");
    }
}
